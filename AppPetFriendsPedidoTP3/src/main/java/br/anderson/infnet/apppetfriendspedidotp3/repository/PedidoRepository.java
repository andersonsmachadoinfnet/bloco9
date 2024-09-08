package br.anderson.infnet.apppetfriendspedidotp3.repository;

import br.anderson.infnet.apppetfriendspedidotp3.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
