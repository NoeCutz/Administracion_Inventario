/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import controlador.ManejadorConexionBD;
import modelo.Articulo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Articulo;

/**
 *
 * @author juan
 */
public class ArticulosDAO {

    private static Connection conexionBD;
    private String consultaBD;
    private Statement sentenciaConsulta;

    public ArrayList<Articulo> obtenerInventario() throws ClassNotFoundException, SQLException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        consultaBD = "SELECT * FROM articulos";
        sentenciaConsulta = conexionBD.createStatement();
        ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);

        ArrayList<Articulo> articulos = new ArrayList<>();
        Articulo articulo;

        while (resultadoConsultaBD.next()) {
            articulo = new Articulo(resultadoConsultaBD.getString("Clave"),
                    resultadoConsultaBD.getString("ClaveProveedor"),
                    resultadoConsultaBD.getString("Descripcion"),
                    Integer.parseInt(resultadoConsultaBD.getString("Cantidad")),
                    Integer.parseInt(resultadoConsultaBD.getString("Precio")));
            articulos.add(articulo);
        }

        ManejadorConexionBD.obtenerInstancia().desconectarConBD();

        return articulos;
    }

    public void insertarArticulo(Articulo articuloAInsertar) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        consultaBD = "INSERT INTO articulos VALUES(\"" + articuloAInsertar.getClave() + "\", "
                + "\"" + articuloAInsertar.getClaveProveedor() + "\", "
                + "\"" + articuloAInsertar.getDescripcion() + "\", "
                + "\"" + articuloAInsertar.getCantidad() + "\", "
                + "\"" + articuloAInsertar.getPrecio() + "\")";
        sentenciaConsulta = conexionBD.createStatement();
        sentenciaConsulta.executeUpdate(consultaBD);

        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }

    public void eliminarArticulo(String claveArticulo) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        consultaBD = "DELETE FROM articulos WHERE clave = \"" + claveArticulo + "\"";
        sentenciaConsulta = conexionBD.createStatement();
        sentenciaConsulta.executeUpdate(consultaBD);

        ManejadorConexionBD.obtenerInstancia().desconectarConBD();
    }

    public Articulo buscarArticulo(String claveArticulo) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        consultaBD = "SELECT * FROM articulos WHERE clave = \"" + claveArticulo + "\"";
        sentenciaConsulta = conexionBD.createStatement();
        ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);

        //Salta el primero elemento del ResultSet el cual es una dirección de memoria
        resultadoConsultaBD.next();

        Articulo articulo = new Articulo(resultadoConsultaBD.getString("Clave"),
                resultadoConsultaBD.getString("ClaveProveedor"),
                resultadoConsultaBD.getString("Descripcion"),
                Integer.parseInt(resultadoConsultaBD.getString("Cantidad")),
                Integer.parseInt(resultadoConsultaBD.getString("Precio")));

        ManejadorConexionBD.obtenerInstancia().desconectarConBD();

        return articulo;
    }

    public void actualizarArticulo(Articulo articuloModificado) throws SQLException, ClassNotFoundException {
        ManejadorConexionBD.obtenerInstancia().conectarConBD();
        conexionBD = ManejadorConexionBD.obtenerConexion();

        consultaBD = "UPDATE articulos SET ClaveProveedor = \"" + articuloModificado.getClaveProveedor() + "\", "
                + "Descripcion" + " = \"" + articuloModificado.getDescripcion() + "\","
                + "Cantidad" + " = " + articuloModificado.getCantidad() + ", "
                + "Precio" + " = " + articuloModificado.getPrecio() + " "
                + " WHERE Clave = \"" + articuloModificado.getClave() + "\"";
        sentenciaConsulta = conexionBD.createStatement();
        sentenciaConsulta.executeUpdate(consultaBD);

        ManejadorConexionBD.obtenerInstancia().desconectarConBD();

    }

}
