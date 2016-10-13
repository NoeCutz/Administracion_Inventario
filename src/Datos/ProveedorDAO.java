/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Controlador.ManejadorConexionBD;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class ProveedorDAO {
    private static Connection conexionBD;
    public ProveedorDAO(){
        
    }
    
   public Proveedor buscarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
        ResultSet resultadoConsultaSQL = null;
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "SELECT * FROM proveedores WHERE Clave = \"" + claveProveedor + "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        resultadoConsultaSQL = sentenciaSQL.executeQuery(consultaSQL);
        
        resultadoConsultaSQL.next();
        
        Proveedor proveedor = new Proveedor(resultadoConsultaSQL.getString("Clave"),
               resultadoConsultaSQL.getString("Nombre"),
               resultadoConsultaSQL.getString("Telefono"),
               resultadoConsultaSQL.getString("Direccion"));
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
        return proveedor;
    }
    
   public void eliminarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "DELETE FROM proveedores WHERE Clave = \"" + claveProveedor+ "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
   
   public ArrayList<Proveedor> obtenerProveedores() throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        String consultaSQL = "SELECT * FROM proveedores";
        Statement sentenciaSQL = conexionBD.createStatement();
        ResultSet resultadoConsultaSQL;
        resultadoConsultaSQL = sentenciaSQL.executeQuery( consultaSQL );
        
        ArrayList<Proveedor> proveedores= new ArrayList<>();
        
        while (resultadoConsultaSQL.next()) {
           Proveedor proveedor = new Proveedor(resultadoConsultaSQL.getString("Clave"),
                   resultadoConsultaSQL.getString("Nombre"),
                   resultadoConsultaSQL.getString("Telefono"),
                   resultadoConsultaSQL.getString("Direccion"));
           proveedores.add(proveedor);
       }
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
        return proveedores;
    }
   
    public void insertarProveedor( Proveedor proveedorAInsertar ) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "INSERT INTO proveedores VALUES(\"" + proveedorAInsertar.getClave() + "\", "
                + "\"" + proveedorAInsertar.getNombre() + "\", "
                + "\"" + proveedorAInsertar.getTelefono() + "\", "
                + "\"" + proveedorAInsertar.getDireccion() + "\")";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate( consultaSQL );
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
    
    public void actualizarProveedor(Proveedor proveedorModificado) throws SQLException, ClassNotFoundException{
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();
        
        String consultaSQL = "UPDATE articulos SET Nombre" + " = \"" + proveedorModificado.getNombre() + "\","
                + "Telefono" + " = \"" + proveedorModificado.getTelefono() + "\","
                + "Direccion" + " = \"" + proveedorModificado.getDireccion() + "\","
                + " WHERE Clave = \"" + proveedorModificado.getClave() + "\"";
        Statement sentenciaSQL = conexionBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
        
        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
       
    }


}
