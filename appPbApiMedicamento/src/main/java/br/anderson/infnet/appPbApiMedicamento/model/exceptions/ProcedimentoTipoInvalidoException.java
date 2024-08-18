package br.anderson.infnet.appPbApiMedicamento.model.exceptions;

public class ProcedimentoTipoInvalidoException  extends Exception {
    private static final long serialVersionUID = 1L;

    public ProcedimentoTipoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
