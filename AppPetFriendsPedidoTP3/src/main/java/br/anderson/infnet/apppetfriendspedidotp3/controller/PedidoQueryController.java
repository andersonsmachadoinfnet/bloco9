package br.anderson.infnet.apppetfriendspedidotp3.controller;

import br.anderson.infnet.apppetfriendspedidotp3.model.domain.Pedido;
import br.anderson.infnet.apppetfriendspedidotp3.service.PedidoQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoQueryController {
    private final PedidoQueryService service;

    public PedidoQueryController(PedidoQueryService service) {
        this.service = service;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id){
        return service.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido obterPorId(@PathVariable(value = "id") String id){
        return service.obterPorId(id).get();
    }
}
