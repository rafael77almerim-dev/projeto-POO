package projetopoo;

/**
 *  SessaoPt, é outra sub classe de Atividades, com o atributo especifico de nivel de treinamento
 */
public class SessaoPt extends Atividades {
    private String nivelTreino;

    /**
     * Contrutor
     */
    public SessaoPt(String nome, String instrutor, String dataHora, int duracao, Double precoBase, String nivelTreino){
        super(nome, instrutor, dataHora, duracao, precoBase);
        this.nivelTreino = nivelTreino;
    }
    
    /**
     * Getter para o atributo especifíco
     */
    public String getNivelTreino(){
        return nivelTreino;
    }

    /**
     * Setter
     */
    public void setNivelTreino(String nivelTreino){
        if (nivelTreino != null && !nivelTreino.trim().isEmpty()) {
            this.nivelTreino = nivelTreino.trim();
        } else {
            System.out.println("Erro: O nível do treino não pode estar vazio");
        }

    }
}
