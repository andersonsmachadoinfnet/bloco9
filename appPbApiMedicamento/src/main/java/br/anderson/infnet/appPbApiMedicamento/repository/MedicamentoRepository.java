package br.anderson.infnet.appPbApiMedicamento.repository;

import br.anderson.infnet.appPbApiMedicamento.model.domain.Medicamento;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
//    @Query("from Medicamento m where m.usuario.id = :userId")
//    List<Medicamento> obterLista(Integer userId, Sort sort);

    @Query("from Medicamento m")
    List<Medicamento> obterLista(Sort sort);
}
