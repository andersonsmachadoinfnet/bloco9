package br.anderson.infnet.appPbApiMedicamento.model.domain;

import br.anderson.infnet.appPbApiMedicamento.model.auxiliar.Constantes;
import br.anderson.infnet.appPbApiMedicamento.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appPbApiMedicamento.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appPbApiMedicamento.model.exceptions.ValorInvalidoException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TProcedimento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Procedimento  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties({"usuario","prontuarios","procedimentos"})
    private          Integer id;
    private ProcedimentoTipo tipo;
    private           String descricao;
    private            float valor;
//    @ManyToOne
//    @JoinColumn(name = "idUsuario")

//    private Usuario usuario;

//    @ManyToMany(mappedBy = "procedimentos")
//    private List<Prontuario> prontuarios;

//    public Usuario getUsuario() {
//        return usuario;
//    }

//    public List<Prontuario> getProntuarios() {
//        return prontuarios;
//    }

//    public void setProntuarios(List<Prontuario> prontuarios) {
//        this.prontuarios = prontuarios;
//    }

//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    public void setTipo(ProcedimentoTipo tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Procedimento() {

    }

    public Procedimento(ProcedimentoTipo pTipo, String pDescricao, float pValor)
            throws ValorInvalidoException, DescricaoInvalidaException {
        this();
        this.tipo      = pTipo;
        this.descricao = pDescricao;
        this.valor     = pValor;
        this.id        = -1;

        checaSeValidoOuGeraErro();
    }

   // public abstract float calcularValorDoProcedimento(PacienteTipo pPacienteTp);

    public void checaSeValidoOuGeraErro() throws ValorInvalidoException, DescricaoInvalidaException {
        if (this.valor==0) {
            throw new ValorInvalidoException("Não foi informado um valor para o procedimento!");
        }
        if (this.valor<0) {
            throw new ValorInvalidoException("O valor do procedimento é inválido!");
        }
        if (this.descricao==null || this.descricao.trim()=="") {
            throw new DescricaoInvalidaException("Não foi informado um descritivo para o procedimento!");
        }

    }

    @Override
    public String toString() {
        return new StringBuilder().append(tipo).append(Constantes.SEPARADOR)
                .append(descricao).append(Constantes.SEPARADOR)
                .append(valor).append(Constantes.SEPARADOR)
                .toString();
    }

    public int getId() {
        return this.id;
    }

    public void setId(Integer pId) {
        this.id = pId;
    }

    public ProcedimentoTipo getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }
}
