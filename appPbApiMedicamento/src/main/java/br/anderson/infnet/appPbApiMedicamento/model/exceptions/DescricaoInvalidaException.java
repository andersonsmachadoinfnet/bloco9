package br.anderson.infnet.appPbApiMedicamento.model.exceptions;

public class DescricaoInvalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public DescricaoInvalidaException(String mensagem) {
        super(mensagem);
    }

}