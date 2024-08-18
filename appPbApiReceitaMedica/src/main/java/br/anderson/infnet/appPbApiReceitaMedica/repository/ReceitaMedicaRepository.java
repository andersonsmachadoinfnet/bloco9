package br.anderson.infnet.appPbApiReceitaMedica.repository;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.ReceitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaMedicaRepository extends MongoRepository<ReceitaMedica, String> {
}
