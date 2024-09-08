package br.anderson.infnet.appdr4tp3.service;

import br.anderson.infnet.appdr4tp3.model.Produto;
import br.anderson.infnet.appdr4tp3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository _rps;

    public Flux<Produto> findAll() {
        return _rps.findAll();
    }

    public Mono<Produto> findById(Integer id) {
        return _rps.findById(id);
    }

    public Mono<Produto> save(Produto produto) {
        return _rps.save(produto);
    }

    public Mono<Void> deleteById(Integer id) {
        return _rps.deleteById(id);
    }
}
