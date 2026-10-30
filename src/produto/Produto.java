package src.produto;

public class Produto {
    
    private String codigo;
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String codigo, String nome, double preco, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }
}
