package inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OperacionesBDInventario {

    // BD: Base de Datos
    private static Connection conexionConBD;

    public void conectarConMySQL(String usuario, String contrasena, String nombreBD) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionConBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, usuario, contrasena);
            //System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesBDInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBDInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarConexionConMySQL() {
        try {
            conexionConBD.close();
            //System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBDInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearBD(String nombreDeBD) {
        // BD: Base de Datos
        try {
            String comandoSQL = "CREATE DATABASE " + nombreDeBD;
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
            conectarConMySQL("root", "", nombreDeBD);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + nombreDeBD + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBDInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTablaInventario(String nombreDeTabla) {
        try {
            String comandoSQL = "CREATE TABLE " + nombreDeTabla + ""
                    + "(Clave VARCHAR(25) PRIMARY KEY, Descripcion VARCHAR(100), Cantidad INT , Precio INT)";
            JOptionPane.showMessageDialog(null, "Se ha creado la base de tabla " + nombreDeTabla + " de forma exitosa");
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(comandoSQL);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBDInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarArticuloEnInventario(String nombreDeTabla, String claveDeArticulo, String descripcionDeArticulo, int cantidadDeArticulo, int precioDeArticulo) {
        try {
            String consultaSQL = "INSERT INTO " + nombreDeTabla + " VALUES("
                    + "\"" + claveDeArticulo + "\", "
                    + "\"" + descripcionDeArticulo + "\", "
                    + "\"" + cantidadDeArticulo + "\", "
                    + "\"" + precioDeArticulo + "\")";
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
            JOptionPane.showMessageDialog(null, "Artículo almacenado exitosamente");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento del artículo");
        }
    }

    public ResultSet obtenerInventario(String nombreDeTabla) {
        
        try {
            String consultaSQL = "SELECT * FROM " + nombreDeTabla;
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL = sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la obtención del inventario");
        }
        
        return null;
    }
    
    public ResultSet buscarArticuloEnInventario(String nombreDetabla, String claveDeArticulo)
    {
         try {
            String consultaSQL = "SELECT * FROM " + nombreDetabla + " WHERE Clave = \"" + claveDeArticulo + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            ResultSet resultadosConsultaSQL;
            resultadosConsultaSQL= sentenciaSQL.executeQuery(consultaSQL);
            return resultadosConsultaSQL;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontró el artículo");
        }
         
         return null;
    }

    public void eliminarArticuloDeInventario(String nombreDeTabla, String claveDeArticulo) {
        try {
            String consultaSQL = "DELETE FROM " + nombreDeTabla + " WHERE Clave = \"" + claveDeArticulo + "\"";
            Statement sentenciaSQL = conexionConBD.createStatement();
            sentenciaSQL.executeUpdate(consultaSQL);
            JOptionPane.showMessageDialog(null, "Artículo borrado exitosamente");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el articulo especificado");
        }
    }
    
    

}
