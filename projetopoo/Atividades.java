package projetopoo;

/**
 * Superclasse que representa uma atividade genérica do ginásio
 * Serve de base para as subclasses AulaGrupo e SessaoPt
 *
 * @author Tomás, Rafael
 * @version 1.0
 */
public class Atividades {

    /** 
     * Nome da atividade
     */
    private String nome;

    /**
     *  Nome do instrutor responsável 
    */
    private String instrutor; 

    /**
     *  Data e hora de realização da atividade 
    */
    private String dataHora;

    /**
     *  Duração da atividade em minutos
     */
    private int duracao; 

    /**
     *  Preço base da atividade em euros 
    */
    private double precoBase;

    /**
     * Construtor da classe base Atividades
     *
     * @param nome Nome da atividade
     * @param instrutor Nome do instrutor responsável
     * @param dataHora Data e hora da atividade
     * @param duracao Duração em minutos
     * @param precoBase Preço base em euros
     */
    public Atividades(String nome, String instrutor, String dataHora, int duracao, double precoBase) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.precoBase = precoBase;
    }

    /**
     * Devolve o tipo específico de atividade (polimorfismo)
     *
     * @return String com o tipo de atividade
     */
    public String getTipoAtividade() {
        return "Atividade";
    }

    /**
     * Geters
     *
     * @return Nome da atividade
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Nome do instrutor
     */
    public String getInstrutor() {
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
     *
     * @return Duração em minutos
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     *
     * @return Preço base
     */
    public double getPrecoBase() {
        return precoBase;
    }

    /**
     *Setters
     * 
     * @param nome Novo nome da atividade
     */
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) { 
            this.nome = nome.trim();
        } else {
            System.out.println("Erro: O nome não pode estar vazio");
        }
    }

    /**
     *
     * @param instrutor Nome do novo instrutor
     */
    public void setInstrutor(String instrutor) {
        if (instrutor != null && !instrutor.trim().isEmpty()) {
            this.instrutor = instrutor.trim();
        } else {
            System.out.println("Erro: O instrutor não pode estar vazio");
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

    /**
     *
     * @param duracao Duração em minutos
     */
    public void setDuracao(int duracao) {
        if (duracao > 0) {
            this.duracao = duracao; 
        } else {
            System.out.println("Erro: A duração tem de ser um valor positivo");
        }
    }

    /**
     *
     * @param precoBase Preço base da atividade
     */
    public void setPrecoBase(double precoBase) {
        if (precoBase >= 0) {
            this.precoBase = precoBase;
        } else {
            System.out.println("Erro: O preço base não pode ser negativo");
        }
    }

    /**
     * Exibe os detalhes da atividade na consola
     */
    public void exibirDetalhes() {
        System.out.println("Atividade: " + nome + " | Instrutor: " + instrutor + " | Data/Hora: " + dataHora + " (" + duracao + " mins)");
    }
}