
package src.menu;

import src.cliente.CadastroCliente;
import src.cliente.Cliente;
import java.util.Scanner;

public class MenuCliente {

    private CadastroCliente cadastroCliente;
    private Scanner entrada;

    public MenuCliente(CadastroCliente cadastroCliente, Scanner entrada) {
        this.cadastroCliente = cadastroCliente;
        this.entrada = entrada;
    }

    public void executar() {

        int opcaoCliente = -1;

        while (opcaoCliente != 0) {
            System.out.println("\n----- MENU DE CLIENTES -----\n");
            System.out.println(" 1 - Cadastrar cliente");
            System.out.println(" 2 - Buscar cliente");
            System.out.println(" 3 - Listar clientes");
            System.out.println(" 0 - Voltar\n");
            System.out.print("Escolha uma opção: ");
            opcaoCliente = entrada.nextInt();
            System.out.println("---------------------------");

            if (opcaoCliente == 1) {
                entrada.nextLine();

                System.out.print("Digite o nome do cliente: ");
                String nome = entrada.nextLine();

                System.out.print("Digite o CPF: ");
                String cpf = entrada.nextLine();

                System.out.print("Digite o telefone: ");
                String tel = entrada.nextLine();

                Cliente cliente = new Cliente(nome, cpf, tel);

                cadastroCliente.cadastrarCliente(cliente);

            } else if (opcaoCliente == 2) {
                entrada.nextLine();

                System.out.print("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();

                Cliente cliente = cadastroCliente.buscarClientes(cpf);

                if (cliente != null) {
                    System.out.println("Cliente encontrado!");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Telefone: " + cliente.getTel());
                }

            } else if (opcaoCliente == 3) {
                cadastroCliente.listarClientes();

            } else if (opcaoCliente == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
