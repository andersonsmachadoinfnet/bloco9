package br.anderson.infnet.apppetfriendspedido.Controller;

import br.anderson.infnet.apppetfriendspedido.model.domain.Pedido;
import br.anderson.infnet.apppetfriendspedido.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class PedidoController {
    @Autowired
    private PedidoService _rps;

    @GetMapping(value="")
    public Iterable<Pedido> getPedidos(){
        return _rps.buscarTodos();
    }

    @GetMapping(value="/{id}")
    public Optional<Pedido> getPedidoPorId(Integer id){
        return _rps.buscarPorId(id);
    }

    @PostMapping(value="")
    Pedido novoPedido(@RequestBody Pedido pedido){
        return _rps.salvar(pedido);
    }
}
