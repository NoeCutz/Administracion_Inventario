/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.ProveedorDAO;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class AdministradorProveedores implements Administrador{

   private ProveedorDAO proveedorDAO;
    
    public AdministradorProveedores(){
      proveedorDAO = new ProveedorDAO();
    }

    @Override
    public void agregar(Object entidadAAgregar) {
        try {
            proveedorDAO.insertarProveedor((Proveedor)entidadAAgregar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Object entidadAEliminar) {
        try {
            proveedorDAO.eliminarProveedor((String)entidadAEliminar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Proveedor buscar(Object entidadABuscar) {
        Proveedor proveedor = null;
        
        try {
            proveedor = proveedorDAO.buscarProveedor((String)entidadABuscar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }

    @Override
    public void actualizar(Object entidadAActualizar) {
        try {
            proveedorDAO.actualizarProveedor((Proveedor)entidadAActualizar);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object obtenerDatos() {
        ArrayList<Proveedor> proveedores=null;
        try {
            proveedores = proveedorDAO.obtenerProveedores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }

    
}
