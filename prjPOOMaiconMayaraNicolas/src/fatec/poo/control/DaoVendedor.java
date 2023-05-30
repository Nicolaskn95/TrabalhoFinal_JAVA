package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class DaoVendedor {
    private Connection conn;
    
    public DaoDepartamento(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Departamento departamento) {
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
    
    public void alterar(Departamento departamento) {
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
        
     public  Departamento consultar (String sigla) {
        Departamento d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbDepartamento where " +
                                                 "Sigla_Dep = ?");
            
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Departamento (sigla, rs.getString("Nome_Dep"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Departamento departamento) {
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
