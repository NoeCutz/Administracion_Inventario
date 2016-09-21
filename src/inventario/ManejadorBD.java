package inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ManejadorBD {

    // BD: Base de Datos
    private static Connection conexionConBD;

    public void conectarConMySQL(String usuario, String contrasena, String nombreBD) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            conexionConBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, usuario, contrasena);
    }

    public void desconectarConMySQL() throws SQLException {
            conexionConBD.close();
    }

    public void crearBD(String nombreDeBD, String nombreDeUsuario, String contrasenia) throws SQLException, ClassNotFoundException {
            String comandoSQL = "CREATE DATABASE " + nombreDeBD;
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
            conectarConMySQL(nombreDeUsuario, contrasenia , nombreDeBD);
    }

    public void crearTabla(String nombreDeTabla, String camposTabla) throws SQLException {
            String comandoSQL = "CREATE TABLE " + nombreDeTabla + camposTabla;
            JOptionPane.showMessageDialog(null, "Se ha creado la base de tabla " + nombreDeTabla + " de forma exitosa");
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
    }
    
    public void eliminarTabla(String nombreDeTabla) throws SQLException {
            String comandoSQL = "DROP TABLE IF EXISTS" + nombreDeTabla;
            JOptionPane.showMessageDialog(null, "Se ha eliminado la tabla" + nombreDeTabla + " de forma exitosa");
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
    }

    public void insertarTupla(String nombreDeTabla, String valoresTupla) throws SQLException {
            String consultaSQL = "INSERT INTO " + nombreDeTabla + " VALUES("+valoresTupla;
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
    }
    
    public ResultSet obtenerTuplas(String nombreDeTabla) throws SQLException {
            String consultaSQL = "SELECT * FROM " + nombreDeTabla;
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL = sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;
    }
    
    public ResultSet buscarTupla(String nombreDeTabla, String campoLlavePrimaria, String valorLlavePrimaria) throws SQLException
    {
            String consultaSQL = "SELECT * FROM " + nombreDeTabla + " WHERE "+campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL= sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;
    }

    public void eliminarTupla(String nombreDeTabla, String campoLlavePrimaria, String valorLlavePrimaria) throws SQLException {
             String consultaSQL = "SELECT * FROM " + nombreDeTabla + " WHERE "+campoLlavePrimaria +"= \"" + valorLlavePrimaria + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
            JOptionPane.showMessageDialog(null, "Artículo borrado exitosamente");
    }
  
}
