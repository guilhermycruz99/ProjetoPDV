package src.menu;

import src.produto.Catalogo;
import src.produto.Produto;
import java.util.Scanner;



public class MenuProduto {

    private Catalogo catalogo;

    public  MenuProduto(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void executar(){
        Scanner entrada = new Scanner(System.in);
        
        int opcaoProduto = -1;

        while (opcaoProduto != 0) {
            System.out.println("\n----- MENU DE PRODUTOS -----\n");
            System.out.println(" 1 - Cadastrar Produto");
            System.out.println(" 2 - Buscar Produto");
            System.out.println(" 3 - Listar produto");
            System.out.println(" 0 - Voltar\n");
            System.out.print("Escolha uma opção: ");
            opcaoProduto= entrada.nextInt();
            System.out.println("----------------------------");

            if(opcaoProduto == 1){
                entrada.nextLine();
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.nextLine();
                System.out.print("Digite o nome do produto: ");
                String nome = entrada.nextLine();
                System.out.print("Digite o preço do produto: ");
                double preco = entrada.nextDouble();
                entrada.nextLine();
                System.out.print("Digite a categoria do produto: ");
                String categoria = entrada.nextLine();

                Produto produto = new Produto(codigo, nome, preco, categoria);
                catalogo.cadastrarProduto(produto);
                
            } else if (opcaoProduto == 2){
                entrada.nextLine();
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.nextLine();

                Produto produto = catalogo.buscarProduto(codigo);

                if (produto != null) {
                    System.out.println("Produto encontrado!");
                    System.out.println("Código: " + produto.getCodigo());
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Preço: R$" + produto.getPreco());
                    System.out.println("Categoria: " + produto.getCategoria());

                } else {
                    System.out.println("Produto não encontrado!");
                }
            } else if (opcaoProduto == 3){
                catalogo.listarProdutos();
                System.out.println("---------------------------");

            } else if (opcaoProduto == 0){
                System.out.println("Voltando ao menu principal...");
                System.out.println("\n---------------------------");
            } else {
                System.out.println("opção invalida!");
            }
        }
        entrada.close();
    }
}
