package br.anderson.infnet.appPbApiReceitaMedica.service.clients;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("APPPBAPIPACIENTE")
public interface PacienteClient {
    @GetMapping(value = "/{id}")
    public Paciente getPaciente(@PathVariable int id);
}
