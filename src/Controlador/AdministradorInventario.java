/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Articulo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author rodrigopeniche
 */
public class AdministradorInventario implements Administrador{
    
    private final AccesoBDArticulos accesoBDArticulos;
    
    public AdministradorInventario(){
      accesoBDArticulos = new AccesoBDArticulos();
    }

    @Override
    public void agregar(Object entidadAAgregar) {
        try {
            accesoBDArticulos.insertarArticulo((Articulo)entidadAAgregar);
            JOptionPane.showMessageDialog(null, "El artículo se ha agregado exitosamente");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el artículo");
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Object entidadAEliminar) {
        try {
            accesoBDArticulos.eliminarArticulo((String)entidadAEliminar);
            JOptionPane.showMessageDialog(null, "El articulo se ha eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar el artículo");
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Articulo buscar(Object entidadABuscar) {
        Articulo articulo = null;
        
        try {
            articulo = accesoBDArticulos.buscarArticulo((String)entidadABuscar);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showConfirmDialog(null, "Ha ocurrido un error al buscar el artículo");
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo; 
    }

    @Override
    public void actualizar(Object entidadAActualizar) {
        try {
            accesoBDArticulos.actualizarArticulo((Articulo)entidadAActualizar);
            JOptionPane.showMessageDialog(null, "Artículo actualizado exitosamente");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el artículo");
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Articulo> obtenerDatos() {
        ArrayList<Articulo> inventario=null;
        
        try {
            inventario = accesoBDArticulos.obtenerInventario();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inventario;
    }

    
}
