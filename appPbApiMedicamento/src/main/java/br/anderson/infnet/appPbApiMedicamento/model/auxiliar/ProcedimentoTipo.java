package br.anderson.infnet.appPbApiMedicamento.model.auxiliar;

public enum ProcedimentoTipo {
    CIRURGIA("Cirurgia"), EXAME("Exame"), MEDICAMENTO("Medicamento");

    private String nome;
    private ProcedimentoTipo(String pNome) {
        this.nome = pNome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getPrefixo() {
        if (this==CIRURGIA) {
            return Constantes.PREFIXO_CLASSE_PROCEDIMENTO_CIRUR;
        } else if (this==EXAME) {
            return Constantes.PREFIXO_CLASSE_PROCEDIMENTO_EXAME;
        } else if (this==MEDICAMENTO) {
            return Constantes.PREFIXO_CLASSE_PROCEDIMENTO_MEDIC;
        } else
            return "";
    }

    public static ProcedimentoTipo setPrefixo(String pPrefixo) {
        switch (pPrefixo) {
            case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_CIRUR:
                return ProcedimentoTipo.valueOf("CIRURGIA");
            //break;

            case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_EXAME:
                return ProcedimentoTipo.valueOf("EXAME");
            //break;

            case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_MEDIC:
                return ProcedimentoTipo.valueOf("MEDICAMENTO");
            //break;
            default:
                return ProcedimentoTipo.valueOf(pPrefixo);
        }
    }
}

