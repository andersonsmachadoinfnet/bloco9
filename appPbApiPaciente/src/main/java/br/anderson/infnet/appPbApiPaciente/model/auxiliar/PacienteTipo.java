package br.anderson.infnet.appPbApiPaciente.model.auxiliar;

public enum PacienteTipo {
    PARTICULAR("Particular"), SUS("SUS"), UNIMED("Unimed");
    private String nome;
    private PacienteTipo(String pNome) {
        this.nome = pNome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public float ratio() {
        if (this==PARTICULAR) {
            return (float) 1.0;
        } else if (this==SUS) {
            return (float) 0.50;
        } else if (this==UNIMED) {
            return (float) 0.75;
        } else
            return 0;
    }
}
