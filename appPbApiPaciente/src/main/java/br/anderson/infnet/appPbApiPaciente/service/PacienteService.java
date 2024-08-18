package br.anderson.infnet.appPbApiPaciente.service;

import br.anderson.infnet.appPbApiPaciente.model.domain.Paciente;
import br.anderson.infnet.appPbApiPaciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    private void _populaDados() {
        if (repository.count()==0) {
            // Nomes criados na plataforma 4Devs
            // link: https://www.4devs.com.br/gerador_de_pessoas
            // aleatorios
            repository.save(new Paciente("Matheus João Galvão","779.151.148-75","matheus_galvao@lognat.com.br","27/01/1971"));
            repository.save(new Paciente("Rayssa Laís Monteiro","779.741.230-87","rayssa.lais.monteiro@vlcorporate.com","12/01/1960"));
            repository.save(new Paciente("Marcos Vinicius Paulo Bryan Assunção","878.442.020-09","marcosviniciusassuncao@igoralcantara.com.br","10/01/1952"));
        }
    }

    public PacienteService(){
        super();
    }

    public Paciente incluir(Paciente item) {
        item.setId(null);
        return repository.save(item);
    }

    public Optional<Paciente> ler(Integer key) {
        return repository.findById(key);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Paciente> obterLista(){
        _populaDados();
        return (Collection<Paciente>) repository.findAll();
    }

    public Paciente salvar(Paciente item) {
        return repository.save(item);
    }

    public long count() {
        return repository.count();
    }
}
