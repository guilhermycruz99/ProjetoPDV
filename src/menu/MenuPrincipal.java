
package src.menu;

import src.estoque.Estoque;
import src.produto.Catalogo;
import java.util.Scanner;

public class MenuPrincipal {

    public void executar() {
        Scanner entrada = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        catalogo.cadastrarProdutosIniciais();

        Estoque estoque = new Estoque();

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

        MenuEstoque menuEstoque = new MenuEstoque(estoque);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== CTRL+ALT+BUGUER ===");
            System.out.println("1 - produtos");
            System.out.println("2 - Estoque");
            System.out.println("3 - combos");
            System.out.println("4 - clientes");
            System.out.println("5 - relatorio");
            System.out.println("0 - sair");
            System.out.print("Escolha uma opção:");

            opcao = entrada.nextInt();

            if (opcao == 1) {
                catalogo.listarProdutos();

            } else if (opcao == 2) {
                menuEstoque.executar();

            } else if (opcao == 3) {
                System.out.println("Menu de Combos");

            } else if (opcao == 4) {
                System.out.println("Menu de Cliente");

            } else if (opcao == 5) {
                System.out.println("Menu de Relatórios");

            } else if (opcao == 0) {
                System.out.println("Encerramdo o Sistema...");

            } else {
                System.out.println("opção inválida!");
            }
        }
    }
}
