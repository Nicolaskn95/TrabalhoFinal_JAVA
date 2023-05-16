
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
        double novaQtdeEstoque = produto.getQtdeEstoque() - qtdeVendida;
        produto.setQtdeEstoque(novaQtdeEstoque);
    }

    public void setQtdeVendida(double qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }
}
