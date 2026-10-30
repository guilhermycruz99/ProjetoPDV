package src.produto;
import java.util.HashMap;

public class Catalogo {
    
    private HashMap<String, Produto> produtos;

    public Catalogo() {
        produtos = new HashMap<>();

    }

    public void cadastrarProduto(Produto produto) {

        if (produtos.containsKey(produto.getCodigo())) {

            System.out.println("Produto já cadastrado");
            return;
        }

        produtos.put(produto.getCodigo(), produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public Produto buscarProduto(String codigo) {
        return produtos.get(codigo);
    }

    public void listarProdutos() {
        
        for (Produto produto : produtos.values()) {
            System.out.println(
                produto.getCodigo() + " - " +
                produto.getNome() + " - R$ " + 
                produto.getPreco()
            );
        }
    }

    public void cadastrarProdutosIniciais() {
        cadastrarProduto(new Produto("001", "Bug Simples", 19.00, "Hamburguer"));
        cadastrarProduto(new Produto("002", "Ctrl+Cheddar", 23.90, "Hamburguer"));
        cadastrarProduto(new Produto("003", "Alt+Fome", 25.90 , "Hamburguer"));
        cadastrarProduto(new Produto("004", "Stack Overflow", 29.90 , "Hambuguer"));
        cadastrarProduto(new Produto("005", "Blue Screen", 32.90, "Hamburguer"));

        cadastrarProduto(new Produto("006", "Batata.exe", 12.90, "Acompanhamento"));
        cadastrarProduto(new Produto("007", "Onion 404 Rings", 15.00, "Acompanhamento"));

        cadastrarProduto(new Produto("008", "Coca-Cola 350ml", 6.00, "Bebida"));
        cadastrarProduto(new Produto("009", "Guaraná Antarctica 350ml", 5.50, "Bebida"));
        cadastrarProduto(new Produto("010", "Água mineral 500ml", 3.50, "Bebida"));

        cadastrarProduto(new Produto("011", "Ctrl+Fome", 31.00, "Combo"));
        cadastrarProduto(new Produto("012", "Combo Boss Final", 49.90, "Combo"));
    }
}
