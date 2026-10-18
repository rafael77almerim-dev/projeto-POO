package projetopoo;

import java.util.Scanner;

/**
 * Classe principal (Main) 
 * Apresenta um menu interativo em consola para testar e executar
 */
public class Main {

    public static void main(String[] args) {
        // Objeto Scanner para leitura dos dados introduzidos pelo utilizador
        Scanner scanner = new Scanner(System.in);
        
        // inicializa classe gestora que armazena os arrays/coleções
        GymPoo gymPoo = new GymPoo();
        
        /**
         * O valor -1 serve apenas para 
         * inicializar a variável local para o compilador do Java. Ao contrário do 'while'
         * tradicional, este valor inicial é ignorado no arranque, pois a leitura do scanner
         * acontece antes do primeiro teste da condição.
         */
        int opcao = -1;

        /**
         * Ciclo principal do menu, enquanto o utilizador não escolher 0,
         * o ciclo vai continuar a mostrar as opções no termina, como o do while executa sempre uma vez, 
         * mostrando as opções obrigatoriamente uma vez
        */
        do {
            System.out.println("\n=========================================");
            System.out.println("          POOGYM - MENU PRINCIPAL    ");
            System.out.println("============================================");
            System.out.println("1.  Registar Sócio (Individual ou Empresa)");
            System.out.println("2.  Registar Instrutor ");
            System.out.println("3.  Registar Atividade (Aula de Grupo ou Sessão PT)");
            System.out.println("4.  Listar Sócios");
            System.out.println("5.  Listar Atividades");
            System.out.println("6.  Criar Marcação");
            System.out.println("7.  Listar Marcações e Total Faturado");
            System.out.println("8.  Resumo de Atividades e Sócios");
            System.out.println("9.  Atividade Mais Popular");
            System.out.println("10. Consultar Valores de um Sócio (Gasto e Poupado)");
            System.out.println("0.  Sair");
            System.out.println("=============================================");
            System.out.print("Escolha uma opção: ");
            
            /**
             * Pergunta ao Java se o próximo dado que está no buffer 
             * do teclado pode ser convertido num número inteiro (int), 
             * sem chegar remover/utilizar esse dado
             */
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
            } else {
                System.out.println("Erro: Por favor, insira um número inteiro válido!");
                scanner.nextLine(); // Limpar entrada inválida
                continue;
            }

            switch (opcao) {
                case 1:
                    /**
                    *  Registrar sócio(Individual ou Empresa)
                    */
                    System.out.println("\n--- Registar Sócio ---");
                    System.out.print("Tipo de sócio (1 - Individual | 2 - Empresa): ");
                    int tipoSocio = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeSocio = scanner.nextLine();
                    System.out.print("Número de Sócio: ");
                    int numSocio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    if (tipoSocio == 1) {
                        System.out.print("Ano de nascimento: ");
                        int anoNasc = scanner.nextInt();
                        scanner.nextLine();

                        SocioIndividual si = new SocioIndividual(nomeSocio, numSocio, email, anoNasc);
                        gymPoo.adicionarSocio(si);
                    } else if (tipoSocio == 2) {
                        System.out.print("Nome da empresa parceira: ");
                        String nomeEmp = scanner.nextLine();
                        System.out.print("NIF da empresa: ");
                        String nifEmp = scanner.nextLine();

                        SocioEmpresa se = new SocioEmpresa(nomeSocio, numSocio, email, nomeEmp, nifEmp);
                        gymPoo.adicionarSocio(se);
                    } else {
                        System.out.println("Opção de tipo de sócio inválida.");
                    }
                    break;

                case 2:
                  /**
                   * Registrar instrutor
                   */
                    System.out.println("\n--- Registar Instrutor ---");
                    System.out.print("Nome do instrutor: ");
                    String nomeInst = scanner.nextLine();
                    System.out.print("Género (Masculino/Feminino): ");
                    String genero = scanner.nextLine();
                    System.out.print("Formações / Cursos: ");
                    String formacoes = scanner.nextLine();

                    Instrutor instrutor = new Instrutor(nomeInst, genero, formacoes);
                    gymPoo.adicionarInstrutor(instrutor);
                    break;

                case 3:
                    /**
                     * Registrar Atividade( Aula de gruoo ou sessão PT)
                     */
                    System.out.println("\n--- Registar Atividade ---");
                    System.out.print("Tipo (1 - Aula de Grupo | 2 - Sessão PT): ");
                    int tipoAtiv = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome da atividade: ");
                    String nomeAtiv = scanner.nextLine();
                    System.out.print("Nome do instrutor responsável: ");
                    String instAtiv = scanner.nextLine();
                    System.out.print("Data/Hora (ex: 28/10/2026 10:00): ");
                    String dataHoraAtiv = scanner.nextLine();
                    System.out.print("Duração (em minutos): ");
                    int duracao = scanner.nextInt();
                    System.out.print("Preço Base (€): ");
                    double precoBase = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipoAtiv == 1) {
                        System.out.print("Capacidade máxima de alunos: ");
                        int capMax = scanner.nextInt();
                        System.out.print("nome da modalidade:");
                        String modalidade = scanner.nextLine();
                        scanner.nextLine();
                    
                        AulaGrupo aula = new AulaGrupo(nomeAtiv, instAtiv, dataHoraAtiv, duracao, precoBase, modalidade, capMax);
                        gymPoo.adicionarAtividade(aula);
                    } else if (tipoAtiv == 2) {
                        System.out.print("Nível (Iniciação, Intermédio ou Avançado): ");
                        String nivel = scanner.nextLine();

                        SessaoPt pt = new SessaoPt(nomeAtiv, instAtiv, dataHoraAtiv, duracao, precoBase, nivel);
                        gymPoo.adicionarAtividade(pt);
                    } else {
                        System.out.println("Opção de tipo de atividade inválida.");
                    }
                    break;

                case 4:
                /**
                 * Listar Sócios
                 */
                System.out.println("\n--- Lista de Sócios Registados ---");

                // Verifica se a lista de sócios do ginásio está vazia
                if (gymPoo.getSocios().isEmpty()) {
                    System.out.println("Nenhum sócio registado no sistema.");
                } else {
                    // Ciclo 'for' com contador 'i' para percorrer a lista
                    for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                        
                        // Obtém o sócio guardado na posição 'i' da coleção
                        Socio s = gymPoo.getSocios().get(i);

                        // Bloco 'if / else' para identificar o tipo de sócio
                        String tipo;
                        if (s instanceof SocioIndividual) {
                            tipo = "Individual";
                        } else {
                            tipo = "Empresa";
                        }

                        // Apresenta na consola os dados do sócio atual
                        System.out.println("Nº: " + s.getNumeroSocio() + " | Nome: " + s.getNome() + " | Email: " + s.getEmail() + " | Tipo: " + tipo);
                    }
                }
                break;
                   
