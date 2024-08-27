package br.anderson.infnet.apppetfriendspedido.model.repository;

import br.anderson.infnet.apppetfriendspedido.model.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
