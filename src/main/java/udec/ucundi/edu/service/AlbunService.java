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
 *
 * @author PROFESIONAL
 */
@Named(value = "albunService")
@SessionScoped
public class AlbunService implements Serializable {

    private ArrayList<Album> Albun;
    private ArrayList<Cancion> canciones;
    private ArrayList<Usuario> usuario;
    private Usuario user;
    private Album Album;

    public AlbunService() {
        this.Albun = new ArrayList<>();
    }

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

    public ArrayList<Album> getAlbun() {
        return Albun;
    }

    public void setAlbun(ArrayList<Album> Albun) {
        this.Albun = Albun;
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

}
