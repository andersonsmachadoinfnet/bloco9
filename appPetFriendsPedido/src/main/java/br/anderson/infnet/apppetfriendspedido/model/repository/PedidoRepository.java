package br.anderson.infnet.apppetfriendspedido.model.repository;

import br.anderson.infnet.apppetfriendspedido.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
