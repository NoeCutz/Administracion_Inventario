/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class ManejadorConexionBD {
    
    private static String urlBD = "jdbc:mysql://localhost:3306/";
    private static String nombreControlador = "com.mysql.jdbc.Driver";
    private static String usuario = "root";
    private static String contrasenia = "";
    private static ManejadorConexionBD instanciaManejadorConexion = null;
    private static Connection conexion;
    
    
    private static void generarInstancia(){
        instanciaManejadorConexion = new ManejadorConexionBD();
    }
    
    public static ManejadorConexionBD obtenerInstancia(){
        if(instanciaManejadorConexion == null){
             generarInstancia();
        }
        
        return instanciaManejadorConexion;
    }

    public void conectarConBD () throws ClassNotFoundException, SQLException {
        Class.forName(nombreControlador);
        conexion=DriverManager.getConnection( urlBD + "elcaballodehierro", usuario, contrasenia );
    }

    public void desconectarConBD() throws SQLException {
        conexion.close();
    }

    public static Connection obtenerConexion() {
        return conexion;
    }
    
    
    
}
