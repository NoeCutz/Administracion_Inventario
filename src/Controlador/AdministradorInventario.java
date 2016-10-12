/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.ArticuloDAO;
import Modelo.Articulo;
import java.sql.ResultSet;
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
    
    private ArticuloDAO articuloDAO;
    
    public AdministradorInventario(){
      articuloDAO = new ArticuloDAO();
    }

    @Override
    public void agregar(Object entidadAAgregar) {
        try {
            articuloDAO.insertarArticulo((Articulo)entidadAAgregar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Object entidadAEliminar) {
        try {
            articuloDAO.eliminarArticulo((String)entidadAEliminar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscar(Object entidadABuscar) {
        try {
            articuloDAO.buscarArticulo((String)entidadABuscar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Object entidadAActualizar) {
        try {
            articuloDAO.actualizarArticulo((Articulo)entidadAActualizar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object obtenerDatos() {
        ArrayList<Articulo> inventario=null;
        try {
            inventario = articuloDAO.obtenerInventario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventario;
    }

    
}
