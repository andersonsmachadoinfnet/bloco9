package br.anderson.infnet.appdr4tp3.repository;

import br.anderson.infnet.appdr4tp3.model.Produto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProdutoRepository extends R2dbcRepository<Produto, Integer> {
}
