package projetopoo;

import java.util.Scanner;

/**
 * Classe principal (Main) da aplicação POOGym
 * Apresenta um menu interativo em consola para gerir sócios, instrutores,
 * atividades e marcações
 *
 * @author Rafael, Tomás
 * @version 1.0
 */
public class Main {

    /**
     * Ponto de entrada principal da aplicação.
     *
     * @param args Argumentos da linha de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        GymPoo gymPoo = new GymPoo();
        
        // Carrega os dados fixos de demonstração no arranque (Fase 1)
        gymPoo.carregarDados();
        
        int opcao = -1;

        do {
            System.out.println("\n=========================================");
            System.out.println("          POOGYM - MENU PRINCIPAL    ");
            System.out.println("============================================");
            System.out.println("1.  Registar Sócio (Individual ou Empresa)");
            System.out.println("2.  Registar Instrutor");
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
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Erro: Por favor, insira um número inteiro válido");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                            case 1:
                System.out.println("\n--- Registar Sócio ---");
                System.out.print("Número de Sócio: ");
                int numSocio = scanner.nextInt();
                scanner.nextLine();

                // Validação prévia na Main para evitar pedir o resto dos dados em vão
                if (gymPoo.procurarSocioPorNumero(numSocio) != null) {
                    System.out.println("Erro: O número de sócio " + numSocio + " já está atribuído a outro sócio.");
                    break;
                }

                System.out.print("Tipo de sócio (1 - Individual | 2 - Empresa): ");
                int tipoSocio = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nome: ");
                String nomeSocio = scanner.nextLine();
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
                    System.out.println("\n--- Registar Instrutor ---");
                    System.out.print("Nome do instrutor: ");
                    String nomeInst = scanner.nextLine();
                    System.out.print("Género (Masculino/Feminino): ");
                    String genero = scanner.nextLine();
                    if (!genero.equalsIgnoreCase("masculino") && !genero.equalsIgnoreCase("feminino")) {
                        System.out.println("Erro: Género inválido");
                        System.out.println("Erro a registar Instrutor");
                        break;
                    }
                    System.out.print("Formações / Cursos: ");
                    String formacoes = scanner.nextLine();

                    Instrutor instrutor = new Instrutor(nomeInst, genero, formacoes);
                    gymPoo.adicionarInstrutor(instrutor);
                    break;

                case 3:
                    System.out.println("\n--- Registar Atividade ---");
                    
                    if (gymPoo.getInstrutores().isEmpty()) {
                        System.out.println("Erro: Não existem instrutores registados. Registe um instrutor primeiro (Opção 2)");
                        break;
                    }

                    System.out.print("Tipo (1 - Aula de Grupo | 2 - Sessão PT): ");
                    int tipoAtiv = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("\nInstrutores disponíveis:");
                    for (int i = 0; i < gymPoo.getInstrutores().size(); i++) {
                        System.out.println((i + 1) + ". " + gymPoo.getInstrutores().get(i).getNome());
                    }
                    System.out.print("Escolha o número do instrutor responsável: ");
                    int opcaoInst = Integer.parseInt(scanner.nextLine().trim()) - 1;

                    if (opcaoInst < 0 || opcaoInst >= gymPoo.getInstrutores().size()) {
                        System.out.println("Erro: Seleção de instrutor inválida");
                        break;
                    }
                    String instAtiv = gymPoo.getInstrutores().get(opcaoInst).getNome();

                    System.out.print("Data/Hora (ex: 28/10/2026 10:00): ");
                    String dataHoraAtiv = scanner.nextLine();
                    System.out.print("Duração (em minutos): ");
                    int duracao = Integer.parseInt(scanner.nextLine().trim());

                    if (tipoAtiv == 1) {
                        System.out.print("Capacidade máxima de alunos: ");
                        int capMax = Integer.parseInt(scanner.nextLine().trim());
                        
                        System.out.print("Nome da modalidade (Yoga, Spinning, Zumba, CrossFit): ");
                        String modalidade = scanner.nextLine();

                        String nomeAtiv = "Aula de " + modalidade; 

                        AulaGrupo aula = new AulaGrupo(nomeAtiv, instAtiv, dataHoraAtiv, duracao, modalidade, capMax);
                        
                        if (aula.getPrecoBase() > 0) {
                            gymPoo.adicionarAtividade(aula);
                        } else {
                            System.out.println("-> Falha a guardar: Modalidade inválida");
                        }

                    } else if (tipoAtiv == 2) {
                        System.out.print("Nível (Iniciação, Intermédio ou Avançado): ");
                        String nivel = scanner.nextLine();

                        String nomeAtiv = "Sessão PT - " + nivel;

                        SessaoPt pt = new SessaoPt(nomeAtiv, instAtiv, dataHoraAtiv, duracao, nivel);
                        
                        if (pt.getPrecoBase() > 0) {
                            gymPoo.adicionarAtividade(pt);
                        } else {
                            System.out.println("-> Falha a guardar: Nível inválido");
                        }
                    } else {
                        System.out.println("Opção de tipo de atividade inválida");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Lista de Sócios Registados ---");

                    if (gymPoo.getSocios().isEmpty()) {
                        System.out.println("Nenhum sócio registado no sistema.");
                    } else {
                        for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                            Socio s = gymPoo.getSocios().get(i);
                            // Chamada polimórfica a getTipo() sem instanceof
                            System.out.println("Nº: " + s.getNumeroSocio() + " | Nome: " + s.getNome() + " | Email: " + s.getEmail() + " | Tipo: " + s.getTipo());
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- Lista de Atividades ---");
                    if (gymPoo.getAtividades().isEmpty()) {
                        System.out.println("Nenhuma atividade registada no sistema.");
                    } else {
                        for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                            Atividades a = gymPoo.getAtividades().get(i);
                            a.exibirDetalhes();
                            System.out.println("  -> Custo Base: " + a.getPrecoBase() + " Eur");
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n--- Criar Marcação ---");

                    if (gymPoo.getSocios().isEmpty() || gymPoo.getAtividades().isEmpty() || gymPoo.getInstrutores().isEmpty()) {
                        System.out.println("Erro: Deve ter pelo menos um sócio, uma atividade e um instrutor registados no sistema");
                        break;
                    }

                    System.out.print("Insira o número do sócio: ");
                    int numSocioProcurado = scanner.nextInt();
                    scanner.nextLine();

                    Socio socioEncontrado = null;
                    for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                        Socio so = gymPoo.getSocios().get(i);
                        if (so.getNumeroSocio() == numSocioProcurado) {
                            socioEncontrado = so;
                            break;
                        }
                    }

                    if (socioEncontrado == null) {
                        System.out.println("Erro: Sócio com o número " + numSocioProcurado + " não foi encontrado");
                        break;
                    }

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

                    System.out.println("\nInstrutores disponíveis:");
                    for (int i = 0; i < gymPoo.getInstrutores().size(); i++) {
                        System.out.println((i + 1) + ". " + gymPoo.getInstrutores().get(i).getNome());
                    }
                    System.out.print("Escolha o número do instrutor: ");
                    int opcaoInst1 = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (opcaoInst1 < 0 || opcaoInst1 >= gymPoo.getInstrutores().size()) {
                        System.out.println("Erro: Seleção de instrutor inválida");
                        break;
                    }
                    Instrutor instEscolhido = gymPoo.getInstrutores().get(opcaoInst1);

                    

                    System.out.print("Data/Hora da marcação: ");
                    String dataMarcacao = scanner.nextLine();

                    Marcacao marcacao = new Marcacao(socioEncontrado, ativEscolhida, instEscolhido, dataMarcacao);
                    gymPoo.adicionarMarcacao(marcacao);

                    // Cálculo do custo polimórfico sem instanceof
                    double custoFinal = marcacao.calcularCustoFinal();

                    System.out.println("Preço Base: " + ativEscolhida.getPrecoBase() + " Eur | Custo Final com Desconto: " + custoFinal + " Eur");
                    break;

                case 7:
                    System.out.println("\n--- Lista de Marcações e Faturação ---");
                    double faturacaoTotal = 0.0;

                    if (gymPoo.getMarcacoes().isEmpty()) {
                        System.out.println("Nenhuma marcação efetuada até ao momento");
                    } else {
                        for (int i = 0; i < gymPoo.getMarcacoes().size(); i++) {
                            Marcacao m = gymPoo.getMarcacoes().get(i);
                            
                            // Obtenção direta do custo via polimorfismo
                            double custoM = m.calcularCustoFinal();

                            System.out.println("Sócio: " + m.getSocio().getNome() + 
                                            " | Atividade: " + m.getAtividade().getNome() + 
                                            " | Data: " + m.getDataHora() + 
                                            " | Custo: " + String.format("%.2f", custoM) + " Eur");
                            
                            faturacaoTotal += custoM;
                        }
                        
                        System.out.println("---------------------------------------------");
                        System.out.println("TOTAL FATURADO PELO GINÁSIO: " + String.format("%.2f",faturacaoTotal) + " Eur");
                    }
                    break;

                case 8:
                    int numIndiv = 0;
                    int numEmp = 0;
                    int numAulasGrupo = 0;
                    int numSessoesPt = 0;

                    for (int i = 0; i < gymPoo.getSocios().size(); i++) {
                        Socio s = gymPoo.getSocios().get(i);
                        if (s.getTipo().equalsIgnoreCase("Individual")) {
                            numIndiv++;
                        } else {
                            numEmp++;
                        }
                    }

                    for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                        Atividades a = gymPoo.getAtividades().get(i);
                        if (a.getTipoAtividade().equalsIgnoreCase("Aula de Grupo")) {
                            numAulasGrupo++;
                        } else {
                            numSessoesPt++;
                        }
                    }

                    System.out.println("\n--- Resumo do Ginásio ---");
                    System.out.println("Sócios Individuais: " + numIndiv + " | Sócios Empresa: " + numEmp);
                    System.out.println("Aulas de Grupo: " + numAulasGrupo + " | Sessões de PT: " + numSessoesPt);
                    break;

                case 9:
                    System.out.println("\n--- Atividade Mais Popular ---");

                    if (gymPoo.getMarcacoes().isEmpty()) {
                        System.out.println("Ainda não existem marcações para determinar a atividade mais popular");
                    } else {
                        Atividades maisPopular = null;
                        int maxMarcacoes = -1;

                        for (int i = 0; i < gymPoo.getAtividades().size(); i++) {
                            Atividades ativ = gymPoo.getAtividades().get(i);
                            int contador = 0;

                            for (int j = 0; j < gymPoo.getMarcacoes().size(); j++) {
                                Marcacao m = gymPoo.getMarcacoes().get(j);
                                if (m.getAtividade().getNome().equalsIgnoreCase(ativ.getNome())) {
                                    contador++;
                                }
                            }

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
                            
                            double custoComDesconto = m.calcularCustoFinal();
                            double precoAtividade = m.getAtividade().getPrecoBase();
                            double poupanca = precoAtividade - custoComDesconto;

                            totalGasto += custoComDesconto;
                            totalPoupado += poupanca;
                        }
                    }

                    if (encontrou) {
                        System.out.println("Para o Sócio Nº " + numProcurado + ":");
                        System.out.println(" -> Valor Total Gasto no Ginásio: " + String.format("%.2f", totalGasto) + " Eur");
                        System.out.println(" -> Valor Total Poupado com Descontos: " + String.format("%.2f", totalPoupado) + " Eur");
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