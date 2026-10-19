package projetopoo;

/**
* sub classe, da classe Atividades, aqui acrescentamos os atributos modalidade, e capacidade max
*/
public class AulaGrupo extends Atividades {
    /**
     * Atributos
     */
    private String modalidade;
    private int capacidadeMaxima;

    /**
     * Construtor que vai inicializar os atributos especificos, e os da super
     */ 
    public AulaGrupo(String nome, String instrutor, String dataHora, int duracao, String modalidade, int capacidadeMaxima) {
        super(nome, instrutor, dataHora, duracao, calcularPrecoBase(modalidade)); // Reutiliza os atributos da classe(usa o construtor do "pai")
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Getters específicos desta subclasse
     */ 
    public String getModalidade() {
        return modalidade;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * Setters específicos da Aula de Grupo
     */ 
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        if (capacidadeMaxima > 0) {
            this.capacidadeMaxima = capacidadeMaxima;
        } else {
            System.out.println("Erro: A capacidade máxima tem de ser positiva");
        }
    }

    // Método auxiliar para obter o preço da tabela
    private static double calcularPrecoBase(String modalidade) {
        switch (modalidade.toLowerCase().trim()) {
            case "yoga": return 8.00;
            case "spinning": return 9.00;
            case "zumba": return 8.50;
            case "crossfit": return 12.00;
            default: 
               System.out.println("Erro: A modalidade '" + modalidade + "' não existe");
               return 0.0;
        }
    }
}