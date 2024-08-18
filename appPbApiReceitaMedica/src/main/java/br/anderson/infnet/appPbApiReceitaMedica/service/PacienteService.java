package br.anderson.infnet.appPbApiReceitaMedica.service;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.Paciente;
import br.anderson.infnet.appPbApiReceitaMedica.service.clients.PacienteClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteClient _api;
    public Paciente getById(int id) {
        return _api.getPaciente(id);
    }
}
