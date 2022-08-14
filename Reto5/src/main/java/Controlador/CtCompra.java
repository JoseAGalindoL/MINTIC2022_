/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Compra;
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
public class CtCompra {
     public void CtCompra(DefaultTableModel modelo){
        Compra Compra = new Compra();
        
        try {
            DbData cc = new DbData();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON (c.ID_Proyecto=p.ID_Proyecto) WHERE Proveedor = 'Homecenter' AND p.Ciudad ='Salento'");
            
            while(rs.next()){
                Compra.setIdCompra(rs.getInt(1));
                Compra.setConstructora(rs.getString(2));
                Compra.setBancoVinculado(rs.getString(3));
                
                modelo.addRow(new Object[]{Compra.getIdCompra(),Compra.getConstructora(),Compra.getBancoVinculado()});
                
            }
            rs.close();
            cn.close();
        } catch (SQLException ex){
            Logger.getLogger(CtCompra.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
