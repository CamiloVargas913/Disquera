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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;

/**
 *
 * @author PROFESIONAL
 */
@Named(value = "albunService")
@SessionScoped
public class AlbunService implements Serializable {

    private ArrayList<Album> Albun;
    private ArrayList<Cancion> canciones;

    public AlbunService() {
        this.Albun = new ArrayList<>();
    }

    @PostConstruct
    public void init() {

        this.canciones = new ArrayList<>();
        this.canciones.add(new Cancion(1, "coco", 3.15, "camilo", "mp3", 2.300));
        this.canciones.add(new Cancion(2, "pepa", 4.15, "david", "mp2", 3.300));
        this.canciones.add(new Cancion(3, "arroz", 6.15, "juan", "mp4", 4.300));
        this.canciones.add(new Cancion(4, "pollo", 3.45, "flaco", "mp3", 5.300));
        this.canciones.add(new Cancion(5, "dada", 3.45, "camilo", "mp3", 5.300));
        this.Albun.add(new Album(1, "primero", "antonela", this.canciones));

        this.canciones = new ArrayList<>();
        this.canciones.add(new Cancion(1, "1", 3.15, "camilo", "mp3", 2.300));
        this.canciones.add(new Cancion(2, "2", 4.15, "david", "mp2", 3.300));
        this.canciones.add(new Cancion(3, "3", 6.15, "juan", "mp4", 4.300));
        this.canciones.add(new Cancion(4, "4", 3.45, "flaco", "mp3", 5.300));
        this.Albun.add(new Album(2, "segundo", "antonia", this.canciones));

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

}
