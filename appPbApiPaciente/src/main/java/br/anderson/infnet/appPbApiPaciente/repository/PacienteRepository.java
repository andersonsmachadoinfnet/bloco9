package br.anderson.infnet.appPbApiPaciente.repository;

import br.anderson.infnet.appPbApiPaciente.model.domain.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}
