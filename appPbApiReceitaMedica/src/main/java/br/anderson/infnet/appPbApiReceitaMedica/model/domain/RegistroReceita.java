package br.anderson.infnet.appPbApiReceitaMedica.model.domain;

import java.util.List;

public class RegistroReceita {
    private Integer paciente;
    private List<Integer> medicamentos;

    public Integer getPaciente() {
        return paciente;
    }

    public void setPaciente(Integer paciente) {
        this.paciente = paciente;
    }

    public List<Integer> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Integer> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
