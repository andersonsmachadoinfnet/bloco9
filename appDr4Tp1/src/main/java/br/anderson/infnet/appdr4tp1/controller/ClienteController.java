package br.anderson.infnet.appdr4tp1.controller;

import br.anderson.infnet.appdr4tp1.model.domain.Cliente;
import br.anderson.infnet.appdr4tp1.model.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private ClienteService _sc;

    @GetMapping(value="")
    public Iterable<Cliente> getClientes() {
        return _sc.obterLista();
    }

    @GetMapping(value="/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Integer id) {
        return _sc.buscarPorId(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletar(@PathVariable Integer id) {
        _sc.excluir(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Cliente>> setCliente(@RequestBody Cliente itm) {
        Optional<Cliente> lTmp = _sc.buscarPorId(itm.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Cliente>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(_sc.incluir(itm));
            return new ResponseEntity<Optional<Cliente>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Cliente novo(@RequestBody Cliente itm) {
        _sc.incluir(itm);
        return itm;
    }
}
