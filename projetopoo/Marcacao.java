package projetopoo;

/**
 * A classe Marcacao gere o agendamento de uma atividade por um sócio,
 * calculando o custo final com base no tipo de sócio (individual ou empresa)
 */
public class Marcacao {

    /**
     * atributos
     */
    private Socio socio;
    private Atividades atividade;
    private Instrutor instrutor;
    private String dataHora;

    /**
     * Construtor da classe Marcacao
     */
    public Marcacao(Socio socio, Atividades atividade, Instrutor instrutor, String dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.instrutor = instrutor;
        this.dataHora = dataHora;
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

    public Socio getSocio(){
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

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

    public String getDataHora() {
        return dataHora;
    }

    public void setData(String dataHora) {
        this.dataHora = dataHora;
    }
}