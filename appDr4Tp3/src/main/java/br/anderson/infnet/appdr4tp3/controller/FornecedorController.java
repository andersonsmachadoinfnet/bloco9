package br.anderson.infnet.appdr4tp3.controller;

import br.anderson.infnet.appdr4tp3.model.Fornecedor;
import br.anderson.infnet.appdr4tp3.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService _sc;

    @GetMapping
    public Flux<Fornecedor> findAll() {
        return _sc.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Fornecedor> findById(@PathVariable Integer id) {
        return _sc.findById(id);
    }

    @PostMapping
    public Mono<Fornecedor> save(@RequestBody Fornecedor fornecedor) {
        return _sc.save(fornecedor);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return _sc.deleteById(id);
    }
}
