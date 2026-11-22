
package src.menu;

import java.util.Scanner;
import src.produto.Catalogo;
import src.menu.MenuProduto;
import src.estoque.Estoque;
import src.menu.MenuEstoque;
import src.cliente.CadastroCliente;
import src.menu.MenuCliente;
import src.vendedor.CadastroVendedor;
import src.menu.MenuVendedor;
import src.menu.MenuRelatorio;
import src.venda.MenuVenda;

public class MenuPrincipal {

    public void executar() {
        Scanner entrada = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        catalogo.cadastrarProdutosIniciais();

        MenuProduto menuProduto = new MenuProduto(catalogo);

        Estoque estoque = new Estoque();

        CadastroCliente cadastroCliente = new CadastroCliente();
        MenuCliente menuCliente = new MenuCliente(cadastroCliente);

        CadastroVendedor cadastroVendedor = new CadastroVendedor();
        MenuVendedor menuVendedor = new MenuVendedor(cadastroVendedor);

        MenuRelatorio menuRelatorio = new MenuRelatorio(catalogo, estoque, cadastroCliente, cadastroVendedor);

        MenuVenda menuVenda = new MenuVenda(catalogo, estoque, cadastroCliente, cadastroVendedor);

        estoque.cadastrarEstoque("001", 10);
        estoque.cadastrarEstoque("002", 10);
        estoque.cadastrarEstoque("003", 10);
        estoque.cadastrarEstoque("004", 10);
        estoque.cadastrarEstoque("005", 10);
        estoque.cadastrarEstoque("006", 10);
        estoque.cadastrarEstoque("007", 10);
        estoque.cadastrarEstoque("008", 10);
        estoque.cadastrarEstoque("009", 10);
        estoque.cadastrarEstoque("010", 10);

        MenuEstoque menuEstoque = new MenuEstoque(estoque,catalogo);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n----- CTRL+ALT+BUGUER -----\n");
            System.out.println(" 1 - Gerenciar produtos");
            System.out.println(" 2 - Gerenciar estoque");
            System.out.println(" 3 - Gerenciar clientes");
            System.out.println(" 4 - Gerenciar vendedor");
            System.out.println(" 5 - Relatório Geral");
            System.out.println(" 6 - Realizar venda");
            System.out.println(" 0 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            System.out.println("---------------------------");

            if (opcao == 1) {
                menuProduto.executar();

            } else if (opcao == 2) {
                menuEstoque.executar();

            }else if (opcao == 3) {
                menuCliente.executar();;

            }else if (opcao == 4){
                menuVendedor.executar();
                
            } else if (opcao == 5){
                menuRelatorio.executar();

            } else if (opcao == 6) {
                menuVenda.executar();

            } else if (opcao == 0) {
                System.out.println("Encerramdo o Sistema...");

            } else {
                System.out.println("opção inválida!");
            }
        }
    }
}