                case 5:
                    /**
                     * Listar Atividades
                     */
                    System.out.println("\n--- Lista de Atividades ---");
                    if (gymPoo.getAtividades().isEmpty()) {
                        System.out.println("Nenhuma atividade registada no sistema.");
                    } else {
                        for (int i = 0; i < gymPoo.getAtividades().size(); i++) {

                            // Obtém a atividade na posição 'i' da coleção(getAtividades() retorna o array completo, 
                            // para usar o i diretamente, teriamos de mudar o geter das atividades no gymPoo, para que aceitasse um atributo)
                            Atividades a = gymPoo.getAtividades().get(i);

                            a.exibirDetalhes();
                            System.out.println("  -> Custo Base: " + a.getPrecoBase() + "€");
                        }
                    }
                    break;

                case 6:
                /**
                 * Criar Marcação
                 */
                System.out.println("\n--- Criar Marcação ---");

                // Validação inicial: garante que existem dados registados suficientes
                if (gymPoo.getSocios().isEmpty() || gymPoo.getAtividades().isEmpty() || gymPoo.getInstrutores().isEmpty()) {
                    System.out.println("Erro: Deve ter pelo menos um sócio, uma atividade e um instrutor registados");
                    break;
                }

                /**
                 * encontrar sócio pelo número
                 */
                System.out.print("Insira o número do sócio: ");
                int numSocioProcurado = scanner.nextInt();
                scanner.nextLine();

