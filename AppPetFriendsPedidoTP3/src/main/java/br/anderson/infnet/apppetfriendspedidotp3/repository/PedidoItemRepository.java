package br.anderson.infnet.apppetfriendspedidotp3.repository;

import br.anderson.infnet.apppetfriendspedidotp3.model.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}

