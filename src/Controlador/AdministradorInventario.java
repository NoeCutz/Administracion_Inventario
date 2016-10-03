/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigopeniche
 */
public class AdministradorInventario {
    private ManejadorBD manejadorBaseDatosInventario;
    
    public AdministradorInventario(){
        try {
            manejadorBaseDatosInventario.conectarConBD("root", "", "ElCaballoDeHierro");
        } catch (ClassNotFoundException excepcionBibliotecaNoHallada) {
            JOptionPane.showMessageDialog(null, excepcionBibliotecaNoHallada.getMessage() + "\n" + "No se puede conectar a la base de datos porque la libreria MySQL Conector no se encuentra");
        } catch (SQLException excepcionBaseDatosNoEncontrada) {
            JOptionPane.showMessageDialog(null,excepcionBaseDatosNoEncontrada .getMessage() + "\n" + "No se puede conectar a la base de datos porque no existe la base de datos");
        }
    }
    
    public void agregarArticulo(Articulo articulo)
    {
         
        try {
            
            String valoresArticulo = "\"" + articulo.getClave() + "\", "
                    + "\"" + articulo.getDescripcion() + "\", "
                    + "\"" + articulo.getCantidad() + "\", "
                    + "\"" + articulo.getPrecio() + "\"";
            manejadorBaseDatosInventario.insertarTupla("Articulos", valoresArticulo);
            manejadorBaseDatosInventario.conectarConBD();
        } catch (SQLException excepcionElementoNoAgregado) {
            JOptionPane.showMessageDialog(null, excepcionElementoNoAgregado.getMessage() + "\n" + "Elemento no agregado");
        }

    }

    public ResultSet buscarArticulo(String claveArticulo) {
      
        ResultSet resultadoConsultaSQL = null;
        try {
            resultadoConsultaSQL = manejadorBaseDatosInventario.buscarTupla("Articulos", "Clave", claveArticulo);
        } catch (SQLException excepcionElementoNoEncontrado) {
            
        }

        return resultadoConsultaSQL;

    }
    
    public void eliminarArticulo(String claveDeArticulo){
    
        try{
       manejadorBaseDatosInventario.conectarConBD("root", "", "ElCaballoDeHierro");
       manejadorBaseDatosInventario.eliminarTupla("Articulos", "Clave", claveDeArticulo);
       manejadorBaseDatosInventario.conectarConBD();
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Elemento no encontrado");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Artículo no encontrado");
       }
    }
    
    public ResultSet verInventario(){
        ResultSet resultadoConsultaSQL= null;
        try {
            resultadoConsultaSQL= manejadorBaseDatosInventario.obtenerTuplas("Articulos");
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultadoConsultaSQL;
        
    }

    
}
