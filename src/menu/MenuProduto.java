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
            System.out.println("\n=== MENU DE PRODUTOS ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar Produto");
            System.out.println("3 - Listar produto");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcaoProduto= entrada.nextInt();
            
            if(opcaoProduto == 1){
                System.out.println("Cadastrar Produto");
            } else if (opcaoProduto == 2){
                System.out.println("Buscar Produto");
            } else if (opcaoProduto == 3){
                System.out.println("Listar Produtos");
            } else if (opcaoProduto == 0){
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("opção invalida!");
            }
        }
    }
    
}
