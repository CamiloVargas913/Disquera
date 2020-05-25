/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PROFESIONAL
 */
public class Album implements Serializable {
    private int id;
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(int id, String nombre, String artista, ArrayList<Cancion> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = canciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    
    
}
