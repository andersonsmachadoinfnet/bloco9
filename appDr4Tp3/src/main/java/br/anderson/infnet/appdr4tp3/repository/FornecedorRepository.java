package br.anderson.infnet.appdr4tp3.repository;

import br.anderson.infnet.appdr4tp3.model.Fornecedor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FornecedorRepository extends R2dbcRepository<Fornecedor, Integer> {
}
