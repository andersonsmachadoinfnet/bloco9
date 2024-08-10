package br.anderson.infnet.appdr4tp1.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TCliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private    Integer id;
    private  String nome;
    private  String endereco;
    private  String telefone;
    private  String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente assign(Cliente de) {
        this.setEmail(de.getEmail());
        this.setEndereco(de.getEndereco());
        this.setNome(de.getNome());
        this.setTelefone(de.getTelefone());
        return this;
    }
}
