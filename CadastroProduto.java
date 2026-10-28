import java.util.ArrayList;
import java.util.list;

public class cadastroProdutos {
    private list<produto> produto = new ArrayList<>();

    public void adicinorProduto() {

        //Hambúqueres
        produto.add(new produto("H01","Gug simples",new BigDecimal("19.00"),"Hambúrguer"));

        produto.add(new produto("H02","Ctrl+Cheddar",new BigDecimal("25.90"),"Hambúrguer"));

        produto.add(new produto("H03","alt+fome",new BigDecimal("25.90"),"Hambùrguer"));

        produto.add(new produto("Ho4","Stack Overflow",new BigDecimal("29.90"),"Hambúrguer"));

        produto.add(new produto("H05","Blue Screen", new BigDecimal("32.90"),"Hambúrguer"));

        //acompanhametos
        produto.add(new produtos("A01","Batata.exe",new BigDecimal("12.90"),"acompanhamento"));

        produto.add(new produto("A02","Onion 404 Ring", new BigDecimal("15.00"),"Acopahamento"));

        //bebidas
        produtos.add(new Produto("B01", "Coca-Cola 350 ml",
                new BigDecimal("6.00"), "Bebida"));

        produtos.add(new Produto("B02", "Guaraná Antarctica 350 ml",
                new BigDecimal("5.50"), "Bebida"));

        produtos.add(new Produto("B03", "Água mineral 500 ml",
                new BigDecimal("3.50"), "Bebida"));

        // Combos promocionais
        produtos.add(new Produto("C01", "Ctrl+Fome",
                new BigDecimal("31.00"), "Combo"));

        produtos.add(new Produto("C02", "Combo Boss Final",
                new BigDecimal("49.90"), "Combo"));
    
    }

    public produto buscaporcodigo(String codigo) {
        for (produto produto : produto){
            if(produto.get().equals(codigo)){
                return produto;
            }
        }
        return null;
    }
}