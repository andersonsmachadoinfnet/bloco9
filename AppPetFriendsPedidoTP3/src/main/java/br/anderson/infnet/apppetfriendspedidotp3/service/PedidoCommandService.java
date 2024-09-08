package br.anderson.infnet.apppetfriendspedidotp3.service;

import br.anderson.infnet.apppetfriendspedidotp3.commands.CriarPedidoCommand;
import br.anderson.infnet.apppetfriendspedidotp3.commands.EntregarCommand;
import br.anderson.infnet.apppetfriendspedidotp3.model.domain.Pedido;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {
    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> novoPedido(Pedido pedido) {
        return commandGateway.send(
                new CriarPedidoCommand(
                        UUID.randomUUID().toString(),
                        pedido.getStatus(),
                        pedido.getIdCliente(),
                        pedido.getPedidoItem()
                )
        );
    }

    public CompletableFuture<String> entregar(String id) {
        return commandGateway.send(new EntregarCommand(id));
    }
}
