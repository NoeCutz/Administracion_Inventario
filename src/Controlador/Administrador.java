/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigopeniche
 */
public class Administrador {
    
    public void agregarArticulo(Articulo articulo)
    {
         ManejadorBD baseDeDatos = new ManejadorBD();
        try {
            baseDeDatos.conectarConBD("root", "", "ElCaballoDeHierro");
            String valores = "\"" + articulo.getClave() + "\", "
                    + "\"" + articulo.getDescripcion() + "\", "
                    + "\"" + articulo.getCantidad() + "\", "
                    + "\"" + articulo.getPrecio() + "\"";
            baseDeDatos.insertarTupla("Articulos", valores);
            baseDeDatos.conectarConBD();
        } catch (ClassNotFoundException excepcionBibliotecaNoHallada) {
            JOptionPane.showMessageDialog(null, excepcionBibliotecaNoHallada.getMessage() + "\n" + "Biblioteca no encontrada");
        } catch (SQLException excepcionElementoNoHallado) {
            JOptionPane.showMessageDialog(null, excepcionElementoNoHallado.getMessage() + "\n" + "Elemento no encontrado");
        }

    }

    public ResultSet buscarArticulo(String claveDeArticulo) {
        ManejadorBD baseDeDatos = new ManejadorBD();
        ResultSet resultadoConsultaSQL = null;
        try {
            resultadoConsultaSQL = baseDeDatos.buscarTupla("Articulos", "Clave", claveDeArticulo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultadoConsultaSQL;

    }
    
    public void eliminarArticulo(String claveDeArticulo){
    
        try{
       ManejadorBD baseDeDatos = new ManejadorBD();
       baseDeDatos.conectarConBD("root", "", "ElCaballoDeHierro");
       baseDeDatos.eliminarTupla("Articulos", "Clave", claveDeArticulo);
       baseDeDatos.conectarConBD();
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Elemento no encontrado");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Artículo no encontrado");
       }
    }
    
    public ResultSet verInventario(){
        ResultSet resultadoConsultaSQL= null;
        try {
            ManejadorBD baseDeDatos= new ManejadorBD();
            resultadoConsultaSQL= baseDeDatos.obtenerTuplas("Articulos");
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultadoConsultaSQL;
        
    }

    
}
