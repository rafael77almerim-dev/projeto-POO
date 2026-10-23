package projetopoo;

/**
 * Representa um instrutor do ginásio no sistema POOGy
 * Armazena as informações pessoais e as qualificações/formações do instrutor
 *
 * @author Rafael, Tomás
 * @version 1.0
 */
public class Instrutor {

    /**
     *  Nome do instrutor 
    */
    private String nome;

    /**
     *  Género do instrutor (Masculino ou Feminino)
     */
    private String genero;

    /**
     *  Formações do instrutor 
    */
    private String formacoes;

    /**
     * Construtor da classe Instrutor
     *
     * @param nome Nome do instrutor
     * @param genero Género do instrutor
     * @param formacoes Formações e cursos
     */
    public Instrutor(String nome, String genero, String formacoes) {
        this.nome = nome;
        this.genero = genero;
        this.formacoes = formacoes;
    }

    /**
     * Getters
     *
     * @return Nome do instrutor
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Género do instrutor
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @return Formações do instrutor
     */
    public String getFormacoes() {
        return formacoes;
    }

    /**
     * Setters
     *
     * @param nome Novo nome do instrutor
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
     * @param genero Novo género
     */
    public void setGenero(String genero) {
        if (genero != null && (genero.equalsIgnoreCase("masculino") || genero.equalsIgnoreCase("feminino"))) {
            this.genero = genero.trim();
        } else {
            System.out.println("Erro: O género só pode ser Masculino ou Feminino");
        }
    }

    /**
     *
     * @param formacoes Novas formações/cursos
     */
    public void setFormacoes(String formacoes) {
        if (formacoes != null && !formacoes.trim().isEmpty()) {
            this.formacoes = formacoes.trim();
        } else {
            System.out.println("Erro: A formação não pode estar vazia");
        }
    }
}