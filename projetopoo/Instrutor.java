package projetopoo;

/**
 * Instrutor, esta classevai ajudar a gerir as informações dos instrutores
 */
public class Instrutor {
    /**
     * Encapsulamento dos atributos
     */
    private String nome;
    private String genero;
    private String formacoes;

    /**
     * construtor
     */
    public Instrutor(String nome, String genero, String formacoes){
        this.nome = nome;
        this.genero = genero;
        this.formacoes = formacoes;
    }

    /**
     * Getteres
     */

    public String getNome(){
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public String getFormacoes(){
        return formacoes;
    }

    /**
     * Setteres
     */

    public void setNome(String nome){
        if( nome != null && !nome.trim().isEmpty()){
           this.nome = nome.trim(); 
        } else{
            System.out.println("Erro: O nome não pode estar vazio ");
        }

    }

    public void setGenero(String genero){
     /**
      * a função equalsIgnoreCase, retorna true se as strings forem iguais(ignora maisculas e minusculas)
      */
     if(genero != null && (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("feminino"))){
        this.genero = genero;
     }else{
        System.out.println("Erro: O género só pode ser Masculino ou Feminino");
     }
    }
    /**
     * se ussasemos arrays seria mais facil controlar os possiveis erros do utilizador, é a melhor opção?
     */
    public void setFormacoes(String formacoes){
        if (formacoes != null && !formacoes.trim().isEmpty()) {
        this.formacoes = formacoes.trim();
        } else {
        System.out.println("Erro: A formação não pode estar vazia");
        }
    }
    
}
