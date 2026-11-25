
package src.vendedor;

import java.util.HashMap;

public class CadastroVendedor {

    private HashMap<String, Vendedor> vendedores;

    // Mapa de vendedores
    public CadastroVendedor() {
        vendedores = new HashMap<>();

        // Vendedores pré-cadastrados
        cadastrarVendedor(new Vendedor("João Victor", "001", "83999990000"));
        cadastrarVendedor(new Vendedor("Jackie Chan", "002", "83988889999"));
        cadastrarVendedor(new Vendedor("Paulo Islan", "003", "8340028922"));
    }

    // Cadastro do vendedor
    public void cadastrarVendedor(Vendedor vendedor) {
        if (vendedores.containsKey(vendedor.getCodigo())) {
            System.out.println("ERRO: Código de vendedor já cadastrado!");
            return;
        } else {
            vendedores.put(vendedor.getCodigo(), vendedor);
            System.out.println("Novo vendedor cadastrado!");
        }
    }

    // Lista todos os vendedores cadastrados
    public void listarVendedores() {
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado!");
        } else {
            System.out.println("---- Todos os vendedores cadastrados ----");

            for (Vendedor vendedor : vendedores.values()) {
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("Código: " + vendedor.getCodigo());
                System.out.println("Telefone: " + vendedor.getTel());
                System.out.println("-----------------------------");
                System.out.println();
            }
        }
    }

    // Busca de vendedor por código
    public Vendedor buscarVendedores(String codigo) {
        Vendedor vendedor = vendedores.get(codigo);

        if (vendedor != null) {
            return vendedor;
        } else {
            System.out.println("Código " + codigo + " não encontrado.");
            return null;
        }
    }
}
