package src.menu;

import src.vendedor.CadastroVendedor;
import src.vendedor.Vendedor;
import java.util.Scanner;

public class MenuVendedor {

    private CadastroVendedor cadastroVendedor;

    public MenuVendedor(CadastroVendedor cadastroVendedor){
        this.cadastroVendedor = cadastroVendedor;
    }

    public void executar() {
        Scanner entrada = new Scanner(System.in);

        int opcaoVendedor = -1;

        while (opcaoVendedor != 0) {
            System.out.println("\n===  MENU DE VENDEDORES ===");
            System.out.println("1 - Cadastra vendedor");
            System.out.println("2 - Buscar vendedor");
            System.out.println("3 - listar vendedores");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcaoVendedor = entrada.nextInt();

            if (opcaoVendedor == 1){
                entrada.nextLine();

                System.out.print("Digite o nome do vendedor: ");
                String nome = entrada.nextLine();

                System.out.print("Digite o Código do vendedor: ");
                String codigo = entrada.nextLine();

                System.out.print("Digite o telefone: ");
                String telefone = entrada.nextLine();

                Vendedor vendedor = new Vendedor(nome, codigo, telefone);

                cadastroVendedor.cadastrarVendedor(vendedor);
            } else if (opcaoVendedor == 2){
                entrada.nextLine();

                System.out.print("Digite o código do vendedor: ");
                String codigo = entrada.nextLine();

                Vendedor vendedor = cadastroVendedor.buscarVendedores(codigo);

                if (vendedor != null) {
                    System.out.println("Vendedor encontrado!");
                    System.out.println("Nome: " + vendedor.getNome());
                    System.out.println("Código: " + vendedor.getCodigo());
                    System.out.println("Telefone: " + vendedor.getTel());                    
                }
            } else if (opcaoVendedor == 3){
                cadastroVendedor.listarVendedores();
            } else if (opcaoVendedor == 0){
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("opção inválida!");
            }
        }
    }
    
}
