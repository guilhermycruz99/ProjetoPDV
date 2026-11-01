package src.cliente;

import java.util.HashMap;

//Mapa do Cadastro de Clientes
public class CadastroCliente {
    private HashMap <String, Cliente> clientes;

    public CadastroCliente() {
        clientes = new HashMap<>();
    }

//Cadastro
    public void cadastrarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);

        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("CPF cadastrado!!");
            return;
        } else {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println("Novo cliente cadastrado!");
        }
    }

//Listar todos os cadastros
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
        }
    }

// Busca de Cliente por CPF
    public Cliente buscarClientes(String cpf) {
        Cliente cliente = clientes.get(cpf);

        if (clientes != null) {
            return cliente;
        } else {
            return null;
        }
    }
}
