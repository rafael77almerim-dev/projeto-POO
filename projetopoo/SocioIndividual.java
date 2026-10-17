package projetopoo;

/**
 * SocioIndividual, sub class de Socio
 */
public class SocioIndividual extends Socio {

    /**
     * atributo
     */
    private int anoNascimento;

    /**
     * Construtor que reuiliza o constutor do "pai"(super()), e inicializa o atributo especifico
     */ 
    public SocioIndividual(String nome, int numeroSocio, String email, int anoNascimento) {
        super(nome, numeroSocio, email);
        this.anoNascimento = anoNascimento;
    }
    /**
     * Getter
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }
    
    /**
     * Setter
     */
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
   
    /**
     * Método para calcular o desconto com base na idade 
     * o atributo é apenas o ano de nascimento, ou a data de nascimento?
     */
    public double calcularDesconto() {
        int idade = 2026 - anoNascimento;
        if (idade < 18) {
            return 0.10; // 10% de desconto
        } else if (idade >= 65) {
            return 0.15; // 15% de desconto
        }
        return 0.0; // Sem desconto especial
    }
}
