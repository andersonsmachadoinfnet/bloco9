package br.anderson.infnet.appdr4tp3.controller;

import br.anderson.infnet.appdr4tp3.model.Produto;
import br.anderson.infnet.appdr4tp3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService _sc;

    @GetMapping
    public Flux<Produto> findAll() {
        return _sc.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Produto> findById(@PathVariable Integer id) {
        return _sc.findById(id);
    }

    @PostMapping
    public Mono<Produto> save(@RequestBody Produto produto) {
        return _sc.save(produto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return _sc.deleteById(id);
    }
}
