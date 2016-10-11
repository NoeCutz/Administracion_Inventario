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
    
    private ManejadorBD manejadorBD;
    
    public AdministradorInventario(){
        manejadorBD = new ManejadorBD();
      
    }
   
   public void iniciarManejadorBD(){
         try {
            manejadorBD.conectarConBD( "root", "", "ElCaballoDeHierro" );
        } 
        catch ( ClassNotFoundException excepcionBibliotecaNoHallada ) {
            JOptionPane.showMessageDialog ( null, excepcionBibliotecaNoHallada.getMessage() + 
                    "\nNo se puede conectar a la base de datos porque la libreria MySQL Conector no se encuentra");
        } 
        catch ( SQLException excepcionBaseDatosNoEncontrada ) {
            JOptionPane.showMessageDialog ( null, excepcionBaseDatosNoEncontrada.getMessage() + 
                    "\nNo se puede conectar a la base de datos porque no existe la base de datos" );
        }
   } 
   
   public void finalizarManejadorBD(){
        try {
            manejadorBD.desconectarConBD();
        } catch ( SQLException excepcionConexionNoCerrada ) {
            JOptionPane.showMessageDialog( null, excepcionConexionNoCerrada.getMessage() +
                     "\nNo se puede desconectar de la base de datos" );
        }
   } 
   
   public void agregarArticulo( String clave, String claveProveedor, String descripcion, int cantidad, int precio ){
        Articulo articulo= new Articulo( clave, claveProveedor, descripcion, cantidad, precio );
        iniciarManejadorBD();
        try {
            String valoresArticulo = "\"" + articulo.getClave() + "\", " + 
                      "\"" + articulo.getClaveProveedor() + "\", " +
                      "\"" + articulo.getDescripcion() + "\", " +
                      "\"" + articulo.getCantidad() + "\", "    +
                      "\"" + articulo.getPrecio() + "\"";      
            manejadorBD.insertarFila( "Articulos", valoresArticulo );
            manejadorBD.desconectarConBD();
            JOptionPane.showMessageDialog( null, "Artículo agregado exitosamente");
        } 
        catch ( SQLException excepcionElementoNoAgregado ) {
            JOptionPane.showMessageDialog( null, excepcionElementoNoAgregado.getMessage() + 
            "\nElemento no agregado" );
        }
        finalizarManejadorBD();
    }

    public ResultSet buscarArticulo( String claveArticulo ) {
        ResultSet resultadoConsultaSQL = null;
        iniciarManejadorBD();
        try {
            resultadoConsultaSQL = manejadorBD.buscarFila( "Articulos", "Clave", claveArticulo );
         
        } 
        catch ( SQLException excepcionElementoNoEncontrado ) {
            JOptionPane.showMessageDialog( null, "No se encontró el artículo" );
        }
        finalizarManejadorBD();
        return resultadoConsultaSQL;
    }
    
    public void eliminarArticulo( String claveDeArticulo ){
        iniciarManejadorBD();
        try{
            manejadorBD.eliminarFila( "Articulos", "Clave", claveDeArticulo );
            JOptionPane.showMessageDialog( null, "Articulo eliminado exitosamente" );
        }  
        catch (SQLException excepcionNoEliminado) {
           JOptionPane.showMessageDialog( null, "Artículo no eliminado" );
        }
        
        finalizarManejadorBD();
    }
    
    public ResultSet verInventario() throws ClassNotFoundException{
        ResultSet resultadoConsultaSQL = null;
        iniciarManejadorBD();
        try {
            resultadoConsultaSQL= manejadorBD.obtenerFilas( "Articulos" );
        } 
        catch ( SQLException excepcionNoHayDatos ) {
           JOptionPane.showMessageDialog( null, "No hay Articulos para mostrar" );
        }
        finalizarManejadorBD();
        return resultadoConsultaSQL;
    }

}
