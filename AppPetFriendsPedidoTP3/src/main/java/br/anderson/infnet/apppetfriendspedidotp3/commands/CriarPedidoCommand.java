package br.anderson.infnet.apppetfriendspedidotp3.commands;

import br.anderson.infnet.apppetfriendspedidotp3.model.auxiliar.PedidoStatus;
import br.anderson.infnet.apppetfriendspedidotp3.model.domain.PedidoItem;

import java.util.List;

public class CriarPedidoCommand extends BaseCommand<String> {
    public     PedidoStatus Status;
    public          Integer idCliente;
    public List<PedidoItem> pedidoItems;

    public CriarPedidoCommand(String id, PedidoStatus Status, Integer idCliente, List<PedidoItem> pedidoItems) {
        super(id);
        this.Status = Status;
        this.idCliente = idCliente;
        this.pedidoItems = pedidoItems;
    }
}
