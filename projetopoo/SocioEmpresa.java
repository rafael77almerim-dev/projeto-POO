package projetopoo;

/**
 * Representa um sócio do tipo Empresa no sistema POOGym
 * Subclasse de Socio 
 *
 * @author Rafael,Tomás
 * @version 1.0
 */
public class SocioEmpresa extends Socio {

    /**
     *  Nome da empresa parceira
     */
    private String nomeEmpresa;

    /**
     *  NIF da empresa parceira 
    */
    private String nifEmpresa;

    /**
     * Construtor da classe SocioEmpresa
     * Usa o super() para inicializar os atributos herdados da superclasse Socio
     *
     * @param nome Nome do sócio
     * @param numeroSocio Número do sócio
     * @param email E-mail do sócio
     * @param nomeEmpresa Nome da empresa parceira
     * @param nifEmpresa NIF da empresa parceira
     */
    public SocioEmpresa(String nome, int numeroSocio, String email, String nomeEmpresa, String nifEmpresa) {
        super(nome, numeroSocio, email);
        this.nomeEmpresa = nomeEmpresa;
        this.nifEmpresa = nifEmpresa;
    }

    /**
     * Getters
     * Redefine o método da superclasse para devolver o tipo específico "Empresa"
     *
     * @return String "Empresa"
     */
    public String getTipo() {
        return "Empresa";
    }

    /**
     * Devolve a percentagem do desconto fixo corporativo (20%)
     *
     * @return Percentagem de desconto (0.20)
     */
    public double calcularDesconto() {
        return 0.20;
    }

    /**
     * Redefine o método da superclasse para calcular o preço final com 20% de desconto
     *
     * @param precoBase Preço base da atividade
     * @return Preço final com o desconto aplicado
     */
    public double calcularPrecoFinal(double precoBase) {
        return precoBase * (1.0 - calcularDesconto());
    }

    /**
     * Obtém o nome da empresa parceira
     *
     * @return Nome da empresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * Obtém o NIF da empresa parceira
     *
     * @return NIF da empresa
     */
    public String getNifEmpresa() {
        return nifEmpresa;
    }

    /**
     * Define o nome da empresa parceira com validação
     *
     * @param nomeEmpresa Novo nome da empresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        if (nomeEmpresa != null && !nomeEmpresa.trim().isEmpty()) {
            this.nomeEmpresa = nomeEmpresa.trim();
        } else {
            System.out.println("Erro: O nome da empresa não pode estar vazio");
        }
    }

    /**
     * Define o NIF da empresa parceira com validação
     *
     * @param nifEmpresa Novo NIF da empresa
     */
    public void setNifEmpresa(String nifEmpresa) {
        if (nifEmpresa != null && !nifEmpresa.trim().isEmpty()) {
            this.nifEmpresa = nifEmpresa.trim();
        } else {
            System.out.println("Erro: O NIF da empresa não pode estar vazio");
        }
    }
}