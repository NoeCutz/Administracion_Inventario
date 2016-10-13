/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.datos.ProveedoresDAO;
import modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class AdministradorProveedores implements Administrador{

   private final ProveedoresDAO accesoBDProveedores;
    
    public AdministradorProveedores(){
      accesoBDProveedores = new ProveedoresDAO();
    }

    @Override
    public void agregar(Object entidadAAgregar) {
        try {
            accesoBDProveedores.insertarProveedor((Proveedor)entidadAAgregar);
            JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Object entidadAEliminar) {
        try {
            accesoBDProveedores.eliminarProveedor((String)entidadAEliminar);
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Proveedor buscar(Object entidadABuscar) {
        Proveedor proveedor = null;
        
        try {
            proveedor = accesoBDProveedores.buscarProveedor((String)entidadABuscar);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proveedor;
    }

    @Override
    public void actualizar(Object entidadAActualizar) {
        try {
            accesoBDProveedores.actualizarProveedor((Proveedor)entidadAActualizar);
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Proveedor> obtenerDatos() {
        ArrayList<Proveedor> proveedores=null;
                
        try {
            proveedores = accesoBDProveedores.obtenerProveedores();
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proveedores;
    }

    
}
