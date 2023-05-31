package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Produto;

/**
 *
 * @author Lenovo
 */
public class DaoProduto {
    private Connection conn;

    public DaoProduto(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBPRODUTO(CODIGO_PRODUTO,"
                    + "DESCRICAO, QTDE_DISPONIVEL, PRECO_UNIT, ESTOQUE_MINIMO)"
                    + "VALUES(?,?,?,?,?)");
            ps.setString(1, produto.getCodigo().toUpperCase());
            ps.setString(2, produto.getDescricao().toUpperCase().toUpperCase());
            ps.setDouble(3, produto.getQtdeEstoque());
            ps.setDouble(4, produto.getPreco());
            ps.setDouble(5, produto.getEstoqueMinimo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBPRODUTO SET DESCRICAO = ?, "
                    + "QTDE_DISPONIVEL = ?, "
                    + "PRECO_UNIT = ?, "
                    + "ESTOQUE_MINIMO = ? "
                    + "WHERE CODIGO_PRODUTO = ?");

            ps.setString(1, produto.getDescricao().toUpperCase());
            ps.setDouble(2, produto.getQtdeEstoque());
            ps.setDouble(3, produto.getPreco());
            ps.setDouble(4, produto.getEstoqueMinimo());
            ps.setString(5, produto.getCodigo().toUpperCase());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Produto consultar(String codigo) {
        Produto p = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBPRODUTO WHERE " +
                    "CODIGO_PRODUTO = ?");

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                p = new Produto(codigo, rs.getString("DESCRICAO"));
                p.setEstoqueMinimo(rs.getDouble("ESTOQUE_MINIMO"));
                p.setPreco(rs.getDouble("PRECO_UNIT"));
                p.setQtdeEstoque(rs.getDouble("QTDE_DISPONIVEL"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (p);
    }

    public void excluir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBPRODUTO WHERE CODIGO_PRODUTO = ?");

            ps.setString(1, produto.getCodigo().toUpperCase());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
