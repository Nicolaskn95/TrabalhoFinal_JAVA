
package fatec.poo.model;

public class ItemPedido{
    private int sequencia;
    private double qtdeVendida;
    private Produto produto;
    private Pedido pedido;
    
    public ItemPedido(int sequencia, double qtdeVendida, Produto p) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produto = produto;
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
    
}
