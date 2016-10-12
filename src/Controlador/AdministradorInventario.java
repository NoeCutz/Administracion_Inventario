/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
   
   public void agregarArticulo( String clave, String descripcion, int cantidad, int precio ){
        Articulo articulo= new Articulo( clave, descripcion, cantidad, precio );
        iniciarManejadorBD();
        try {
            String valoresArticulo = "\"" + articulo.getClave() + "\", " + 
                      "\"" + articulo.getDescripcion() + "\", " +
                      "\"" + articulo.getCantidad() + "\", "    +
                      "\"" + articulo.getPrecio() + "\"";      
            manejadorBD.insertarFila( "Articulos", valoresArticulo );
            JOptionPane.showMessageDialog( null, "Artículo agregado exitosamente");
        } 
        catch ( SQLException excepcionElementoNoAgregado ) {
            JOptionPane.showMessageDialog( null, excepcionElementoNoAgregado.getMessage() + 
            "\nElemento no agregado" );
        }
        finalizarManejadorBD();
    }

    public Articulo buscarArticulo( String claveArticulo ) throws SQLException {
        ResultSet resultadoConsultaSQL = null;
        iniciarManejadorBD();
        
        try {
            resultadoConsultaSQL = manejadorBD.buscarFila( "Articulos", "Clave", claveArticulo );
        } 
        catch ( SQLException excepcionElementoNoEncontrado ) {
            JOptionPane.showMessageDialog( null, "No se encontró el artículo" );
        }
        
        resultadoConsultaSQL.next();
        
        Articulo articulo= new Articulo(resultadoConsultaSQL.getString("Clave"),
                                        resultadoConsultaSQL.getString("Descripcion"),
                                        Integer.parseInt(resultadoConsultaSQL.getString("Cantidad")),
                                        Integer.parseInt(resultadoConsultaSQL.getString("Precio")));
        
        finalizarManejadorBD();
        
        return articulo;
    }
    
    public void eliminarArticulo( String claveArticulo ){
        iniciarManejadorBD();
        try{
            manejadorBD.eliminarFila("Articulos", "Clave", claveArticulo );
            JOptionPane.showMessageDialog( null, "Articulo eliminado exitosamente" );
        }  
        catch (SQLException excepcionNoEliminado) {
           JOptionPane.showMessageDialog( null, "Artículo no eliminado" );
        }
        
        finalizarManejadorBD();
    }
    
    public void actualizarArticulo(String clave, String nuevaClave, String descripcion, String cantidad, String precio) throws SQLException{
        iniciarManejadorBD();
        
        String camposTabla[]= new String[4];
        String valoresCampos[]= new String[4];
        
        camposTabla[0]= "Clave";
        camposTabla[1]= "Descripcion";
        camposTabla[2]= "Cantidad";
        camposTabla[3]= "Precio";
        
        valoresCampos[0]= nuevaClave;
        valoresCampos[1]=  descripcion;
        valoresCampos[2]= cantidad;
        valoresCampos[3]= precio;
        
        // manejadorBD.actualizarFila("Articulos", clave, nuevaClave, descripcion, cantidad, precio);
        manejadorBD.actualizarFila("Articulos", clave, camposTabla, valoresCampos);
        
        JOptionPane.showMessageDialog(null, "Articulo actualizado exitosamente");
        
        finalizarManejadorBD();
    }
    
    public ArrayList<Articulo> obtenerInventario() throws ClassNotFoundException, SQLException{
        ResultSet resultadoConsultaSQL = null;
        iniciarManejadorBD();
        
        try {
            resultadoConsultaSQL= manejadorBD.obtenerFilas( "Articulos" );
        } 
        catch ( SQLException excepcionNoHayDatos ) {
           JOptionPane.showMessageDialog( null, "No hay Articulos para mostrar" );
        }
        
        ArrayList<Articulo> articulos= new ArrayList<>();
        
        while(resultadoConsultaSQL.next()){
            Articulo articulo= new Articulo(resultadoConsultaSQL.getString("Clave"),
                                        resultadoConsultaSQL.getString("Descripcion"),
                                        Integer.parseInt(resultadoConsultaSQL.getString("Cantidad")),
                                        Integer.parseInt(resultadoConsultaSQL.getString("Precio")));
            articulos.add(articulo);
            
        }
        
        finalizarManejadorBD();
        
        return articulos;
    }

}
