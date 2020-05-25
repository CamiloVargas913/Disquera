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
public class Db implements Serializable{
    private ArrayList<Cancion> canciones;
    private ArrayList<Usuario> usuario;
    private ArrayList<Album> album;

    public Db(ArrayList<Cancion> canciones, ArrayList<Usuario> usuario, ArrayList<Album> album) {
        this.canciones = canciones;
        this.usuario = usuario;
        this.album = album;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Album> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<Album> album) {
        this.album = album;
    }
    
}
