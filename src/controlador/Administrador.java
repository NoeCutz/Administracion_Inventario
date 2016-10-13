/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Jeremiah
 */
public interface Administrador {
    
    public void agregar(Object entidadAAgregar);
    public void eliminar(Object entidadAEliminar);
    public Object buscar(Object entidadABuscar);
    public void actualizar(Object entidadAActualizar);
    public Object obtenerDatos();
    
}
