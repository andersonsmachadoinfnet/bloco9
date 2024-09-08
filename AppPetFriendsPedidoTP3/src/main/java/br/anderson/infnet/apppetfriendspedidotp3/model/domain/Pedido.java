package br.anderson.infnet.apppetfriendspedidotp3.model.domain;

import br.anderson.infnet.apppetfriendspedidotp3.commands.CriarPedidoCommand;
import br.anderson.infnet.apppetfriendspedidotp3.commands.EntregarCommand;
import br.anderson.infnet.apppetfriendspedidotp3.events.PedidoAlterouStatus;
import br.anderson.infnet.apppetfriendspedidotp3.events.PedidoCriado;
import br.anderson.infnet.apppetfriendspedidotp3.model.auxiliar.PedidoStatus;
import jakarta.persistence.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Aggregate
@Entity
public class Pedido implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private       String id;
    private PedidoStatus Status;
    @Column(name="CLIENTE_ID")
    private       Integer idCliente; // Faz referência a outro agregado
    @OneToMany(mappedBy = "pedidoId")
    private List<PedidoItem> pedidoItems = new ArrayList<>();

    public Pedido() {
    }

    @CommandHandler
    public Pedido(CriarPedidoCommand cmd) {
        AggregateLifecycle.apply(new PedidoCriado(cmd.id, cmd.Status, cmd.idCliente, cmd.pedidoItems));
    }

    @EventSourcingHandler
    protected void on(PedidoCriado evt) {
        this.id = evt.id;
        this.Status = evt.Status;
        this.idCliente = evt.idCliente;
        this.pedidoItems = evt.pedidoItems;

        AggregateLifecycle.apply(new PedidoAlterouStatus(this.id, PedidoStatus.ABERTO));
    }

    @CommandHandler
    protected void on(EntregarCommand evt) {
        AggregateLifecycle.apply(new PedidoAlterouStatus(evt.id, PedidoStatus.ENTREGA));
        AggregateLifecycle.apply(new PedidoAlterouStatus(evt.id, PedidoStatus.FINALIZADO));
    }

    protected void on(PedidoStatus evt) {
        this.Status = evt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PedidoStatus getStatus() {
        return Status;
    }

    public void setStatus(PedidoStatus status) {
        Status = status;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<PedidoItem> getPedidoItem() {
        return pedidoItems;
    }

    public void setPedidoItem(List<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }
}
