
package src.vendedor;

public class Vendedor {

    // Dados do vendedor
    private String nome;
    private String codigo;
    private String telefone;

    // Preenche os dados
    public Vendedor(String nome, String codigo, String telefone) {
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
    }

    // Retorna os valores do vendedor
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTel() {
        return telefone;
    }
}
