package projetopoo;

// Importamos as classes necessárias do Java para usar listas dinâmicas (coleções)
import java.util.ArrayList;
import java.util.List;

/**
 * A classe Ginasio funciona como o repositório central do sistema
 * É aqui que centralizamos e gerimos todas as coleções de dados do ginásio
 * (sócios, instrutores e atividades)
 */
public class GymPoo {
    
    // Atributos, coleções (ArrayLists) que armazenam os dados de forma dinâmica em memória
    private List<Socio> socios;
    private List<Instrutor> instrutores;
    private List<Atividades> atividades;

    /**
     * Construtor da classe Ginasio
     * Quando criamos um objeto Ginasio, este construtor inicializa as listas vazias
     * (preparando o espaço na memória para receber os dados)
     */
    public GymPoo() {
        this.socios = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    /**
     * Método para adicionar um novo sócio à coleção de sócios do ginásio
     */
    public void adicionarSocio(Socio socio) {
        if (socio != null) {
            socios.add(socio); // O método .add() insere o novo sócio no final do ArrayList dinâmico
            System.out.println("Sócio adicionado com sucesso: " + socio.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar um sócio nulo");
        }
    }

    /**
     * Método para adicionar um novo instrutor à respetiva coleção do ginásio
     */
    public void adicionarInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            instrutores.add(instrutor); // Insere o instrutor na lista dinâmica
            System.out.println("Instrutor adicionado com sucesso: " + instrutor.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar um instrutor nulo");
        }
    }

    /**
     * Método para adicionar uma atividade ou sessão à lista do ginásio
     */
    public void adicionarAtividade(Atividades atividade) {
        if (atividade != null) {
            atividades.add(atividade); // Insere a atividade na coleção
            System.out.println("Atividade adicionada com sucesso: " + atividade.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar uma atividade nula");
        }
    }

    /**
     * Getters, vão permitir consultar ou obter as listas completas de dados 
     */
    public List<Socio> getSocios() {
        return socios;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public List<Atividades> getAtividades() {
        return atividades;
    }
}