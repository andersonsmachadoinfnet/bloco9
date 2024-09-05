package br.anderson.infnet.appPbApiPaciente.model.domain.evento;

import java.util.ArrayList;
import java.util.List;

public class EventoReceitaMedica {
    private            String id;
    private    EventoPaciente paciente;
    private List<EventoMedicamento> medicamentos;

    public EventoReceitaMedica() {
        this.medicamentos = new ArrayList<EventoMedicamento>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EventoPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(EventoPaciente paciente) {
        this.paciente = paciente;
    }

    public List<EventoMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<EventoMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
