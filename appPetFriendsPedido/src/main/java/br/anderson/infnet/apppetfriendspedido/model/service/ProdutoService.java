package br.anderson.infnet.apppetfriendspedido.model.service;

import br.anderson.infnet.apppetfriendspedido.model.domain.PedidoItem;
import br.anderson.infnet.apppetfriendspedido.model.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private PedidoItemRepository _rps;

    public ProdutoService(PedidoItemRepository rps) {
        _rps = rps;
    }

    public PedidoItem salvar(PedidoItem pedidoItem) {
        return _rps.save(pedidoItem);
    }

    public Optional<PedidoItem> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

    public PedidoItem alterar(PedidoItem pedidoItem) {
        return _rps.save(pedidoItem);
    }

    public Collection<PedidoItem> listar() {
        return _rps.findAll();
    }
}
