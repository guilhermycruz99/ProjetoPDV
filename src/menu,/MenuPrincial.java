package src.menu;

import java.util.Scanner;

public class MenuPrincipal{
    public void excutar() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== CTRL+ALT+BUGUER ===");
            System.out.printl("1 - produtos");
            System.out.println("2 - Estoque");
            System.out.println("3 - combos");
            System.out.println("4 - clientes");
            System.out.println("5 - relatorio");
            System.out.println("0 - sair");

            System.out.print("Escolha uma opção:");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Menu de Produtos");
                    break;
                
                case 2:
                    System.out.println("Menu de Estoque");  
                    break;
                    
                case 3:
                    System.out.println("Menu Combos");
                    break;
                    
                case 4:
                    System.out.println("Menu de cliente");
                    break; 
                    
                case 5:
                    System.out.println("Menu de relatórios");
                    break;
                    
                case 0:
                    System.out.println("Encerrando o Sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;    
            }
        }
    }
}