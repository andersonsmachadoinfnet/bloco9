package br.anderson.infnet.appPbApiPaciente.model.auxiliar;


import java.time.format.DateTimeFormatter;

public class Constantes {
    public static final String _FMT_DATE_BR_     = "dd/MM/yyyy";
    public static final String _FMT_DATETIME_BR_ = "dd/MM/yyyy HH:mm";

    public static final String SEPARADOR = ";";
    public static final String PREFIXO_CLASSE_PACIENTE   = "P";
    public static final String PREFIXO_CLASSE_PRONTUARIO = "C";
    public static final String PREFIXO_CLASSE_USUARIO    = "U";
    public static final String PREFIXO_CLASSE_PROCEDIMENTO_EXAME = "PE";
    public static final String PREFIXO_CLASSE_PROCEDIMENTO_MEDIC = "PM";
    public static final String PREFIXO_CLASSE_PROCEDIMENTO_CIRUR = "PC";

    public static final String EXAME_NAO_AVALIADO           = "O exame ainda não foi avaliado pelo profissional da área. Tente mais tarde.";
    public static final String PRONTUARIO_DESCRICAO         = "Este prontuário contém informações do Paciente informado.";


    public static final    int INEXISTENTE = -1;

    public static final DateTimeFormatter FMT_DATE_BR() {
        return DateTimeFormatter.ofPattern(_FMT_DATE_BR_);
    }

    public static final DateTimeFormatter FMT_DATETIME_BR() {
        return DateTimeFormatter.ofPattern(_FMT_DATETIME_BR_);
    }
}
