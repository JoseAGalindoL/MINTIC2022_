/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Proyecto;
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
public class CtProyecto {
    public void CtProyecto(DefaultTableModel modelo){
        Proyecto Proyecto = new Proyecto();
        
        try {
            DbData cc = new DbData();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion='Casa Campestre' AND CIUDAD IN('Santa Marta','Cartagena','Barranquilla')");
            
            while(rs.next()){
                Proyecto.setIdProyecto(rs.getInt(1));
                Proyecto.setConstructora(rs.getString(2));
                Proyecto.setNumeroHabitaciones(rs.getInt(3));
                Proyecto.setCiudad(rs.getString(4));
                
                modelo.addRow(new Object[]{Proyecto.getIdProyecto(),Proyecto.getConstructora(),Proyecto.getNumeroHabitaciones(),Proyecto.getCiudad()});
                
            }
            rs.close();
            cn.close();
        } catch (SQLException ex){
            Logger.getLogger(CtProyecto.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
