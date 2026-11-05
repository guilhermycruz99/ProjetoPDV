package src.menu;

import src.produto.Catalogo;
import src.estoque.Estoque;
import java.util.Scanner;

public class MenuPrincipal{
    public void executar() {
        Scanner entrada = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        catalogo.cadastrarProdutosIniciais();

        Estoque estoque = new Estoque();

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

            }else if (opcao == 2){
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                int quantidade = estoque.consultarEstoque(codigo);

                System.out.println("Quantidade em estoque: " + quantidade);

            }else if (opcao == 3){
                System.out.println("Menu de Combos");

            }else if (opcao == 4){
                System.out.println("Menu de Cliente");

            }else if (opcao == 5){
                System.out.println("Menu de Relatórios");

            }else if (opcao == 0){
                System.out.println("Encerramdo o Sistema...");

            }else {
                System.out.println("opção inválida!");
                
            }
        }
    }
}