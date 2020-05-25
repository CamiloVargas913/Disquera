/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.model;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Cancion implements Serializable{
    private int id;
    private String nombre;
    private double duracion;
    private String album;
    private String formato;
    private double precio;

    public Cancion(int id, String nombre, double duracion, String album, String formato, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.album = album;
        this.formato = formato;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
   
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
