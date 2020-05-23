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
import udec.ucundi.edu.model.Albun;
import udec.ucundi.edu.model.Cancion;

/**
 *
 * @author PROFESIONAL
 */
@Named(value = "albunService")
@SessionScoped
public class AlbunService implements Serializable {

    private ArrayList<Albun> Albun;
    private ArrayList<Cancion> canciones;

    public AlbunService() {
        this.Albun = new ArrayList<>();
    }
    
    
    @PostConstruct
    public void init() {
        
        this.canciones = new ArrayList<>();
        this.canciones.add( new Cancion(1, "coco", 3.15, "corona", "camilo", "mp3", 2.300));
        this.canciones.add(new Cancion(2, "pepa", 4.15, "corona", "david", "mp2", 3.300));
        this.canciones.add( new Cancion(3, "arroz", 6.15, "corona", "juan", "mp4", 4.300));
        this.canciones.add( new Cancion(4, "pollo", 3.45, "corona", "flaco", "mp3", 5.300));
        this.canciones.add( new Cancion(5, "dada", 3.45, "daad", "camilo", "mp3", 5.300));
        this.Albun.add(new Albun(1,"primero","antonela",this.canciones));
        
        this.canciones = new ArrayList<>();
        this.canciones.add( new Cancion(1, "1", 3.15, "corona1", "camilo", "mp3", 2.300));
        this.canciones.add(new Cancion(2, "2", 4.15, "corona2", "david", "mp2", 3.300));
        this.canciones.add( new Cancion(3, "3", 6.15, "corona3", "juan", "mp4", 4.300));
        this.canciones.add( new Cancion(4, "4", 3.45, "corona4", "flaco", "mp3", 5.300));
        this.Albun.add(new Albun(2,"segundo","antonia",this.canciones));

    }

    public ArrayList<Albun> getAlbun() {
        return Albun;
    }

    public void setAlbun(ArrayList<Albun> Albun) {
        this.Albun = Albun;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }    
    
    
}
