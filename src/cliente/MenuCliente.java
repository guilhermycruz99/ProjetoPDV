package src.cliente;

import java.util.Scanner;

public class MenuCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroCliente cadastro = new CadastroCliente();

        int opcao = -1;
        int op = -1;

        while (opcao != 0) {
            System.out.println("----Menu do Cliente----");
            System.out.println();
            System.out.println("[1] Cadastrar Cliente.");
            System.out.println("[2] Listar Clientes.");
            System.out.println("[3] Buscar Cliente.");
            System.out.println("[0] Voltar ao menu principal");
            System.out.println("----------------------");
            System.out.println();
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

//Menu de Cadastro de clientes
            if (opcao == 1) {
                boolean continueCadastro = true;

                while (continueCadastro) {
                    System.out.println("----Cadastrar Cliente----");
                    System.out.println();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF (***.***.***-**): ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone (83 9****-****): ");
                    String tel = scanner.nextLine();
                    System.out.println();
                    System.out.println("[1] Confirmar Cadastro.");
                    System.out.println("[2] Cancelar Cadastro.");
                    System.out.println("---------------------");
                    System.out.println();
                    System.out.print("Escolha a opção: ");
                    op = scanner.nextInt();

                    if (op == 1) {
                        Cliente cliente = new Cliente(nome, cpf, tel);
                        cadastro.cadastrarCliente(cliente);
                        System.out.println("Cadastro de cliente confirmado!!");
                        System.out.println();
                        System.out.println("[1] Cadastrar outro cliente.");
                        System.out.println("[0] Voltar ao menu de clientes.");
                        System.out.println();
                        System.out.print("Escolha uma opção: ");
                        op = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (op == 1) {
                            continueCadastro = true;
                        } else if (op == 0) {
                            continueCadastro = false;
                            System.out.println("Voltando ao menu Clientes...");
                        }
                    } else if (op == 2) {
                        System.out.println("Cadastro cancelado.");
                        System.out.println("[0] Voltar ao menu de clientes.");
                        System.out.println();
                        System.out.print("Escolha uma opção: ");
                        op = scanner.nextInt();
                        scanner.nextLine();
                        if (op == 0) {
                            continueCadastro = false;
                            System.out.println("Voltando ao menu Clientes...");
                        }
                    } else {
                        System.out.println("Escolha uma opção válida!");
                    }
                }
//Listar Clientes
            } else if (opcao == 2) {
                System.out.println("-----Clientes cadastrados-----");
                cadastro.listarClientes();

//Buscar Clientes
            } else if (opcao == 3) {
                System.out.print("Digite o CPF do cliente desejado:");
                String BuscarCpf = scanner.nextLine();

                Cliente clienteEncontrado = cadastro.buscarClientes(BuscarCpf);

                if (clienteEncontrado == null) {
                    System.out.println("Cliente não encontrado.");
                } else {
                    System.out.println("Nome: " + clienteEncontrado.getNome());
                    System.out.println("CPF: " + clienteEncontrado.getCpf());
                    System.out.println("Telefone: " + clienteEncontrado.getTel());
                    System.out.println("-----------------------------");
                }
            }
        }

        scanner.close();
    }
}