                Socio socioEncontrado = null;
                for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                    Socio so = gymPoo.getSocios().get(i);
                    if (so.getNumeroSocio() == numSocioProcurado) {
                        socioEncontrado = so;
                        break; // Para o ciclo assim que encontra o sócio correto
                    }
                }

                if (socioEncontrado == null) {
                    System.out.println("Erro: Sócio não encontrado");
                    break;
                }

                /**
                 * Escolher a atividade
                 */
                System.out.println("\nAtividades disponíveis:");
                for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                    System.out.println((i + 1) + ". " + gymPoo.getAtividades().get(i).getNome());
                }
                System.out.print("Escolha o número correspondente à atividade: ");
                int opcaoAtiv = scanner.nextInt() - 1;
                scanner.nextLine();

                if (opcaoAtiv < 0 || opcaoAtiv >= gymPoo.getAtividades().size()) {
                    System.out.println("Erro: Seleção de atividade inválida");
                    break;
                }
                Atividades ativEscolhida = gymPoo.getAtividades().get(opcaoAtiv);

                /**
                 * Selecionar instrutor
                 */
                System.out.println("\nInstrutores disponíveis:");
                for (int i = 0; i < gymPoo.getInstrutores().size(); i++) {
                    System.out.println((i + 1) + ". " + gymPoo.getInstrutores().get(i).getNome());
                }
                System.out.print("Escolha o número do instrutor: ");
                int opcaoInst = scanner.nextInt() - 1;
                scanner.nextLine();

                if (opcaoInst < 0 || opcaoInst >= gymPoo.getInstrutores().size()) {
                    System.out.println("Erro: Seleção de instrutor inválida");
                    break;
                }
                Instrutor instEscolhido = gymPoo.getInstrutores().get(opcaoInst);

                /**
                 * Registrar data e hora(e realizar a marcação)
                 */
                System.out.print("Data/Hora da marcação:");
                String dataMarcacao = scanner.nextLine();

                Marcacao marcacao = new Marcacao(socioEncontrado, ativEscolhida, instEscolhido, dataMarcacao);
                gymPoo.adicionarMarcacao(marcacao);

                /**
                 * Calcular custo final
                 */
                double custoFinal = 0.0;
                if (socioEncontrado instanceof SocioIndividual) {   //retorna true se for individual
                    /**
                     * Como a variável 'socioEncontrado' foi declarada como a classe geral 'Socio',
                     * o Java daria erro de compilação porque a classe 'Marcacao' não tem um método
                     * que receba o tipo 'Socio' genérico (apenas aceita 'SocioIndividual' ou 'SocioEmpresa')
                     * Usamos o 'instanceof' para confirmar o tipo real do objeto,
                     * para garantir ao compilador que pode chamar em segurança
                     * a versão correta do método com o respetivo desconto
                     */
                    custoFinal = marcacao.calcularCustoFinal((SocioIndividual) socioEncontrado); 
                } else if (socioEncontrado instanceof SocioEmpresa) {
                    custoFinal = marcacao.calcularCustoFinal((SocioEmpresa) socioEncontrado);
                }

                System.out.println("Marcação criada com sucesso!");
                System.out.println("Preço Base: " + ativEscolhida.getPrecoBase() + "€ | Custo Final com Desconto: " + custoFinal + "€");
                break;

                case 7:
                /**
                 * Listar Marcações e Faturação
                 */
                System.out.println("\n--- Lista de Marcações e Faturação ---");
                double faturacaoTotal = 0.0;

                if (gymPoo.getMarcacoes().isEmpty()) {
                    System.out.println("Nenhuma marcação efetuada até ao momento");
                } else {
                    // Ciclo for com contador 'i' para recorrer a lista de marcações
                    for (int i = 0; i < gymPoo.getMarcacoes().size(); i++) {
                        Marcacao m = gymPoo.getMarcacoes().get(i);
                        
                        // Cálculo do custo da marcação com base no tipo de sócio
                        double custoM = 0.0;
                        if (m.getSocio() instanceof SocioIndividual) {
                            custoM = m.calcularCustoFinal((SocioIndividual) m.getSocio());
                        } else if (m.getSocio() instanceof SocioEmpresa) {
                            custoM = m.calcularCustoFinal((SocioEmpresa) m.getSocio());
                        }

                        // Apresentação dos dados de cada marcação
                        System.out.println("Sócio: " + m.getSocio().getNome() + 
                                        " | Atividade: " + m.getAtividade().getNome() + 
                                        " | Data: " + m.getDataHora() + 
                                        " | Custo: " + custoM + "€");
                        
                        // Acumula o custo no total faturado
                        faturacaoTotal += custoM;
                    }
                    
                    System.out.println("---------------------------------------------");
                    System.out.println("TOTAL FATURADO PELO GINÁSIO: " + faturacaoTotal + "€");
                }
                break;
                case 8:
                /**
                 * Resumo de atividades e sócios
                 */
                int numIndiv = 0;
                int numEmp = 0;
                int numAulasGrupo = 0;
                int numSessoesPt = 0;

                // Contagem dos tipos de sócios
                for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                    Socio s = gymPoo.getSocios().get(i);
                    
                    if (s instanceof SocioIndividual) {
                        numIndiv++;
                    } else if (s instanceof SocioEmpresa) {
                        numEmp++;
                    }
                }

                // Contagem dos tipos de atividades
                for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                    Atividades a = gymPoo.getAtividades().get(i);
                    
                    if (a instanceof AulaGrupo) {
                        numAulasGrupo++;
                    } else if (a instanceof SessaoPt) {
                        numSessoesPt++;
                    }
                }

                System.out.println("\n--- Resumo do Ginásio ---");
                System.out.println("Sócios Individuais: " + numIndiv + " | Sócios Empresa: " + numEmp);
                System.out.println("Aulas de Grupo: " + numAulasGrupo + " | Sessões de PT: " + numSessoesPt);
                break;
                case 9:
                /**
                 * Atividade mais popular
                 */
                System.out.println("\n--- Atividade Mais Popular ---");

                if (gymPoo.getMarcacoes().isEmpty()) {
                    System.out.println("Ainda não existem marcações para determinar a mais popular");
                } else {
                    Atividades maisPopular = null;
                    int maxMarcacoes = -1;

                    //  percorre todas as atividades do ginásio
                    for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                        Atividades ativ = gymPoo.getAtividades().get(i);
                        int contador = 0;

                        // conta quantas marcações correspondem a esta atividade
                        for (int j = 0; j < gymPoo.getMarcacoes().size(); j++) {
                            Marcacao m = gymPoo.getMarcacoes().get(j);
                            
                            if (m.getAtividade().getNome().equalsIgnoreCase(ativ.getNome())) {
                                contador++;
                            }
                        }

                        // Atualiza o máximo e a atividade mais popular
                        if (contador > maxMarcacoes) {
                            maxMarcacoes = contador;
                            maisPopular = ativ;
                        }
                    }

                    if (maisPopular != null) {
                        System.out.println("Atividade Mais Popular: " + maisPopular.getNome() + 
                                        " (Total de Marcações: " + maxMarcacoes + ")");
                    }
                }
                break;
                case 10:
                /**
                 * Valor gasto e poupado por um sócio
                 */
                System.out.println("\n--- Consultar Valores do Sócio ---");
                System.out.print("Insira o número do sócio: ");
                int numProcurado = scanner.nextInt();
                scanner.nextLine();

                double totalGasto = 0.0;
                double totalPoupado = 0.0;
                boolean encontrou = false;

                
                for (int i = 0; i < gymPoo.getMarcacoes().size(); i++) {
                    Marcacao m = gymPoo.getMarcacoes().get(i);

                    if (m.getSocio().getNumeroSocio() == numProcurado) {
                        encontrou = true;
                        double custoComDesconto = 0.0;

                        // Verificação de tipo (instanceof) 
                        if (m.getSocio() instanceof SocioIndividual) {
                            custoComDesconto = m.calcularCustoFinal((SocioIndividual) m.getSocio());
                        } else if (m.getSocio() instanceof SocioEmpresa) {
                            custoComDesconto = m.calcularCustoFinal((SocioEmpresa) m.getSocio());
                        }

                        double precoAtividade = m.getAtividade().getPrecoBase();
                        double poupanca = precoAtividade - custoComDesconto;

                        totalGasto += custoComDesconto;
                        totalPoupado += poupanca;
                    }
                }

                if (encontrou) {
                    System.out.println("Para o Sócio Nº " + numProcurado + ":");
                    System.out.println(" -> Valor Total Gasto no Ginásio: " + totalGasto + "€");
                    System.out.println(" -> Valor Total Poupado com Descontos: " + totalPoupado + "€");
                } else {
                    System.out.println("Sócio não encontrado ou sem marcações registadas");
                }
                break;

                case 0:
                    System.out.println("\nA encerrar a aplicação POOGym. Bom trabalho!");
                    break;

                default:
                    System.out.println("Opção inválida, escolha um número entre 0 e 10");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
