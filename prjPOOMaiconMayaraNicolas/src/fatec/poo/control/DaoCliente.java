package fatec.poo.control;

import fatec.poo.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class DaoCliente {
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Cliente departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbdepartamento(Sigla_Dep, Nome_Dep) VALUES(?,?)");
            ps.setString(1, departamento.getSigla());
            ps.setString(2, departamento.getNome());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbdepartamento set Nome_Dep = ? " +
                                                 "where Sigla_Dep = ?");
            
            ps.setString(1, departamento.getNome());
            ps.setString(2, departamento.getSigla());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Cliente consultar (String sigla) {
        Cliente d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbCliente where " +
                                                 "Sigla_Dep = ?");
            
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Cliente (sigla, rs.getString("Nome_Cli"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Cliente departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbdepartamento where Sigla_Dep = ?");
            
            ps.setString(1, departamento.getSigla());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }    
}
