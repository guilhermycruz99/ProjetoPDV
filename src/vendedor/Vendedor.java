package src.vendedor;

public class Vendedor {

//Dados do Vendedor
    private String nome;
    private String codigo;
    private String telefone;

//Preencha os Dados
    public Vendedor(String nome, String codigo, String telefone) {
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
    }

//Pegue os valores do Vendedor
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
