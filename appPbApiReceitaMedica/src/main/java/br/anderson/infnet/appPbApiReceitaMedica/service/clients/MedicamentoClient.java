package br.anderson.infnet.appPbApiReceitaMedica.service.clients;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Medicamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("APPPBAPIMEDICAMENTO")
public interface MedicamentoClient {
    @GetMapping(value = "/{id}")
    public Medicamento getMedicamento(@PathVariable int id);
}
