
package src.menu;

import src.estoque.Estoque;
import java.util.Scanner;

public class MenuEstoque {

    public void executar() {
        Scanner entrada = new Scanner(System.in);

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

        int opcaoEstoque = -1;

        while (opcaoEstoque != 0) {
            System.out.println("\n=== MENU DE ESTOQUE ===");
            System.out.println("1 - consultar estoque");
            System.out.println("2 - Cadastra estoque inicial");
            System.out.println("0 - voltar");
            System.out.print("Escolha uma opção: ");

            opcaoEstoque = entrada.nextInt();

            if (opcaoEstoque == 1) {
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                int quantidade = estoque.consultarEstoque(codigo);
                System.out.println("Quantidade em estoque: " + quantidade);

            } else if (opcaoEstoque == 2) {
                System.out.print("Digite o código do produto: ");
                String codigo = entrada.next();

                System.out.print("Digite a quantidade inicial: ");
                int quantidade = entrada.nextInt();

                estoque.cadastrarEstoque(codigo, quantidade);
                System.out.println("Operação de cadastro realizada.");

            } else if (opcaoEstoque == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("opção invalida! Tente novamente.");
            }
        }
    }
}
