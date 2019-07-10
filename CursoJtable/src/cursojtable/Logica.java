/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojtable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHAPARRO
 */
public class Logica {
    
    public DefaultTableModel mostrarPersonas()
    {

        int contador = 1; // Dedicado para acomular en número de registros que hay en la tabla
        
        String []  nombresColumnas = {"  #  ","id","Nombre","Telefono"," "};//Indica el nombre de las columnas en la tabla
        
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        
        String sql = "SELECT * FROM persona";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;                           
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = Integer.toString(contador);
                
                registros[1] = rs.getString("id");
                
                registros[2] = rs.getString("nombre");
               
                registros[3] = rs.getString("telefono");                                
                
                modelo.addRow(registros);
                
                contador++;
                
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    public boolean eliminarRegistro(int id)
    {
        String sql = "DELETE FROM persona WHERE id = ?";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            int i = pst.executeUpdate();
            
            return i != 0;
            
        }
        catch(SQLException e )
        {
            System.out.println("Errero al eliminar registro "+e.getMessage());
            
            return false;
        }
        finally
        {
            try
            {
                if (pst != null) pst.close();
                if (cn != null) cn.close();                
            }
            catch(SQLException e)
            {
                throw new RuntimeException("Error...");
            }
        }
    }
    
    public DefaultTableModel buscarPersonas(String buscar)
    {

        int contador = 1; // Dedicado para acomular en número de registros que hay en la tabla
        
        String []  nombresColumnas = {"  #  ","id","Nombre","Telefono"," "};//Indica el nombre de las columnas en la tabla
        
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        
        String sql = "SELECT * FROM persona WHERE id LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;                           
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = Integer.toString(contador);
                
                registros[1] = rs.getString("id");
                
                registros[2] = rs.getString("nombre");
               
                registros[3] = rs.getString("telefono");                                
                
                modelo.addRow(registros);
                
                contador++;
                
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }    
}
