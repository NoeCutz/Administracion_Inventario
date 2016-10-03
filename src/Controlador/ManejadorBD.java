package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ManejadorBD {

    // BD: Base de Datos
    private static Connection conexionConBD;

    public void conectarConBD(String usuario, String contrasena, String nombreBD) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            conexionConBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, usuario, contrasena);
    }

    public void conectarConBD() throws SQLException {
            conexionConBD.close();
    }

    public void crearBD(String nombreBD, String nombreUsuario, String contrasenia) throws SQLException, ClassNotFoundException {
            String comandoSQL = "CREATE DATABASE " + nombreBD;
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
            ManejadorBD.this.conectarConBD(nombreUsuario, contrasenia , nombreBD);
    }

    public void crearTabla(String nombreTabla, String camposTabla) throws SQLException {
            String comandoSQL = "CREATE TABLE " + nombreTabla + camposTabla;
            JOptionPane.showMessageDialog(null, "Se ha creado la base de tabla " + nombreTabla + " de forma exitosa");
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
    }
    
    public void eliminarTabla(String nombreTabla) throws SQLException {
            String comandoSQL = "DROP TABLE IF EXISTS" + nombreTabla;
            JOptionPane.showMessageDialog(null, "Se ha eliminado la tabla" + nombreTabla + " de forma exitosa");
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
    }

    public void insertarTupla(String nombreTabla, String valoresTupla) throws SQLException {
            String consultaSQL = "INSERT INTO " + nombreTabla + " VALUES("+valoresTupla+")";
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
            JOptionPane.showMessageDialog(null, "Artículo agregado exitosamente");
    }
    
    public void eliminarTupla(String nombreTabla, String campoLlavePrimaria, String valorLlavePrimaria) throws SQLException {
            String consultaSQL = "DELETE FROM " + nombreTabla + " WHERE " + campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
            JOptionPane.showMessageDialog(null, "Artículo borrado exitosamente");
    }
    
    public ResultSet obtenerTuplas(String nombreTabla) throws SQLException {
            String consultaSQL = "SELECT * FROM " + nombreTabla;
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL = sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;
    }
    
    public ResultSet buscarTupla(String nombreTabla, String campoLlavePrimaria, String valorLlavePrimaria) throws SQLException
    {
            String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL= sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;
    }

    
  
}
