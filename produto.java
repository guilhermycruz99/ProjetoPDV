import java.math.BigDecimal;

public class Produto {
    private String codigo;
    private String nome;
    private BigDecimal preco;
    private String categoria;

    public produto(String codigo,String nome,BigDecimal preco, stribg categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }
    public String getCodigo() {
        return this.codigo;
    }
    public String getNome() {
        return this.nome;
    }
    public BigDecimal getPreco() {
        return this.preco;
    }
    public String getCategoria() {
        return this.categoria;
    }

}
