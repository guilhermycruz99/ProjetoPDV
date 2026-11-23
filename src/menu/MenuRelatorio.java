package src.menu;
import  java.util.Scanner;
import  src.produto.Catalogo;
import  src.produto.Produto;
import  src.cliente.CadastroCliente;
import  src.estoque.Estoque;
import  src.vendedor.CadastroVendedor;


public class MenuRelatorio {

    private Catalogo catalogo;
    private Estoque estoque;
    private CadastroCliente cadastroCliente;
    private CadastroVendedor cadastroVendedor;

    public MenuRelatorio(Catalogo catalogo, Estoque estoque, CadastroCliente cadastroCliente, CadastroVendedor cadastroVendedor){
        this.catalogo = catalogo;
        this.estoque = estoque;
        this.cadastroCliente = cadastroCliente;
        this.cadastroVendedor = cadastroVendedor;
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
                System.out.println("\n=== RELATÓRIO DE ESTOQUE===");

                for (Produto produto : catalogo.getProdutos().values()){

                    int quantidade = estoque.consultarEstoque(produto.getCodigo());
                    
                    System.out.println("Produto" + produto.getNome());
                                        
                    System.out.println("Quantidade em estoque:" + quantidade);

                }

            } else if (opcaoRelatorio == 3) {
                System.out.println("\n=== RELATÓRIO DE CLIENTES===");
                cadastroCliente.listarClientes();

            } else if (opcaoRelatorio == 4) {
                System.out.println("\n=== RELATÓRIO DE VENDEDORES===");
                cadastroVendedor.listarVendedores();

            } else if (opcaoRelatorio == 0) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("opção invalida!");
            }  
            
        }
        entrada.close();
    }
    
}
