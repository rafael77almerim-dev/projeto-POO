package projetopoo;

/**
 * Representa uma marcação de uma atividade efetuada por um sócio no sistema POOGym
 * Relaciona os Sócio, Atividades, Instrutores e a data/hora
 *
 * @author Rafael, Tomás
 * @version 1.0
 */
public class Marcacao {

    /**
     *  Sócio associado à marcação
     * 
     */
    private Socio socio;

    /**
     *  Atividade agendada 
     * 
    */
    private Atividades atividade;

    /** 
     * Instrutor responsável pela sessão/aula na marcação
     */
    private Instrutor instrutor;

    /** 
     * Data e hora da marcação
     */
    private String dataHora;

    /**
     * Construtor da classe Marcacao.
     *
     * @param socio Sócio que realiza a marcação
     * @param atividade Atividade a realizar
     * @param instrutor Instrutor responsável
     * @param dataHora Data e hora da marcação
     */
    public Marcacao(Socio socio, Atividades atividade, Instrutor instrutor, String dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.instrutor = instrutor;
        this.dataHora = dataHora;
    }

    /**
     * Calcula o custo final da marcação utilizando polimorfismo.
     * Delega o cálculo do preço com desconto diretamente no objeto Socio
     *
     * @return Valor final a pagar pela marcação em euros
     */
    public double calcularCustoFinal() {
        if (socio != null && atividade != null) {
            return socio.calcularPrecoFinal(atividade.getPrecoBase());
        }
        return 0.0;
    }

    /**
     * Getters
     *
     * @return Objeto Socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     *
     * @return Objeto Atividades
     */
    public Atividades getAtividade() {
        return atividade;
    }

    /**
     *
     * @return Objeto Instrutor
     */
    public Instrutor getInstrutor() {
        return instrutor;
    }

    /**
     *
     * @return Data e hora
     */
    public String getDataHora() {
        return dataHora;
    }

    /**
     * Setters
     *
     * @param socio Novo sócio
     */
    public void setSocio(Socio socio) {
        if (socio != null) {
            this.socio = socio;
        } else {
            System.out.println("Erro: O sócio não pode ser nulo");
        }
    }

    /**
     *
     * @param atividade Nova atividade
     */
    public void setAtividade(Atividades atividade) {
        if (atividade != null) {
            this.atividade = atividade;
        } else {
            System.out.println("Erro: A atividade não pode ser nula");
        }
    }

    /**
     *
     * @param instrutor Novo instrutor
     */
    public void setInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            this.instrutor = instrutor;
        } else {
            System.out.println("Erro: O instrutor não pode ser nulo");
        }
    }

    /**
     *
     * @param dataHora Nova data e hora
     */
    public void setDataHora(String dataHora) {
        if (dataHora != null && !dataHora.trim().isEmpty()) {
            this.dataHora = dataHora.trim();
        } else {
            System.out.println("Erro: A data/hora não pode estar vazia");
        }
    }
}