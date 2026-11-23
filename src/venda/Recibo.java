package src.venda;

import java.time.format.DateTimeFormatter;

public class Recibo {

    private Venda venda;

    public Recibo(Venda venda) {
        this.venda = venda;
    }

    public void imprimir() {

        if (!venda.isConfirmada()) {
            System.out.println("Venda não confirmada: sem recibo.");
            return;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n========== RECIBO ==========");
        System.out.println("Data: " + venda.getDataHora().format(formato));
        System.out.println("Cliente: " + venda.getCliente().getNome());
        System.out.println("Vendedor: " + venda.getVendedor().getNome());
        System.out.println("----------------------------");
        System.out.printf("%-18s %3s %8s %8s%n", "Produto", "Qtd", "Unit.", "Subt.");

        for (ItemCarrinho item : venda.getItens()) {
            System.out.printf("%-18s %3d %8.2f %8.2f%n",
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getProduto().getPreco(),
                item.calcularSubtotal());
        }

        System.out.println("----------------------------");
        System.out.printf("Subtotal:             R$ %8.2f%n", venda.getSubtotal());
        System.out.printf("Imposto (25%%):        R$ %8.2f%n", venda.getImposto());
        System.out.printf("Comissão vendedor (5%%): R$ %8.2f%n", venda.getComissao());
        System.out.println("----------------------------");
        System.out.printf("TOTAL A PAGAR:        R$ %8.2f%n", venda.getTotal());
        System.out.println("============================");
    }
}
