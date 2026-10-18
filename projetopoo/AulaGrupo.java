package projetopoo;

/**
* sub classe, da classe Atividades, aqui acrescentamos os atributos modalidade, e capacidade max
*/
public class AulaGrupo extends Atividades {
    /**
     * Atributos
     * o preço base da modalidade, fazemos manualmente na main(pedindo ao uitlizador)? Ou deixamos automatico aqui
     */
    private String modalidade;
    private int capacidadeMaxima;

    /**
     * Construtor que vai inicializar os atributos especificos, e os da super
     */ 
    public AulaGrupo(String nome, String instrutor, String dataHora, int duracao, Double precoBase, String modalidade, int capacidadeMaxima) {
        super(nome, instrutor, dataHora, duracao, precoBase); // Reutiliza os atributos da classe(usa o construtor do "pai")
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
}