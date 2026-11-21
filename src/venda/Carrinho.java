package src.venda;

import java.util.ArrayList;
import src.estoque.Estoque;
import src.produto.Catalogo;
import src.produto.Produto;

public class Carrinho {

    private ArrayList<ItemCarrinho> itens;
    private Catalogo catalogo;
    private Estoque estoque;

    public Carrinho (Catalogo catalogo, Estoque estoque) {
        this.catalogo = catalogo;
        this.estoque = estoque;
        this.itens  = new ArrayList<>();
    }

    private ItemCarrinho buscarItem(String codigo) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    public boolean adicionarItem(String codigo, int quantidade) {
        if (quantidade <= 0) {
            System.out.println ("Quantidade invalida!");
            return false;
        }
        Produto produto = catalogo.buscarProduto(codigo);
        if (produto == null) {
            System.out.println ("Produto não encontrado!");
            return false;
        }
        ItemCarrinho itemExistente = buscarItem(codigo);

        int totalDesejado = quantidade;
        if (itemExistente != null) {
            totalDesejado = itemExistente.getQuantidade() + quantidade;
        }
        if (!estoque.temEstoque(codigo, totalDesejado)) {
            System.out.println ("Estoque insuficiente!");
            return false;
        }
        if (itemExistente != null) {
            itemExistente.somarQuantidade(quantidade);
        }else {
            itens.add(new ItemCarrinho(produto, quantidade));
        }
        return true;

    }
    public double calcularSubtotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (ItemCarrinho item : itens) {
            System.out.printf("%-25s %3d x %6.2f = %8.2f%n",
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getProduto().getPreco(),
                item.calcularSubtotal());
        }
        System.out.printf("Subtotal: R$ %.2f%n", calcularSubtotal());
    }
    public boolean estaVazio() {
        return itens.isEmpty();
    }
    public void limpar() {
        itens.clear();
    }
    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }
}
