/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.service;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.model.Usuario;

/**
 * Clase para controlar los albumes
 * @author David Márquez
 */
@Named(value = "albunService")
@SessionScoped
public class AlbunService implements Serializable {

    /**
     * Variable para almacenar los albumes
     */
    private ArrayList<Album> Albun;
    /**
     * Variable para almacenar las canciones del album
     */
    private ArrayList<Cancion> canciones;
    /**
     * Variable para almacenar los usuarios de la plataforma
     */
    private ArrayList<Usuario> usuario;
    /**
     * Variable para almacenar la instancia de usuario
     */
    private Usuario user;
    /**
     * Variable para almacenar la instancia de album
     */
    private Album Album;

    /**
     * Constructor principal de la clase
     */
    public AlbunService() {
        this.Albun = new ArrayList<>();
    }

    /**
     * PostConstruct de la clase
     */
    @PostConstruct
    public void init() {

//        this.canciones = new ArrayList<>();
//        this.canciones.add(new Cancion(1, "coco", 3.15, "camilo", "mp3", 2.300));
//        this.canciones.add(new Cancion(2, "pepa", 4.15, "camilo", "mp2", 3.300));
//        this.canciones.add(new Cancion(3, "arroz", 6.15, "camilo", "mp4", 4.300));
//        this.canciones.add(new Cancion(4, "pollo", 3.45, "camilo", "mp3", 5.300));
//        this.canciones.add(new Cancion(5, "dada", 3.45, "camilo", "mp3", 5.300));
//        this.Albun.add(new Album(1, "primero", "antonela", 10.300, this.canciones));
//
//        this.canciones = new ArrayList<>();
//        this.canciones.add(new Cancion(6, "hola1", 3.15, "david", "mp3", 2.300));
//        this.canciones.add(new Cancion(7, "hola2", 4.15, "david", "mp2", 3.300));
//        this.canciones.add(new Cancion(8, "hola3", 6.15, "david", "mp4", 4.300));
//        this.canciones.add(new Cancion(9, "hola4", 3.45, "david", "mp3", 5.300));
//        this.Albun.add(new Album(2, "segundo", "antonia", 10.300, this.canciones));
        this.usuario = new ArrayList<>();
        this.user = new Usuario();
        this.user.setNick("juan");
        this.user.setClave("camilo123");
        this.usuario.add(this.user);

    }

    /**
     * Metodo para establecer el album
     * @return Album
     */
    public ArrayList<Album> getAlbun() {
        return Albun;
    }

    /**
     * Metodo para establecer el valor del albumn
     * @param Albun almacena los datos de album
     */
    public void setAlbun(ArrayList<Album> Albun) {
        this.Albun = Albun;
    }

    /**
     * Variable para obtener las canciones del album
     * @return ArrayList
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer el valor de las canciones del album
     * @param canciones almacena el valor de las canciones
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener los usuarios de la plataforma
     * @return ArrayList
     */
    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * Variable para establecer los usuarios de la plataforma
     * @param usuario almacena los datos del usuario
     */
    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

}
