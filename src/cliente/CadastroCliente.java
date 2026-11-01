package src.cliente;

import java.util.HashMap;

//Mapa do Cadastro de Clientes
public class CadastroCliente {
    private HashMap <String, Cliente> clientes;

    public CadastroCliente() {
        clientes = new HashMap<>();
    }

//Cadastro do cliente
    public void cadastrarCliente(Cliente cliente) {

        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("ERRO: CPF já cadastrado!!");
            return;
        } else {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println("Novo cliente cadastrado!");
        }
    }

//Listar todos os clientes cadastrados
    public void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            for (Cliente cliente : clientes.values()) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTel());
            System.out.println("-----------------------------");
            System.out.println();
            }

            System.out.println("----Todos os clientes cadastrados----");
        }
    }

// Busca de Cliente por CPF
    public Cliente buscarClientes(String cpf) {
        Cliente cliente = clientes.get(cpf);

        if (clientes != null) {
            return cliente;
        } else {
            System.out.println("CPF " + cpf + " não encontrado.");
            return null;
        }
    }
}
