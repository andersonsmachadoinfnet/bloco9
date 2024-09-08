package br.anderson.infnet.apppetfriendspedidotp3.events;

import br.anderson.infnet.apppetfriendspedidotp3.model.auxiliar.PedidoStatus;
import br.anderson.infnet.apppetfriendspedidotp3.model.domain.PedidoItem;

import java.util.List;

public class PedidoCriado extends BaseEvent<String> {
    public PedidoStatus Status;
    public          Integer idCliente;
    public List<PedidoItem> pedidoItems;

    public PedidoCriado(String id, PedidoStatus Status, Integer idCliente, List<PedidoItem> pedidoItems) {
        super(id);
        this.Status = Status;
        this.idCliente = idCliente;
        this.pedidoItems = pedidoItems;
    }
}
