package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;

/**
 *
 * @author Lenovo
 */
public class DaoItemPedido {
    private Connection conn;

    public DaoItemPedido(Connection conn) {
        this.conn = conn;
    }

    public void inserir(ItemPedido itemPedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBITEMPEDIDO(SEQUENCIA, QTDE_VENDIDA, PRODUTO_ID, PEDIDO_ID) "
                    + "VALUES(?,?,?,?)");
            ps.setInt(1, itemPedido.getSequencia());
            ps.setDouble(2, itemPedido.getQtdeVendida());
            ps.setString(3, itemPedido.getProduto().getCodigo());
            ps.setString(4, itemPedido.getPedido().getNumero());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(ItemPedido itemPedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE TBITEMPEDIDO SET QTDE_VENDIDA = ?, PRODUTO_ID = ?, PEDIDO_ID = ?" +
                            "WHERE SEQUENCIA = ?");

            ps.setDouble(1, itemPedido.getQtdeVendida());
            ps.setString(2, itemPedido.getProduto().getCodigo());
            ps.setString(3, itemPedido.getPedido().getNumero());
            ps.setInt(4, itemPedido.getSequencia());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public ItemPedido consultar(int sequencia) {
        ItemPedido newItem = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBITEMPEDIDO WHERE SEQUENCIA = ?");

            ps.setInt(1, sequencia);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                Produto produto = new DaoProduto(conn).consultar(rs.getString("PRODUTO_ID"));
                newItem = new ItemPedido(sequencia, rs.getDouble("QTDE_VENDIDA"), produto);
                Pedido pedido = new DaoPedido(conn).consultar(rs.getString("PEDIDO_ID"));
                pedido.addItemPedido(newItem);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (newItem);
    }

    public ArrayList<ItemPedido> consultarPeloPedido(String numeroPedido) {
        ItemPedido i = null;
        ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBITEMPEDIDO WHERE PEDIDO_ID = ?");

            ps.setString(1, numeroPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int sequencia = rs.getInt("SEQUENCIA");
                double qtdVendida = rs.getDouble("QTDE_VENDIDA");
                Produto produto = new DaoProduto(conn).consultar(rs.getString("PRODUTO_ID"));
                i = new ItemPedido(sequencia, qtdVendida, produto);

                itens.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (itens);
    }

    public void excluir(ItemPedido itemPedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBITEMPEDIDO WHERE SEQUENCIA = ?");

            ps.setInt(1, itemPedido.getSequencia());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluirItensDoPedido(String numeroPedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBITEMPEDIDO WHERE PEDIDO_ID = ?");

            ps.setString(1, numeroPedido);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
