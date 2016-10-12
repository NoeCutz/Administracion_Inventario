package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ManejadorBD {

    // BD: Base de Datos
    private static Connection conexionConBD;

    void conectarConBD ( String usuario, String contrasena, String nombreBD ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexionConBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, usuario, contrasena);
    }

    void desconectarConBD() throws SQLException {
        conexionConBD.close();
    }

    void crearBD ( String nombreBD, String nombreUsuario, String contrasenia ) throws SQLException, ClassNotFoundException {
        String comandoSQL = "CREATE DATABASE " + nombreBD;
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate ( comandoSQL );
        ManejadorBD.this.conectarConBD ( nombreUsuario, contrasenia , nombreBD );
    }

    void crearTabla ( String nombreTabla, String camposTabla ) throws SQLException {
        String comandoSQL = "CREATE TABLE " + nombreTabla + camposTabla;
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate ( comandoSQL );
    }
    
    void eliminarTabla( String nombreTabla ) throws SQLException {
        String consultaSQL = "DROP TABLE IF EXISTS" + nombreTabla;
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL );
    }

    void insertarFila( String nombreTabla, String valoresTupla ) throws SQLException {
        String consultaSQL = "INSERT INTO " + nombreTabla + " VALUES("+valoresTupla+")";
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate( consultaSQL );
    }
    
    void actualizarFila( String nombreTabla, String valorClave, String nuevoValorClave,
                           String valorDescripcion, String valorCantidad, String valorPrecio) throws SQLException{
        String campoClave= "Clave";
        String campoDescripcion= "Descripcion";
        String campoCantidad= "Cantidad";
        String campoPrecio= "Precio";
        String consultaSQL= "UPDATE" + nombreTabla + "SET" + campoClave +"= \"" + nuevoValorClave + "\""
                                                           + campoDescripcion +"= \"" + valorDescripcion + "\""
                                                           + campoCantidad +"= \"" + valorCantidad + "\""
                                                           + campoPrecio +"= \"" + valorPrecio + "\""
                + "WHERE" + campoClave +"= \"" + valorClave + "\"";
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
       
    }
    
    void eliminarFila( String nombreTabla, String campoLlavePrimaria, String valorLlavePrimaria ) throws SQLException {
        String consultaSQL = "DELETE FROM " + nombreTabla + " WHERE " + campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
        Statement sentenciaSQL = conexionConBD.createStatement();
        sentenciaSQL.executeUpdate(consultaSQL);
    }
    
    ResultSet obtenerFilas( String nombreTabla ) throws SQLException {
        String consultaSQL = "SELECT * FROM " + nombreTabla;
        Statement sentenciaSQL = conexionConBD.createStatement();
        ResultSet resultadosConsultaSQL;
        resultadosConsultaSQL = sentenciaSQL.executeQuery( consultaSQL );
            
        return resultadosConsultaSQL;
    }
    
    ResultSet buscarFila( String nombreTabla, String campoLlavePrimaria, String valorLlavePrimaria ) throws SQLException{
        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
        Statement sentenciaSQL = conexionConBD.createStatement();
        ResultSet resultadosConsultaSQL;
        resultadosConsultaSQL= sentenciaSQL.executeQuery( consultaSQL );
            
        return resultadosConsultaSQL;
    }

}
