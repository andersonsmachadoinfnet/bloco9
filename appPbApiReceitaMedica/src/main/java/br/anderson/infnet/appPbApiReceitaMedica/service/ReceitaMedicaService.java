package br.anderson.infnet.appPbApiReceitaMedica.service;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Medicamento;
import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Paciente;
import br.anderson.infnet.appPbApiReceitaMedica.model.domain.ReceitaMedica;
import br.anderson.infnet.appPbApiReceitaMedica.model.domain.RegistroReceita;
import br.anderson.infnet.appPbApiReceitaMedica.model.rabbitmq.ReceitaProducer;
import br.anderson.infnet.appPbApiReceitaMedica.repository.ReceitaMedicaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReceitaMedicaService {
    private final MedicamentoService medicamentoService;
    private final PacienteService pacienteService;
    private final ReceitaProducer receitaProducer;
    private ReceitaMedicaRepository _rps;

    public ReceitaMedicaService(ReceitaMedicaRepository rps,
                                MedicamentoService medicamentoService,
                                PacienteService pacienteService,
                                ReceitaProducer receitaProducer) {
        this._rps = rps;
        this.medicamentoService = medicamentoService;
        this.pacienteService = pacienteService;
        this.receitaProducer = receitaProducer;
        if (_rps.count() == 0) {
            ReceitaMedica r = new ReceitaMedica();
            Paciente p = new Paciente();
            p.setNome("Fulano");
            Medicamento m = new Medicamento();
            m.setDescricao("Novalgina");
            r.setPaciente(p);
            r.getMedicamentos().add(m);
            _rps.save(r);
        }

    }

    public ReceitaMedica incluir(ReceitaMedica itm) {
        return _rps.save(itm);
    }

    public Collection<ReceitaMedica> obterLista() {
        return _rps.findAll();
    }

    public ReceitaMedica registraReceita(RegistroReceita itm) {
        // Monta a receita consultando dados das outras APIs
        ReceitaMedica lReceita = new ReceitaMedica();
        Paciente p = new Paciente();

        // Pega os dados do Paciente...
        p = pacienteService.getById(itm.getPaciente());
        lReceita.setPaciente(p);

        // Pega os dados dos medicamentos que devem ser inclusos na receita...
        for (Integer lMedId: itm.getMedicamentos()) {
            Medicamento lMedicamento = new Medicamento();
            lMedicamento = medicamentoService.getById(lMedId);
            lReceita.getMedicamentos().add(lMedicamento);
        }

        // Salva a receita e devolve ao client da api...
        try {
            receitaProducer.send(lReceita);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return incluir(lReceita);
    }
}
