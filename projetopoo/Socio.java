package projetopoo;

/**
 * Socio, esta vai ser uma super classe, também com duas sub classes
 */

public class Socio {
    /**
     * atributos
     */
    private String nome;
    private int numeroSocio;
    private String email;

    /**
     * construtor
     */
    public Socio(String nome, int numeroSocio, String email) {
        this.nome = nome;
        this.numeroSocio = numeroSocio;
        this.email = email;
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
     */ 
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        } else {
            System.out.println("Erro: O nome não pode estar vazio");
        }
    }

    public void setNumeroSocio(int numeroSocio) {
        if (numeroSocio > 0) {
            this.numeroSocio = numeroSocio;
        } else {
            System.out.println("Erro: O número de sócio tem de ser positivo");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            System.out.println("Erro: O e-mail não pode estar vazio!");
        }
    }
}