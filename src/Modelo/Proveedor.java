/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Noe
 */
public class Proveedor {
    private String clave;
    private String nombre;
    private String telefono;
    private String direccion;

    public Proveedor ( String clave, String nombre, String telefono, String direccion ) {
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
    
   
}
