package src.vendedor;

import java.util.HashMap;


public class CadastroVendedor {
    private HashMap<String, Vendedor> vendedores;

//Mapa de vendedores
    public CadastroVendedor() {
        vendedores = new HashMap<>();
    }

//Cadastro do vendedor
    public void cadastrarVendedor(Vendedor vendedor) {
        if (vendedores.containsKey(vendedor.getCodigo())) {
            System.out.println("ERRO: Código de Vendedor já cadastrado!!");
            return;
        } else {
            vendedores.put(vendedor.getCodigo(), vendedor);
            System.out.println("Novo vendedor cadastrado!");
        }
    }

//Listar todos os vendedores cadastrados
    public void listarVendedores() {
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado!");
        } else {
            for (Vendedor vendedor : vendedores.values()) {
            System.out.println("Nome: " + vendedor.getNome());
            System.out.println("Código: " + vendedor.getCodigo());
            System.out.println("Telefone: " + vendedor.getTel());
            System.out.println("-----------------------------");
            System.out.println();
            }
            System.out.println("----Todos os vendedores cadastrados----");
        }
    }

//Busca de Vendedor por Código
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
