package src.menu;

import src.produto.Catalogo;
import src.produto.Produto;
import src.estoque.Estoque;
import java.util.Scanner;

public class MenuEstoque {

    private Estoque estoque;
    private Catalogo catalogo;

    public MenuEstoque(Estoque estoque, Catalogo catalogo) {
        this.estoque = estoque;
        this.catalogo = catalogo;
    }

    public void executar() {
        Scanner entrada = new Scanner(System.in);


        int opcaoEstoque = -1;
        

        while (opcaoEstoque != 0) {
            System.out.println("\n=== MENU DE ESTOQUE ===");
            System.out.println("1 - consultar estoque");
            System.out.println("2 - Cadastra estoque inicial");
            System.out.println("3 - Adicinar estoque");
            System.out.println("0 - voltar");
            System.out.print("Escolha uma opção: ");

            opcaoEstoque = entrada.nextInt();

            if (opcaoEstoque == 1) {
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                Produto produto = catalogo.buscarProduto(codigo);

                if (produto == null){
                    System.out.println("Produto não econtrada!");
                }else{
                    int quantidade = estoque.consultarEstoque(codigo);

                    System.out.println("Produto:" + produto.getNome());
                    System.out.println("Quantidade em estoque: " + quantidade);
                }
            } else if (opcaoEstoque == 2) {
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                Produto produto = catalogo.buscarProduto(codigo);

                if (produto == null){
                    System.out.println("Produto não encontrado!");
                }else {
                    System.out.print("Digite a quantidade inicial:");
                    int quantidade = entrada.nextInt();

                    if (quantidade < 0){
                        System.out.println("Quantidade invalida!");


                    }else if (estoque.consultarEstoque(codigo) > 0) {
                        System.out.println("Este produto já possui estoque cadastrado!");

                    }else{
                        estoque.cadastrarEstoque(codigo, quantidade);
                    }
                }
            } else if (opcaoEstoque == 3){
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                Produto produto = catalogo.buscarProduto(codigo);

                if (produto == null) {
                    System.out.println("Produto não encontrado!");
                }else{
                    System.out.print("Digite a quantidade que deseja adicinor: ");
                    int quantidade = entrada.nextInt();

                    if (quantidade <=0){
                        System.out.println("Digite uma quantidade maior que zero!");
                    } else {
                        estoque.adicionarEstoque(codigo, quantidade);

                        System.out.println("Estoque atualiza com sucesso!");
                    }
                }
            } else if (opcaoEstoque == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("opção invalida! Tente novamente.");
            }
        }
    }
}
