package src.estoque;

import java.util.HashMap;

public class Estoque {
    

        private HashMap<String, Integer> quantidades;

        public Estoque() {
            quantidades = new HashMap<>();
        }

    public void cadastrarEstoque(String codigo, int quantidade) {

        if (quantidade < 0 || quantidades.containsKey(codigo)) {
            System.out.println("Cadastro invalido");
            return;
        }

        quantidades.put(codigo, quantidade);
        System.out.println("Estoque Cadastrado!");
    }

    public int consultarEstoque(String codigo) {

        return quantidades.getOrDefault(codigo, 0);
    }
    
    public boolean temEstoque(String codigo, int quantidade) {

        if (quantidade <= 0 ) {
            return false;

        }

        return consultarEstoque(codigo) >= quantidade;
    }

    public boolean baixarEstoque(String codigo, int quantidade) {

        if (!temEstoque(codigo, quantidade)) {
            return false;
        }

        int atual = consultarEstoque(codigo);

        quantidades.put(codigo, atual - quantidade);
        return true;
    }

    public void adicionarEstoque(String codigo, int quantidade) {

        if (quantidade <= 0 || !quantidades.containsKey(codigo)) {
            System.out.println("Operação Invalida.");
            return;
        }

        int atual = consultarEstoque(codigo);

        quantidades.put(codigo, atual + quantidade);
    }
    }

