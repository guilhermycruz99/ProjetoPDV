
package src;

import src.produto.Catalogo;
import src.estoque.Estoque;

public class Main {

    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();
        Estoque estoque = new Estoque();

        // Cadastrar os produtos
        catalogo.cadastrarProdutosIniciais();

        // Cadastrar estoque inicial
        estoque.cadastrarEstoque("001", 10);
        estoque.cadastrarEstoque("002", 8);
        estoque.cadastrarEstoque("003", 5);

        System.out.println("\n===== CTRL+ALT+BURGUER =====");
        System.out.println("======= CARDÁPIO ==========\n");

        catalogo.listarProdutos();

        // Testar consulta de estoque
        System.out.println("\n===== TESTE DE ESTOQUE =====");

        System.out.println("Bug Simples: "
                + estoque.consultarEstoque("001") + " unidades");

        // Testar disponibilidade
        System.out.println("\nTem 3 Bug Simples disponíveis? "
                + estoque.temEstoque("001", 3));

        // Testar baixa
        System.out.println("\nRealizando baixa de 3 unidades...");

        boolean resultado = estoque.baixarEstoque("001", 3);

        System.out.println("Baixa realizada? " + resultado);

        // Consultar novamente
        System.out.println("Estoque final: "
                + estoque.consultarEstoque("001"));
    }
}

