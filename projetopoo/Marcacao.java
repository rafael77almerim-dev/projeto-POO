package projetopoo;

/**
 * A classe Marcacao gere o agendamento de uma atividade por um sócio,
 * calculando o custo final com base no tipo de sócio (individual ou empresa)
 */
public class Marcacao {

    /**
     * atributos
     */
    
    private Atividades atividade;
    private Instrutor instrutor;
    private String data;

    /**
     * Construtor da classe Marcacao
     */
    public Marcacao(Atividades atividade, Instrutor instrutor, String data) {
        this.atividade = atividade;
        this.instrutor = instrutor;
        this.data = data;
    }

    /**
     * Método para calcular o custo final se o sócio for individual
     */
    public double calcularCustoFinal(SocioIndividual socio) {
        double custoBase = atividade.getPrecoBase();
        double percentagemDesconto = socio.calcularDesconto(); // Vai buscar os 10% ou 15%
        
        return custoBase - (custoBase * percentagemDesconto);
    }

    /**
     * Método para calcular o custo final se o sócio for EMPRESA.
     */
    public double calcularCustoFinal(SocioEmpresa socio) {
        double custoBase = atividade.getPrecoBase();
        double percentagemDesconto = socio.calcularDesconto(); // Vai buscar os 20%
        
        return custoBase - (custoBase * percentagemDesconto);
    }

    /**
     * Getters e Setters
     */
    public Atividades getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividades atividade) {
        this.atividade = atividade;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}