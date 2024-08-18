package br.anderson.infnet.appPbApiReceitaMedica.model.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="receitamedica")
public class ReceitaMedica {
    @Id
    private            String id;
    private          Paciente paciente;
    private List<Medicamento> medicamentos;

    public ReceitaMedica() {
        this.medicamentos = new ArrayList<Medicamento>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
