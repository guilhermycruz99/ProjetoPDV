
package src.cliente;

public class Cliente {

    // Dados do cliente
    private String nome;
    private String cpf;
    private String tel;

    // Preenche os dados
    public Cliente(String nome, String cpf, String tel) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
    }

    // Retorna os valores do cliente
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTel() {
        return tel;
    }
}
