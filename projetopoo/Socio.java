package projetopoo;

/**
 * Representa a classe base para os sócios do sistema POOGym
 * Serve de superclasse para SocioIndividual e SocioEmpresa
 *
 * @author Rafael, Tomás
 * @version 1.0
 */
public class Socio {

    /**
     *  Nome do sócio 
    */
    private String nome;

    /**
     *  Número identificador único do sócio
     */
    private int numeroSocio;

    /**
     *  Endereço de e-mail do sócio
     */
    private String email;

    /**
     * Construtor da classe base Socio
     *
     * @param nome Nome do sócio
     * @param numeroSocio Número do sócio
     * @param email Endereço de e-mail
     */
    public Socio(String nome, int numeroSocio, String email) {
        this.nome = nome;
        this.numeroSocio = numeroSocio;
        this.email = email;
    }

    /**
     * Devolve o tipo de sócio (polimorfismo)
     *
     * @return String com o tipo de sócio
     */
    public String getTipo() {
        return "Sócio";
    }

    /**
     * Calcula o preço final de uma atividade para o sócio (polimorfismo)
     * Nas subclasses, este método aplica os respetivos descontos
     *
     * @param precoBase Preço base da atividade
     * @return Valor final a pagar pelo sócio
     */
    public double calcularPrecoFinal(double precoBase) {
        return precoBase;
    }

    /**
     * Getters
     */
    public String getNome() {
        return nome;
    }


    public int getNumeroSocio() {
        return numeroSocio;
    }

   
    public String getEmail() {
        return email;
    }

    /**
     * Setters
     *
     * @param nome Novo nome a atribuir
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
     * @param numeroSocio Novo número de sócio
     */
    public void setNumeroSocio(int numeroSocio) {
        if (numeroSocio > 0) {
            this.numeroSocio = numeroSocio;
        } else {
            System.out.println("Erro: O número de sócio tem de ser positivo");
        }
    }

    /**
     *
     * @param email Novo e-mail
     */
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            System.out.println("Erro: O e-mail não pode estar vazio");
        }
    }
}