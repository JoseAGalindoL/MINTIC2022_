/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Lider;
import Modelo.DbData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class CtLider {
    public void CtLider(DefaultTableModel modelo){
        Lider Lider = new Lider();
        
        try {
            DbData cc = new DbData();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia");
            
            while(rs.next()){
                Lider.setIdLider(rs.getInt(1));
                Lider.setNombre(rs.getString(2));
                Lider.setPrimerApellido(rs.getString(3));
                Lider.setCiudadResidencia(rs.getString(4));
                
                modelo.addRow(new Object[]{Lider.getIdLider(),Lider.getNombre(),Lider.getPrimerApellido(),Lider.getCiudadResidencia()});
                
            }
            rs.close();
            cn.close();
        } catch (SQLException ex){
            Logger.getLogger(CtLider.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
