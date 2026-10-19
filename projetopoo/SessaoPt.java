package projetopoo;

/**
 *  SessaoPt, é outra sub classe de Atividades, com o atributo especifico de nivel de treinamento
 */
public class SessaoPt extends Atividades {
    private String nivelTreino;

    /**
     * Contrutor
     */
    public SessaoPt(String nome, String instrutor, String dataHora, int duracao, String nivelTreino){
        super(nome, instrutor, dataHora, duracao, calcularPrecoBase(nivelTreino));
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
    /**
     * metodo
     * @param nivel
     * @return
     */
    private static double calcularPrecoBase(String nivel) {
    switch (nivel.toLowerCase().trim()) {
        case "iniciação":
        case "iniciacao": return 18.00;
        case "intermédio":
        case "intermedio": return 22.00;
        case "avançado":
        case "avancado": return 28.00;
        default:
            System.out.println("Erro: O nível '" + nivel + "' não existe");
            return 0.0;
    }
}
}
