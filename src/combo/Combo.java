package src.combo;

import java.util.ArrayList;
import src.produto.Produto;

public class Combo {

    // atributos da classe
    private String codigo;
    private String nome;
    private ArrayList<Produto> produtos;
    private double preco;

    // receber informações iniciais
    public Combo (String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.produtos = new ArrayList<>();
    }

    // adicionar produtos
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            
            System.out.print("Produto não encontrado.");
            return;
        }

        for (Produto item : produtos) {
            if (item.getCodigo().equals(produto.getCodigo())) {
                System.out.println("Produto ja foi adicionado ao combo.");
                return;
            }
        }

        produtos.add(produto);
        System.out.println("Produto adicionado ao combo!");
    }
    // consultar informaçoes
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    // Mostrar informaçoes dos combos e produtos que fazem parte
    public void exibirCombo() {

        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);        
        System.out.println("Preço: R$ " + 
        String.format("%.2f", preco));

        System.out.println("Produtos do combo: ");

        for (Produto produto : produtos) {

            System.out.println(
            produto.getCodigo() + " - " +
            produto.getNome() + " - R$ " +
            String.format("%.2f", preco));
        }
    }
}
