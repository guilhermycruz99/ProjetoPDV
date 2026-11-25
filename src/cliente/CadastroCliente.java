
package src.cliente;

import java.util.HashMap;

// Mapa do cadastro de clientes
public class CadastroCliente {

    private HashMap<String, Cliente> clientes;

    public CadastroCliente() {
        clientes = new HashMap<>();

        // Clientes pré-cadastrados
        cadastrarCliente(new Cliente("Denzel Franco", "44477733301", "8397776864"));
        cadastrarCliente(new Cliente("Guilhermy Phyllipe", "99900044407", "83974556464"));
        cadastrarCliente(new Cliente("Juan Diêgo", "55566655509", "83974543591"));
    }

    // Cadastro do cliente
    public void cadastrarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("ERRO: CPF já cadastrado!");
            return;
        } else {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println("Novo cliente cadastrado!");
        }
    }

    // Lista todos os clientes cadastrados
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            System.out.println("---- Todos os clientes cadastrados ----");

            for (Cliente cliente : clientes.values()) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTel());
                System.out.println("-----------------------------");
                System.out.println();
            }
        }
    }

    // Busca de cliente por CPF
    public Cliente buscarClientes(String cpf) {
        Cliente cliente = clientes.get(cpf);

        if (cliente != null) {
            return cliente;
        } else {
            System.out.println("CPF " + cpf + " não encontrado.");
            return null;
        }
    }
}
