package src.venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import src.cliente.Cliente;
import src.estoque.Estoque;
import src.vendedor.Vendedor;

public class Venda {

    
    private static final double TAXA_IMPOSTO = 0.25;
    private static final double TAXA_COMISSAO = 0.05;

    private Carrinho carrinho;
    private Estoque estoque;
    private Cliente cliente;
    private Vendedor vendedor;

    
    private ArrayList<ItemCarrinho> itens;
    private boolean confirmada;

    
    private LocalDateTime dataHora;

    
    private double subtotal;
    private double imposto;
    private double comissao;
    private double total;

    public Venda(Carrinho carrinho, Estoque estoque,
                 Cliente cliente, Vendedor vendedor) {
        this.carrinho = carrinho;
        this.estoque = estoque;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
        this.confirmada = false;
    }

    public boolean confirmar() {

    
        if (confirmada) {
            System.out.println("Venda já confirmada!");
            return false;
        }

        
        if (cliente == null || vendedor == null) {
            System.out.println("Cliente e vendedor são obrigatórios!");
            return false;
        }

        
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio!");
            return false;
        }

        
        for (ItemCarrinho item : carrinho.getItens()) {
            String codigo = item.getProduto().getCodigo();
            if (!estoque.temEstoque(codigo, item.getQuantidade())) {
                System.out.println("Estoque insuficiente: "
                    + item.getProduto().getNome());
                return false;
            }
        }

        
        for (ItemCarrinho item : carrinho.getItens()) {
            estoque.baixarEstoque(item.getProduto().getCodigo(), item.getQuantidade());
        }

        
        itens = new ArrayList<>(carrinho.getItens());
        subtotal = carrinho.calcularSubtotal();
        imposto = subtotal * TAXA_IMPOSTO;
        comissao = subtotal * TAXA_COMISSAO;
        total = subtotal;

        
        dataHora = LocalDateTime.now();
        confirmada = true;
        return true;
    }

    public boolean isConfirmada() { return confirmada; }
    public LocalDateTime getDataHora() { return dataHora; }
    public double getSubtotal() { return subtotal; }
    public double getImposto() { return imposto; }
    public double getComissao() { return comissao; }
    public double getTotal() { return total; }
    public ArrayList<ItemCarrinho> getItens() { return itens; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
}
