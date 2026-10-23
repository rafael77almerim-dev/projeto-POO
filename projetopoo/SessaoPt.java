package projetopoo;

/**
 * Representa uma sessão de Personal Trainer (PT) no sistema POOGym.
 * Subclasse de Atividades 
 * 
 * @author Tomás, Rafael
 * @version 1.0
 */
public class SessaoPt extends Atividades {

    /**
     *  Nível do treino da sessão PT (Iniciação, Intermédio ou Avançado)
     */
    private String nivelTreino;

    /**
     * Construtor da classe SessaoPt
     * Reutiliza o construtor da superclasse Atividades, calculando o preço base com base no nível
     *
     * @param nome Nome da atividade
     * @param instrutor Nome do instrutor responsável
     * @param dataHora Data e hora da sessão
     * @param duracao Duração em minutos
     * @param nivelTreino Nível do treino (Iniciação, Intermédio ou Avançado)
     */
    public SessaoPt(String nome, String instrutor, String dataHora, int duracao, String nivelTreino) {
        super(nome, instrutor, dataHora, duracao, calcularPrecoBase(nivelTreino));
        this.nivelTreino = nivelTreino;
    }

    /**
     * Redefine o método da superclasse para devolver o tipo específico "Sessão PT"
     *
     * @return String "Sessão PT"
     */

    public String getTipoAtividade() {
        return "Sessão PT";
    }

    /**
     *
     * @return Nível de treino
     */
    public String getNivelTreino() {
        return nivelTreino;
    }

    /**
     *
     * @param nivelTreino Novo nível de treino
     */
    public void setNivelTreino(String nivelTreino) {
        if (nivelTreino != null && !nivelTreino.trim().isEmpty()) {
            this.nivelTreino = nivelTreino.trim();
        } else {
            System.out.println("Erro: O nível do treino não pode estar vazio");
        }
    }

    /**
     *
     * @param nivel Nível de treino pretendido
     * @return Preço base em euros (ou 0.0 se for inválido)
     */
    private static double calcularPrecoBase(String nivel) {
        if (nivel == null) {
            return 0.0;
        }

        switch (nivel.toLowerCase().trim()) {
            case "iniciação":
                return 18.00;
            case "intermédio":
                return 22.00;
            case "avançado":
                return 28.00;
            default:
                System.out.println("Erro: O nível '" + nivel + "' não existe");
                return 0.0;
        }
    }
}