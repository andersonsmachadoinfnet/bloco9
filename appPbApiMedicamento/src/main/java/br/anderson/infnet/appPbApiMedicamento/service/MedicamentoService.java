package br.anderson.infnet.appPbApiMedicamento.service;

import br.anderson.infnet.appPbApiMedicamento.model.domain.Medicamento;
import br.anderson.infnet.appPbApiMedicamento.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appPbApiMedicamento.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appPbApiMedicamento.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository repository;

    private void _populaDados() {
        if (repository.count()==0) {
            try {
                repository.save(new Medicamento("Carvedilol 3,125mg",(float)9.75,"Vide bula"));
                repository.save(new Medicamento("Propranolol 40mg",(float)59.90,"Vide bula"));
                repository.save(new Medicamento("Hidrocortisona 100mg frasco-ampola",(float)7.99,"Vide bula"));
            } catch (ValorInvalidoException e) {
                throw new RuntimeException(e);
            } catch (DescricaoInvalidaException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MedicamentoService(){
        super();
    }

    public Medicamento incluir(Medicamento item) {
        item.setId(null);
        return repository.save(item);
    }

    public Optional<Medicamento> ler(Integer key) {
        return repository.findById(key);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Medicamento> obterLista(){
        _populaDados();
        return (Collection<Medicamento>) repository.findAll();
    }

    public Medicamento salvar(Medicamento item) {
        return repository.save(item);
    }

    public long count() {
        return repository.count();
    }
}
