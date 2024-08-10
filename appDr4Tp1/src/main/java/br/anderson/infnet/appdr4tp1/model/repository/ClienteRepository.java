package br.anderson.infnet.appdr4tp1.model.repository;

import br.anderson.infnet.appdr4tp1.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
