package br.anderson.infnet.apppetfriendspedidotp3.controller;

import br.anderson.infnet.apppetfriendspedidotp3.model.domain.Pedido;
import br.anderson.infnet.apppetfriendspedidotp3.service.PedidoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/pedido")
public class PedidoCommandController {
    @Autowired
    private PedidoCommandService _rps;

    public PedidoCommandController(PedidoCommandService rps) {
        this._rps = rps;
    }

    @PostMapping(value = "")
    public CompletableFuture<String> novoPedido(@RequestBody Pedido pedido) {
        return _rps.novoPedido(pedido);
    }

    @PostMapping(value = "/entregar/{id}")
    public CompletableFuture<String> entregar(@PathVariable String id) {
        return _rps.entregar(id);
    }
}