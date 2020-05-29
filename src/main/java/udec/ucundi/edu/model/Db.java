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
public class Db implements Serializable {

    /**
     * variable para almacenar la lista de canciones
     */
    private ArrayList<Cancion> canciones;
    /**
     * variable para almacenar la lista de usuarios
     */
    private ArrayList<Usuario> usuario;
    /**
     * variable para almacenar la lista de albumes
     */
    private ArrayList<Album> album;

    /**
     * constructor de la clse que inicializa todas las variables
     *
     * @param canciones
     * @param usuario
     * @param album
     */
    public Db(ArrayList<Cancion> canciones, ArrayList<Usuario> usuario, ArrayList<Album> album) {
        this.canciones = canciones;
        this.usuario = usuario;
        this.album = album;
    }

    /**
     * metodo para obtener la lista de canciones
     *
     * @return
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * metodo para almacenar la lista de canciones
     *
     * @param canciones
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * metodo para obtener la lista de usuarios
     *
     * @return
     */
    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * metodo para almacenar la lista de usuarios
     *
     * @param usuario
     */
    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    /**
     * metodo para obtener la lista de albumes
     *
     * @return
     */
    public ArrayList<Album> getAlbum() {
        return album;
    }

    /**
     * metodo para almacenar la lista de albumes
     *
     * @param album
     */
    public void setAlbum(ArrayList<Album> album) {
        this.album = album;
    }

}
