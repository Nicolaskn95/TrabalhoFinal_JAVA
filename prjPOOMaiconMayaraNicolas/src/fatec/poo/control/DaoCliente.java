package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Cliente;

/**
 *
 * @author Lenovo
 */
public class DaoCliente {
    private Connection conn;

    public DaoCliente(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBCLIENTE(CPF, NOME, ENDERECO, CIDADE, CEP, UF, TELEFONE_DDD,"
                    + "TELEFONE_NUMERO, LIMITE_CREDITO, LIMITE_DISPONIVEL) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE TBCLIENTE SET NOME = ?, ENDERECO = ?, CIDADE = ?, CEP = ?, UF = ?, TELEFONE_DDD = ?,"
                            + "TELEFONE_NUMERO = ?, LIMITE_CREDITO = ?, LIMITE_DISPONIVEL = ? " +
                            "WHERE CPF = ?");

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Cliente consultar(String cpf) {
        Cliente newClient = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBCLIENTE WHERE CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                newClient = new Cliente(cpf, rs.getString("NOME"), rs.getDouble("LIMITE_CREDITO"));
                newClient.setCep(rs.getString("CEP"));
                newClient.setCidade(rs.getString("CIDADE"));
                newClient.setDdd(rs.getString("TELEFONE_DDD"));
                newClient.setTelefone(rs.getString("TELEFONE_NUMERO"));
                newClient.setEndereco(rs.getString("ENDERECO"));
                newClient.setLimiteDisp(rs.getDouble("LIMITE_DISPONIVEL"));
                newClient.setUf(rs.getString("UF"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (newClient);
    }

    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBCLIENTE WHERE CPF = ?");

            ps.setString(1, cliente.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
