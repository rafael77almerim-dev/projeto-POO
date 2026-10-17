package projetopoo;

/**
 * SocioEmpresa, umsub classe de Socio
 */
public class SocioEmpresa extends Socio {
    /**
     * Atributos
     */
    private String nomeEmpresa;
    private String nifEmpresa;

    /**
     * Construtor, usa super(), para reutilizar o construtor do "pai"
     */
    public SocioEmpresa(String nome, int numeroSocio, String email, String nomeEmpresa, String nifEmpresa) {
        super(nome, numeroSocio, email);
        this.nomeEmpresa = nomeEmpresa;
        this.nifEmpresa = nifEmpresa;
    }
    /**
     * Getters
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getNifEmpresa() {
        return nifEmpresa;
    }
    
    /**
     * Setters
     */
    public void setNomeEmpresa(String nomeEmpresa) {
       if(nomeEmpresa != null && !nomeEmpresa.isEmpty()){
        this.nomeEmpresa = nomeEmpresa;
       }else{
        System.out.println("Erro: O nome da empresa não pode estar vazio");
       }
    }

    public void setNifEmpresa(String nifEmpresa) {
        this.nifEmpresa = nifEmpresa;
    }

    /**
     * Desconto fixo de 20% para empresas parceiras
     */
    public double calcularDesconto() {
        return 0.20;
    }
}
