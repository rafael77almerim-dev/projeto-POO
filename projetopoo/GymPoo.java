package projetopoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório central e gestor de dados da aplicação POOGym
 * Centraliza e gere todas as coleções de dados do ginásio em memória
 *
 * @author Tomás, Rafael
 * @version 1.0
 */
public class GymPoo {
    
    /**
     *  Coleção dinâmica de sócios registados no ginásio
     */
    private ArrayList<Socio> socios;

    /**
     *  Coleção dinâmica de instrutores do ginásio
     */
    private ArrayList<Instrutor> instrutores;

    /**
     *  Coleção dinâmica de atividades disponíveis no ginásio 
    */
    private ArrayList<Atividades> atividades;

    /**
     *  Coleção dinâmica de marcações efetuadas pelos sócios
     */
    private ArrayList<Marcacao> marcacoes; 

    /**
     * Construtor da classe GymPoo.
     * Inicializa todas as coleções do ginásio como listas vazias
     */
    public GymPoo() {
        this.socios = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.marcacoes = new ArrayList<>();
    }

    /**
     * Carrega os dados fixos de demonstração no arranque da aplicação.
     * Popula o sistema com 6 sócios (3 Individuais e 3 Empresa), instrutores,
     * 8 atividades e 6 marcações
     */
    public void carregarDados() {
        // 1. Criar e adicionar 6 Sócios (3 Individuais e 3 Empresa)
        SocioIndividual s1 = new SocioIndividual("Joao Silva", 101, "joao.silva@email.com", 1995);
        SocioIndividual s2 = new SocioIndividual("Maria Santos", 102, "maria.santos@email.com", 1950); 
        SocioIndividual s3 = new SocioIndividual("Pedro Alves", 103, "pedro.alves@email.com", 2012);  
        
        SocioEmpresa s4 = new SocioEmpresa("Ana Costa", 104, "ana.costa@tech.pt", "nasa", "501234567");
        SocioEmpresa s5 = new SocioEmpresa("Carlos Rocha", 105, "carlos.rocha@biz.pt", "capas negras", "509876543");
        SocioEmpresa s6 = new SocioEmpresa("Sofia Lima", 106, "sofia.lima@soft.pt", "Rei Da Bola", "502468135");

        socios.add(s1); socios.add(s2); socios.add(s3);
        socios.add(s4); socios.add(s5); socios.add(s6);

        // 2. Criar e adicionar Instrutores
        Instrutor i1 = new Instrutor("Rui Oliveira", "Masculino", "CrossFit / Pilates");
        Instrutor i2 = new Instrutor("Beatriz Lima", "Feminino", "Yoga / Zumba");
        instrutores.add(i1); 
        instrutores.add(i2);

        // 3. Criar e adicionar 8 Atividades (4 Aulas de Grupo e 4 Sessões PT)
        AulaGrupo a1 = new AulaGrupo("Aula de Yoga", i2.getNome(), "25/10/2026 10:00", 60, "Yoga", 15);
        AulaGrupo a2 = new AulaGrupo("Aula de Zumba", i2.getNome(), "26/10/2026 11:00", 45, "Zumba", 20);
        AulaGrupo a3 = new AulaGrupo("Aula de CrossFit", i1.getNome(), "27/10/2026 18:00", 50, "CrossFit", 10);
        AulaGrupo a4 = new AulaGrupo("Aula de Spinning", i1.getNome(), "28/10/2026 19:00", 45, "Spinning", 12);

        SessaoPt a5 = new SessaoPt("Sessão PT - Iniciação", i1.getNome(), "25/10/2026 15:00", 60, "Iniciação");
        SessaoPt a6 = new SessaoPt("Sessão PT - Intermédio", i1.getNome(), "26/10/2026 16:00", 60, "Intermédio");
        SessaoPt a7 = new SessaoPt("Sessão PT - Avançado", i2.getNome(), "27/10/2026 17:00", 60, "Avançado");
        SessaoPt a8 = new SessaoPt("Sessão PT - Intermédio", i2.getNome(), "28/10/2026 14:00", 60, "Intermédio");

        atividades.add(a1); atividades.add(a2); atividades.add(a3); atividades.add(a4);
        atividades.add(a5); atividades.add(a6); atividades.add(a7); atividades.add(a8);

        // 4. Criar e adicionar 6 Marcações
        marcacoes.add(new Marcacao(s1, a1, i2, "25/10/2026 10:00"));
        marcacoes.add(new Marcacao(s2, a2, i2, "26/10/2026 11:00"));
        marcacoes.add(new Marcacao(s3, a3, i1, "27/10/2026 18:00"));
        marcacoes.add(new Marcacao(s4, a5, i1, "25/10/2026 15:00"));
        marcacoes.add(new Marcacao(s5, a6, i1, "26/10/2026 16:00"));
        marcacoes.add(new Marcacao(s6, a7, i2, "27/10/2026 17:00"));
    }

    /**
     * Adiciona um novo sócio à coleção do ginásio
     *
     * @param socio Objeto do tipo Socio a adicionar
     */
    public void adicionarSocio(Socio socio) {
        if (socio != null) {
            socios.add(socio);
            System.out.println("Sócio adicionado com sucesso: " + socio.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar um sócio nulo");
        }
    }

    /**
     * Adiciona um novo instrutor à coleção do ginásio
     *
     * @param instrutor Objeto do tipo Instrutor a adicionar
     */
    public void adicionarInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            instrutores.add(instrutor);
            System.out.println("Instrutor adicionado com sucesso: " + instrutor.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar um instrutor nulo");
        }
    }

    /**
     * Adiciona uma nova atividade à coleção do ginásio
     *
     * @param atividade Objeto do tipo Atividades a adicionar
     */
    public void adicionarAtividade(Atividades atividade) {
        if (atividade != null) {
            atividades.add(atividade);
            System.out.println("Atividade adicionada com sucesso: " + atividade.getNome());
        } else {
            System.out.println("Erro: Não é possível adicionar uma atividade nula");
        }
    }

    /**
     * Adiciona uma nova marcação à coleção do ginásio
     *
     * @param marcacao Objeto do tipo Marcacao a adicionar
     */
    public void adicionarMarcacao(Marcacao marcacao) {
        if (marcacao != null) {
            marcacoes.add(marcacao);
            System.out.println("Marcação efetuada com sucesso");
        } else {
            System.out.println("Erro: Não é possível adicionar uma marcação nula");
        }
    }

    /**
     * Getteres
     *
     * @return Lista contendo os sócios
     */
    public List<Socio> getSocios() {
        return socios;
    }

    /**
     * 
     *
     * @return Lista contendo os instrutores
     */
    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    /**
     *
     * @return Lista contendo as atividades
     */
    public List<Atividades> getAtividades() {
        return atividades;
    }

    /**
     *
     * @return Lista contendo as marcações
     */
    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }
}