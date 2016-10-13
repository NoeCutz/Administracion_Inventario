/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Proveedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
class AccesoBDProveedores {
    
    private static Connection conexionBD;
    private String consultaBD;
    private Statement sentenciaConsulta;
   
    ArrayList<Proveedor> obtenerProveedores() throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia().conectarConBD();
         conexionBD = ManejadorConexionBD.obtenerConexion();

         consultaBD = "SELECT * FROM proveedores";
         sentenciaConsulta = conexionBD.createStatement();;
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD );
        
         ArrayList<Proveedor> proveedores= new ArrayList<>();
         Proveedor proveedor;
        
         while (resultadoConsultaBD.next()) {
            proveedor = new Proveedor(resultadoConsultaBD.getString("Clave"),
                                      resultadoConsultaBD.getString("Nombre"),
                                      resultadoConsultaBD.getString("Telefono"),
                                      resultadoConsultaBD.getString("Direccion"));

            proveedores.add(proveedor);
         }
        
         ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
         return proveedores;
    }
   
     void insertarProveedor( Proveedor proveedorAInsertar ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia().conectarConBD();
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = "INSERT INTO proveedores VALUES(\"" + proveedorAInsertar.getClave() + "\", "
                                                          + "\"" + proveedorAInsertar.getNombre() + "\", "
                                                          + "\"" + proveedorAInsertar.getTelefono() + "\", "
                                                          + "\"" + proveedorAInsertar.getDireccion() + "\")";
         sentenciaConsulta = conexionBD.createStatement();
         sentenciaConsulta.executeUpdate(consultaBD );
        
         ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
   
    void eliminarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia().conectarConBD();
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = "DELETE FROM proveedores WHERE Clave = \"" + claveProveedor+ "\"";
         sentenciaConsulta = conexionBD.createStatement();
         sentenciaConsulta.executeUpdate(consultaBD);
        
         ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
   
    Proveedor buscarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia().conectarConBD();
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = "SELECT * FROM proveedores WHERE Clave = \"" + claveProveedor + "\"";
         sentenciaConsulta = conexionBD.createStatement();
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);
        
         //Salta el primer elemento del ResultSet el cual es una direccion de memoria
         resultadoConsultaBD.next();
        
         Proveedor proveedor = new Proveedor(resultadoConsultaBD.getString("Clave"),
                                             resultadoConsultaBD.getString("Nombre"),
                                             resultadoConsultaBD.getString("Telefono"),
                                             resultadoConsultaBD.getString("Direccion"));
        
         ManejadorConexionBD.obtenerInstancia().desconectarConBD();
        
         return proveedor;
    }
    
     void actualizarProveedor(Proveedor proveedorModificado) throws SQLException, ClassNotFoundException{
         ManejadorConexionBD.obtenerInstancia().conectarConBD();
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = "UPDATE proveedores SET Nombre" + " = \"" + proveedorModificado.getNombre() + "\","
                                           + "Telefono" + "=\"" + proveedorModificado.getTelefono()+ "\","
                                           + "Direccion" + "=\"" + proveedorModificado.getDireccion() + "\""
                                           + " WHERE Clave = \"" + proveedorModificado.getClave() + "\"";
         sentenciaConsulta = conexionBD.createStatement();
         sentenciaConsulta.executeUpdate(consultaBD);
        
         ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }
    
}
