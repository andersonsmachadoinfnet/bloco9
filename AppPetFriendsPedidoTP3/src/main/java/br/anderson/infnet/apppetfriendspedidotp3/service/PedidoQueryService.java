package br.anderson.infnet.apppetfriendspedidotp3.service;

import br.anderson.infnet.apppetfriendspedidotp3.model.domain.Pedido;
import br.anderson.infnet.apppetfriendspedidotp3.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.axonframework.eventsourcing.eventstore.EventStore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryService {
    @Autowired
    private final EventStore eventStore;
    @Autowired
    private final PedidoRepository _rps;

    public PedidoQueryService(EventStore eventoStore, PedidoRepository rps) {
        this.eventStore = eventoStore;
        this._rps = rps;
    }

    public List<Object> listarEventos(String id) {
        List<Object> retorno = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
        return retorno;
    }

    public Optional<Pedido> obterPorId(String id) {
        return _rps.findById(id);
    }
}
