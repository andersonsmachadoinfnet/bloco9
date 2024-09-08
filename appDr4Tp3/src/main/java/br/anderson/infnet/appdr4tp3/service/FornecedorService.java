package br.anderson.infnet.appdr4tp3.service;

import br.anderson.infnet.appdr4tp3.model.Fornecedor;
import br.anderson.infnet.appdr4tp3.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository _rps;

    public Flux<Fornecedor> findAll() {
        return _rps.findAll();
    }

    public Mono<Fornecedor> findById(Integer id) {
        return _rps.findById(id);
    }

    public Mono<Fornecedor> save(Fornecedor fornecedor) {
        return _rps.save(fornecedor);
    }

    public Mono<Void> deleteById(Integer id) {
        return _rps.deleteById(id);
    }
}
