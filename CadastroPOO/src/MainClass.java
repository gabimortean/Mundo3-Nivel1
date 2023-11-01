import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) {
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Buscar pelo ID");
            System.out.println("5. Exibir Todos");
            System.out.println("6. Persistir Dados");
            System.out.println("7. Recuperar Dados");
            System.out.println("0. Finalizar Programa");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); 
                    if (tipo == 1) {
                        System.out.println("Digite o ID da Pessoa:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Insira os dados..");
                        System.out.println("Nome:");
                        String nome = scanner.nextLine();
                        System.out.println("CPF:");
                        String cpf = scanner.nextLine();
                        System.out.println("Idade:");
                        int idade = scanner.nextInt();
                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                    } else if (tipo == 2) {
                        System.out.println("Digite o ID da Pessoa:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Insira os dados..");
                        System.out.println("Nome:");
                        String nome = scanner.nextLine();
                        System.out.println("CNPJ:");
                        String cnpj = scanner.nextLine();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Tipo inválido. Tente novamente.");
                    }
                break;
                case 2:

    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
    int tipoAlterar = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Digite o ID da Pessoa a ser alterada:");
    int idAlterar = scanner.nextInt();
    
    if (tipoAlterar == 1) {
        PessoaFisica pessoaParaAlterar = repoFisica.obter(idAlterar);
        if (pessoaParaAlterar != null) {
            System.out.println("Dados atuais:");
            pessoaParaAlterar.exibir();
            
            System.out.println("Insira os novos dados..");
            System.out.println("Nome:");
            String novoNome = scanner.nextLine();
            System.out.println("CPF:");
            String novoCpf = scanner.nextLine();
            System.out.println("Idade:");
            int novaIdade = scanner.nextInt();
        
            pessoaParaAlterar.setNome(novoNome);
            pessoaParaAlterar.setCpf(novoCpf);
            pessoaParaAlterar.setIdade(novaIdade);
            repoFisica.alterar(idAlterar, pessoaParaAlterar);
            System.out.println("Pessoa Física alterada com sucesso.");
        } else {
            System.out.println("Pessoa Física com o ID especificado não encontrada.");
        }
    } else if (tipoAlterar == 2) {
        PessoaJuridica pessoaParaAlterar = repoJuridica.obter(idAlterar);
        if (pessoaParaAlterar != null) {
            System.out.println("Dados atuais:");
            pessoaParaAlterar.exibir();
            
            System.out.println("Insira os novos dados..");
            System.out.println("Nome:");
            String novoNome = scanner.nextLine();
            System.out.println("CNPJ:");
            String novoCnpj = scanner.nextLine();

            pessoaParaAlterar.setNome(novoNome);
            pessoaParaAlterar.setCnpj(novoCnpj);
            repoJuridica.alterar(idAlterar, pessoaParaAlterar);
            System.out.println("Pessoa Jurídica alterada com sucesso.");
        } else {
            System.out.println("Pessoa Jurídica com o ID especificado não encontrada.");
        }
    } else {
        System.out.println("Tipo inválido. Tente novamente.");
    }
    break;

                case 3:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoExcluir = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o ID da Pessoa a ser excluída:");
                    int idExcluir = scanner.nextInt();
                    
                    if (tipoExcluir == 1) {
                        repoFisica.excluir(idExcluir);
                        System.out.println("Pessoa Física excluída com sucesso.");
                    } else if (tipoExcluir == 2) {
                        repoJuridica.excluir(idExcluir);
                        System.out.println("Pessoa Jurídica excluída com sucesso.");
                    } else {
                        System.out.println("Tipo inválido. Tente novamente.");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoObter = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o ID da Pessoa a ser obtida:");
                    int idObter = scanner.nextInt();
                    
                    if (tipoObter == 1) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idObter);
                        if (pessoaFisica != null) {
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física com o ID especificado não encontrada.");
                        }
                    } else if (tipoObter == 2) {
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idObter);
                        if (pessoaJuridica != null) {
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica com o ID especificado não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido. Tente novamente.");
                    }
                    break;
                case 5:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoExibirTodos = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (tipoExibirTodos == 1) {
                        List<PessoaFisica> pessoasFisicas = repoFisica.obterTodos();
                        for (PessoaFisica pessoaFisica : pessoasFisicas) {
                            pessoaFisica.exibir();
                            System.out.println();
                        }
                    } else if (tipoExibirTodos == 2) {
                        List<PessoaJuridica> pessoasJuridicas = repoJuridica.obterTodos();
                        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                            pessoaJuridica.exibir();
                            System.out.println();
                        }
                    } else {
                        System.out.println("Tipo inválido. Tente novamente.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o prefixo dos arquivos para salvar os dados:");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Digite o prefixo dos arquivos para recuperar os dados:");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}