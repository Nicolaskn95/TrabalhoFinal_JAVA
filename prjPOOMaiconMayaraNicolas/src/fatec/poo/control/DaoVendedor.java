package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Vendedor;

public class DaoVendedor {
    private Connection conn;

    public DaoVendedor(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBVENDEDOR(CPF, NOME, ENDERECO, CIDADE, CEP, UF, TELEFONE_DDD,"
                    + "TELEFONE_NUMERO, SALARIO_BASE, COMISSAO) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vendedor.getCpf().replaceAll("[.-]", ""));
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getCep());
            ps.setString(6, vendedor.getUf());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getTelefone());
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getTaxaComissao());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBVENDEDOR SET NOME = ?, ENDERECO = ?, CIDADE = ?, CEP = ?, "
                    + "UF = ?, TELEFONE_DDD = ?, TELEFONE_NUMERO = ?, SALARIO_BASE = ?, COMISSAO = ? "
                    + "WHERE CPF = ?");

            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getCep());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getDdd());
            ps.setString(7, vendedor.getTelefone());
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getTaxaComissao());
            ps.setString(10, vendedor.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Vendedor consultar(String cpf) {
        Vendedor seller = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBVENDEDOR WHERE CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                seller = new Vendedor(cpf, rs.getString("NOME"), rs.getDouble("SALARIO_BASE"));
                seller.setCep(rs.getString("CEP"));
                seller.setCidade(rs.getString("CIDADE"));
                seller.setDdd(rs.getString("TELEFONE_DDD"));
                seller.setTelefone(rs.getString("TELEFONE_NUMERO"));
                seller.setEndereco(rs.getString("ENDERECO"));
                seller.setTaxaComissao(rs.getDouble("COMISSAO"));
                seller.setUf(rs.getString("UF"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (seller);
    }

    public void excluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBVENDEDOR WHERE CPF = ?");

            ps.setString(1, vendedor.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
