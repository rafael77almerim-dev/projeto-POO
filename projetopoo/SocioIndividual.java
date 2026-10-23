package projetopoo;

/**
 * Representa um sócio individual no sistema POOGym
 * Subclasse de Socio 
 * 
 * @author Rafael, Tomás
 * @version 1.0
 */
public class SocioIndividual extends Socio {

    /** 
     * Ano de nascimento do sócio 
     */
    private int anoNascimento;

    /**
     * Construtor da classe SocioIndividual
     * Reutiliza o construtor da superclasse Socio via super() e inicializa o ano de nascimento.
     *
     * @param nome Nome do sócio
     * @param numeroSocio Número identificador do sócio
     * @param email E-mail do sócio
     * @param anoNascimento Ano de nascimento
     */
    public SocioIndividual(String nome, int numeroSocio, String email, int anoNascimento) {
        super(nome, numeroSocio, email);
        this.anoNascimento = anoNascimento;
    }

    /**
     * Redefine o método da superclasse para devolver o tipo específico "Individual"
     *
     * @return String "Individual"
     */
    public String getTipo() {
        return "Individual";
    }

    /**
     * Calcula a taxa de desconto com base na idade do sócio
     * (< 18 anos): 10% ,  (>= 65 anos): 15% 
     *
     * @return Percentagem de desconto (0.10, 0.15 ou 0.0)
     */
    public double calcularDesconto() {
        int idade = 2026 - anoNascimento;
        if (idade < 18) {
            return 0.10; 
        } else if (idade >= 65) {
            return 0.15; 
        }
        return 0.0; 
    }

    /**
     * Redefine o método da superclasse para calcular o preço final com o desconto de idaade
     *
     * @param precoBase Preço base da atividade
     * @return Preço final com o desconto aplicado
     */
    public double calcularPrecoFinal(double precoBase) {
        return precoBase * (1.0 - calcularDesconto());
    }

    /**
     * Obtém o ano de nascimento do sócio.
     *
     * @return Ano de nascimento
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * Define o ano de nascimento do sócio com validação.
     *
     * @param anoNascimento Novo ano de nascimento
     */
    public void setAnoNascimento(int anoNascimento) {
        if (anoNascimento > 1900 && anoNascimento <= 2026) {
            this.anoNascimento = anoNascimento;
        } else {
            System.out.println("Erro: Ano de nascimento inválido");
        }
    }
}