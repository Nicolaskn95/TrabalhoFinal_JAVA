
package fatec.poo.model;

import java.util.ArrayList;

public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private boolean formaPagto;
    private boolean situacao;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itensPedido;

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        itensPedido = new ArrayList<ItemPedido>();
    }

    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public boolean getFormaPagto() {
        return formaPagto;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setFormaPagto(boolean formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    
    public void addItemPedido(ItemPedido itemPedido) {
        itemPedido.setPedido(this);
        itensPedido.add(itemPedido);
        double novoLimiteDisponivel = cliente.getLimiteDisp() - (itemPedido.getQtdeVendida() * itemPedido.getProduto().getPreco());
        cliente.setLimiteDisp(novoLimiteDisponivel);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        double novoLimiteDisponivel = cliente.getLimiteDisp() + (itemPedido.getQtdeVendida() * itemPedido.getProduto().getPreco());
        cliente.setLimiteDisp(novoLimiteDisponivel);
        itensPedido.remove(itemPedido);
    }
}
