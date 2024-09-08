package br.anderson.infnet.apppetfriendspedidotp3.events;

import br.anderson.infnet.apppetfriendspedidotp3.model.auxiliar.PedidoStatus;

public class PedidoAlterouStatus extends BaseEvent<String> {
    public final PedidoStatus status;
    public PedidoAlterouStatus(String id, PedidoStatus status) {
        super(id);
        this.status = status;
    }
}
