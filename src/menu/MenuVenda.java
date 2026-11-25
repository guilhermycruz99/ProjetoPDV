
package src.menu;

import java.util.Scanner;
import src.produto.Catalogo;
import src.venda.Carrinho;
import src.venda.Recibo;
import src.venda.Venda;
import src.estoque.Estoque;
import src.cliente.CadastroCliente;
import src.vendedor.CadastroVendedor;

public class MenuVenda {

    private Catalogo catalogo;
    private Estoque estoque;
    private CadastroCliente cadastroCliente;
    private CadastroVendedor cadastroVendedor;
    private Carrinho carrinho;
    private Scanner entrada;

    public MenuVenda(Catalogo catalogo, Estoque estoque, CadastroCliente cadastroCliente, CadastroVendedor cadastroVendedor, Scanner entrada) {
        this.catalogo = catalogo;
        this.estoque = estoque;
        this.cadastroCliente = cadastroCliente;
        this.cadastroVendedor = cadastroVendedor;
        this.entrada = entrada;
        this.carrinho = new Carrinho(catalogo, estoque);
    }

    public void executar() {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n----- MENU DE VENDAS -----\n");
            System.out.println(" 1 - Adicionar produto");
            System.out.println(" 2 - Visualizar carrinho");
            System.out.println(" 3 - Finalizar venda");
            System.out.println(" 4 - Cancelar venda");
            System.out.println(" 0 - Voltar\n");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            System.out.println("---------------------------");

            if (opcao == 1) {
                adicionarProduto(entrada);

            } else if (opcao == 2) {
                carrinho.exibirItens();

            } else if (opcao == 3) {
                finalizarVenda(entrada);

            } else if (opcao == 4) {
                carrinho.limpar();
                System.out.println("Venda cancelada!");

            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarProduto(Scanner entrada) {
        System.out.print("Digite o código do produto: ");
        String coidigo = entrada.next();

        System.out.print("Digite a quantidade: ");
        int quantidade = entrada.nextInt();

        boolean adicionando = carrinho.adicionarItem(coidigo, quantidade);

        if (adicionando) {
            System.out.println("Produto adicionado ao carrinho!");
        }
    }

    private void finalizarVenda(Scanner entrada) {

        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        System.out.print("Digite o CPF do cliente: ");
        String cpf = entrada.next();

        var cliente = cadastroCliente.buscarClientes(cpf);

        if (cliente == null) {
            System.out.println("Venda cancelada: cliente não encontrado!");
            return;
        }

        System.out.print("Digite o código do vendedor: ");
        String codigoVendedor = entrada.next();

        var vendedor = cadastroVendedor.buscarVendedores(codigoVendedor);

        if (vendedor == null) {
            System.out.println("Venda cancelada: vendedor não encontrado!");
            return;
        }

        Venda venda = new Venda(carrinho, estoque, cliente, vendedor);

        if (venda.confirmar()) {
            Recibo recibo = new Recibo(venda);
            recibo.imprimir();

            carrinho.limpar();
        }
    }
}
