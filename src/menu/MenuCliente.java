package src.menu;

import src.cliente.CadastroCliente;
import src.cliente.Cliente;
import java.util.Scanner;

public class MenuCliente {

    private CadastroCliente cadastroCliente;

    public MenuCliente(CadastroCliente cadastroCliente){
        this.cadastroCliente = cadastroCliente;
    }

    public void executar(){
        Scanner entrada = new Scanner(System.in);

        int opcaoCliente = -1;

        while (opcaoCliente != 0) {
            System.out.println("\n=== MENU DE CLIENTE ===");
            System.out.println("1 - Casdastrar cliente");
            System.out.println("2 - Busca cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcaoCliente = entrada.nextInt();

            if (opcaoCliente == 1) {
                entrada.nextLine();

                System.out.print("Digite o nome do cliente: ");
                String nome = entrada.nextLine();

                System.out.print("Digite o cpf: ");
                String cpf = entrada.nextLine();

                System.out.print("Digite o telefone:");
                String tel = entrada.nextLine();

                Cliente cliente = new Cliente(nome, cpf, tel);

                cadastroCliente.cadastrarCliente(cliente);
                
            } else if (opcaoCliente == 2) {
                entrada.nextLine();

                System.out.print("Digite o cpf do cliente:");
                String cpf = entrada.nextLine();

                Cliente cliente = cadastroCliente.buscarClientes(cpf);

                if(cliente != null){
                    System.out.println("cliente encontrado!");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("cpf: " + cliente.getCpf());
                    System.out.println("Telefone: " + cliente.getTel());

                }
            } else if (opcaoCliente == 3) {
                cadastroCliente.listarClientes();
            } else if (opcaoCliente == 0) {
                System.out.println("Voltando ao menu principal...");
            }else {
                System.out.println("opção invalida!");
            }
            
        }
    }
    
}
