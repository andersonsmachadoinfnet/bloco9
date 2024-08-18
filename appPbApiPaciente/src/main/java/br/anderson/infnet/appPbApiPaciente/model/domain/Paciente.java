package br.anderson.infnet.appPbApiPaciente.model.domain;

import br.anderson.infnet.appPbApiPaciente.model.auxiliar.Constantes;
import br.anderson.infnet.appPbApiPaciente.model.auxiliar.PacienteTipo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TPaciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private      Integer id;
    private PacienteTipo tipo;
    private       String nome;
    private       String cpf;
    private       String email;
    private    LocalDate dtNasc;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, String email, String dtNasc) {
        super();
        this.tipo   = PacienteTipo.SUS;
        this.nome   = nome;
        this.cpf    = cpf;
        this.email  = email;
        this.dtNasc = LocalDate.parse(dtNasc, Constantes.FMT_DATE_BR());
    }

    @Override
    public String toString() {
        return new StringBuilder().append(nome).append(Constantes.SEPARADOR)
                .append(cpf).append(Constantes.SEPARADOR)
                .append(email).append(Constantes.SEPARADOR)
                .append(dtNasc.format(Constantes.FMT_DATE_BR()))
                .toString();
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PacienteTipo getTipo() {
        return tipo;
    }

    public void setTipo(PacienteTipo tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
