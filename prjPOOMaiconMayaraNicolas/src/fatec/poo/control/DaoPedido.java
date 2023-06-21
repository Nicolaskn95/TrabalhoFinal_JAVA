package fatec.poo.control;

import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Pedido;
import fatec.poo.model.Vendedor;
/**
 *
 * @author Lenovo
 */
public class DaoPedido {
    private Connection conn;

    public DaoPedido(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBPEDIDO(NUMERO, DATA_EMISSAO, DATA_PAGTO, FORMA_PAGTO, SITUACAO, CLIENTE_ID, VENDEDOR_ID)"
                                     + " VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, pedido.getNumero());
            ps.setString(2, pedido.getDataEmissao());
            ps.setString(3, pedido.getDataPagto());
            ps.setBoolean(4, pedido.getFormaPagto());
            ps.setBoolean(5, pedido.getSituacao());
            ps.setString(6, pedido.getCliente().getCpf().replaceAll("[.-]", ""));
            ps.setString(7, pedido.getVendedor().getCpf().replaceAll("[.-]", ""));

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBPEDIDO SET DATA_EMISSAO = ?, DATA_PAGTO = ?, FORMA_PAGTO = ?, SITUACAO = ?, CLIENTE_ID = ?, VENDEDOR_ID = ?"
                            + " WHERE NUMERO = ?");

            ps.setString(1, pedido.getDataEmissao());
            ps.setString(2, pedido.getDataPagto());
            ps.setBoolean(3, pedido.getFormaPagto());
            ps.setBoolean(4, pedido.getSituacao());
            ps.setString(5, pedido.getCliente().getCpf().replaceAll("[.-]", ""));
            ps.setString(6, pedido.getVendedor().getCpf().replaceAll("[.-]", ""));
            ps.setString(7, pedido.getNumero());
            DaoItemPedido daoItemPedido = new DaoItemPedido(conn);
            daoItemPedido.excluirItensDoPedido(pedido.getNumero());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Pedido consultar(String numero) {
        Pedido novoPedido = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBPEDIDO WHERE NUMERO = ?");

            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                novoPedido = new Pedido(numero, rs.getString("DATA_EMISSAO"));
                novoPedido.setDataPagto(rs.getString("DATA_PAGTO"));
                novoPedido.setFormaPagto(rs.getBoolean("FORMA_PAGTO"));
                novoPedido.setSituacao(rs.getBoolean("SITUACAO"));
                Cliente cliente = new DaoCliente(conn).consultar((rs.getString("CLIENTE_ID")));
                cliente.addPedido(novoPedido);
                Vendedor vendedor = new DaoVendedor(conn).consultar((rs.getString("VENDEDOR_ID")));
                vendedor.addPedido(novoPedido);
                ArrayList<ItemPedido> itensPedido = new DaoItemPedido(conn).consultarPeloPedido(numero);
                Double valorTotalPedido = 0.0;
                for (int i = 0; i < itensPedido.size(); i++){
                    novoPedido.addItemPedido(itensPedido.get(i));
                    
                    valorTotalPedido += itensPedido.get(i).getProduto().getPreco() * itensPedido.get(i).getQtdeVendida();
                }
                
                novoPedido.getCliente().setLimiteDisp(novoPedido.getCliente().getLimiteDisp() + valorTotalPedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (novoPedido);
    }

    public void excluir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBITEMPEDIDO WHERE PEDIDO_ID = ?");
            ps.setString(1, pedido.getNumero());
            ps.execute();
            
            ps = conn.prepareStatement("DELETE FROM TBPEDIDO WHERE NUMERO = ?");
            ps.setString(1, pedido.getNumero());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
