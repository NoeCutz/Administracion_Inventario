/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Controlador.ManejadorConexionBD;
import Modelo.Articulo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class ArticuloDAO {
    private static Connection conexionBD;
    public ArticuloDAO(){
        
    }
    
   public Articulo buscarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
        ResultSet resultadoConsultaSQL = null;
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "SELECT * FROM articulos WHERE clave = \"" + claveArticulo + "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        resultadoConsultaSQL = sentenciaSQL.executeQuery(consultaSQL);
        
        resultadoConsultaSQL.next();
        
        Articulo articulo = new Articulo(resultadoConsultaSQL.getString("Clave"),
               resultadoConsultaSQL.getString("ClaveProveedor"),
               resultadoConsultaSQL.getString("Descripcion"),
               Integer.parseInt(resultadoConsultaSQL.getString("Cantidad")),
               Integer.parseInt(resultadoConsultaSQL.getString("Precio")));
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
        return articulo;
    }
    
   public void eliminarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "DELETE FROM articulos WHERE clave = \"" + claveArticulo + "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
   
   public ArrayList<Articulo> obtenerInventario() throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        String consultaSQL = "SELECT * FROM articulos";
        Statement sentenciaSQL = conexionBD.createStatement();
        ResultSet resultadoConsultaSQL;
        resultadoConsultaSQL = sentenciaSQL.executeQuery( consultaSQL );
        
        ArrayList<Articulo> articulos= new ArrayList<>();
        
        while (resultadoConsultaSQL.next()) {
           Articulo articulo = new Articulo(resultadoConsultaSQL.getString("Clave"),
                   resultadoConsultaSQL.getString("ClaveProveedor"),
                   resultadoConsultaSQL.getString("Descripcion"),
                   Integer.parseInt(resultadoConsultaSQL.getString("Cantidad")),
                   Integer.parseInt(resultadoConsultaSQL.getString("Precio")));
           articulos.add(articulo);
       }
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
        return articulos;
    }
   
    public void insertarArticulo( Articulo articuloAInsertar ) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "INSERT INTO articulos VALUES(\"" + articuloAInsertar.getClave() + "\", "
                + "\"" + articuloAInsertar.getClaveProveedor() + "\", "
                + "\"" + articuloAInsertar.getDescripcion() + "\", "
                + "\"" + articuloAInsertar.getCantidad() + "\", "
                + "\"" + articuloAInsertar.getPrecio() + "\")";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate( consultaSQL );
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
    
    public void actualizarArticulo(Articulo articuloModificado) throws SQLException, ClassNotFoundException{
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "UPDATE articulos SET Descripcion" + " = \"" + articuloModificado.getDescripcion() + "\""
                + "Cantidad" + " = \"" + articuloModificado.getCantidad() + "\""
                + "Precio" + " = \"" + articuloModificado.getPrecio() + "\""
                + " WHERE Clave = \"" + articuloModificado.getClave() + "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
       
    }


    
    
}
