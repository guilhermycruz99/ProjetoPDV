package src.menu;
import  java.util.Scanner;
import  src.produto.Catalogo;


public class MenuRelatorio {

    private Catalogo catalogo;

    public MenuRelatorio(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void executar() {

        Scanner entrada = new Scanner(System.in);

        int opcaoRelatorio = -1;

        while (opcaoRelatorio != 0) {

            System.out.println("\n=== MENU DE RELATÓRIOS ===");
            System.out.println("1 - Relatório de produtos");
            System.out.println("2 - Relatório de estoque");
            System.out.println("3 - Relatório de clientes");
            System.out.println("4 - relatório de vendedores");
            System.out.println("0 - voltar");
            System.out.print("Escolha uma opção");

            opcaoRelatorio = entrada.nextInt();

            if (opcaoRelatorio == 1) {
                System.out.println("\n=== RELATÓRIO DE PRODUTOS ===");
                catalogo.listarProdutos();

            } else if (opcaoRelatorio == 2) {
                System.out.println("Relatório de estoque");

            } else if (opcaoRelatorio == 3) {
                System.out.println("Relatório de clientes");

            } else if (opcaoRelatorio == 4) {
                System.out.println("Relatório de vendedores");

            } else if (opcaoRelatorio == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("opção invalida!");
            }  
            
        }
    }
    
}
