package projetopoo;

/**
* super classe para atividades(vai ter duas sub classes)
*/

public class Atividades {
    /**
     * Atributos privados (Encapsulamento)
     */ 
    private String nome;
    private String instrutor; 
    private String dataHora;
    private int duracao; 

    /**
     *  Construtor (Para inicializar a atividade quando for criada)
     */  
    public Atividades(String nome, String instrutor, String dataHora, int duracao) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.dataHora = dataHora;
        this.duracao = duracao;
    }

    /** 
     *  Getters (permite ler os dados de fora com segurança, mesmo estando os atributos em private)
     */ 
    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    /**
    * Setters (permite alterar os valores, mesmo estando em private)
    */ 
   public void setNome(String nome) {
    /**
     * .trim retira os espaços vazios da string, e .isEmpty retorna true se a string estiver vazia(false se não estiver)
     */
    if (nome != null && !nome.trim().isEmpty()) { 
        this.nome = nome;
    } else {
        System.out.println("Erro: O nome não pode estar vazio!");
    }
}

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public void setDuracao(int duracao) {
    if (duracao > 0) {
        this.duracao = duracao; 
    } else {
        System.out.println("Erro: A duração tem de ser um valor positivo");
    }
}

    /**
     * Este método imrpime todos os atributos desta classe numa linha, vai facilitar a organização e testes
     */ 
    public void exibirDetalhes() {
        System.out.println("Atividade: " + nome + " | Instrutor: " + instrutor + " | Data/Hora: " + dataHora + " (" + duracao + " mins)");
    }
}