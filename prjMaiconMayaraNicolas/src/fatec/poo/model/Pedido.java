
package fatec.poo.model;

import java.util.ArrayList;

public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private boolean formaPagto;
    private boolean situacao;
    private ArrayList<ItemPedido> itensPedido;//multiplicade

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

    public boolean setFormaPagto() {
        return formaPagto;
    }

    public boolean setSituacao() {
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
    
}
