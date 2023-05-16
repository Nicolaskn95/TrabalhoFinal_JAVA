
package fatec.poo.model;

public class ItemPedido{
    private int sequencia;
    private double qtdeVendida;
    private Produto produto;
    private Pedido pedido;
    
    public ItemPedido(int sequencia, double qtdeVendida, Produto produto) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produto = produto;
    }

    public void setQtdeVendida(double qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
        double qtdProduto = produto.getQtdeEstoque() - qtdeVendida;
        produto.setQtdeEstoque(qtdProduto);
    }

    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }
    
}
