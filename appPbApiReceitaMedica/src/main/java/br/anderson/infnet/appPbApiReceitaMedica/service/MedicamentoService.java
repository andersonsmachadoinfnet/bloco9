package br.anderson.infnet.appPbApiReceitaMedica.service;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Medicamento;
import br.anderson.infnet.appPbApiReceitaMedica.service.clients.MedicamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicamentoService {
    private final MedicamentoClient _api;
    public Medicamento getById(Integer Id) {
        return _api.getMedicamento(Id);
    }
}
