package projetopoo;

/**
 * Representa uma aula de grupo no sistema POOGym
 * Subclasse de Atividades 
 *
 * @author Tomás, Rafael
 * @version 1.0
 */
public class AulaGrupo extends Atividades {

    /**
     *  Modalidade da aula de grupo
     */
    private String modalidade;

    /**
     *  Capacidade máxima de participantes na aula
     */
    private int capacidadeMaxima;

    /**
     * Construtor da classe AulaGrupo
     * Reutiliza o construtor da superclasse Atividades, calculando o preço base através da modalidade
     *
     * @param nome Nome da atividade
     * @param instrutor Nome do instrutor responsável
     * @param dataHora Data e hora da aula
     * @param duracao Duração em minutos
     * @param modalidade Nome da modalidade (ex: Yoga, Spinning, Zumba, CrossFit)
     * @param capacidadeMaxima Número máximo de participantes
     */
    public AulaGrupo(String nome, String instrutor, String dataHora, int duracao, String modalidade, int capacidadeMaxima) {
        super(nome, instrutor, dataHora, duracao, calcularPrecoBase(modalidade));
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Redefine o método da superclasse para devolver o tipo específico "Aula de Grupo"
     *
     * @return String "Aula de Grupo"
     */
    @Override
    public String getTipoAtividade() {
        return "Aula de Grupo";
    }

    /**
     *Getters
     *
     * @return Nome da modalidade
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     *
     * @return Capacidade máxima de alunos
     */
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     *Setters
     * 
     * @param modalidade Nova modalidade
     */
    public void setModalidade(String modalidade) {
        if (modalidade != null && !modalidade.trim().isEmpty()) {
            this.modalidade = modalidade.trim();
        } else {
            System.out.println("Erro: A modalidade não pode estar vazia");
        }
    }

    /**
     *
     * @param capacidadeMaxima Nova capacidade máxima
     */
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        if (capacidadeMaxima > 0) {
            this.capacidadeMaxima = capacidadeMaxima;
        } else {
            System.out.println("Erro: A capacidade máxima tem de ser positiva");
        }
    }

    /**
     * Método auxiliar estático para determinar o preço base em função da modalidade
     * 
     * @param modalidade Nome da modalidade
     * @return Preço base em euros (ou 0.0 se for inválida)
     */
    private static double calcularPrecoBase(String modalidade) {
        if (modalidade == null) {
            return 0.0;
        }
        
        switch (modalidade.toLowerCase().trim()) {
            case "yoga": 
                return 8.00;
            case "spinning": 
                return 9.00;
            case "zumba": 
                return 8.50;
            case "crossfit": 
                return 12.00;
            default: 
                System.out.println("Erro: A modalidade '" + modalidade + "' não existe");
                return 0.0;
        }
    }
}