package src.cliente;

public class Cliente {

//Dados do cliente
    private String nome;
    private String cpf;
    private String tel;

//Preencha os dados
    public Cliente(String nome, String cpf, String tel) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
    }

//Pegue os valores do Cliente
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