/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.service.CancionService;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.service.DbService;

/**
 * Clase para el control de creacion de albumes
 * @author David Márquez
 */
@Named(value = "crearAlbum")
@ApplicationScoped
public class CrearAlbum implements Serializable {
/**
 * Variable para controlar el servicio de DB
 */
    @Inject
    DbService dbService;
    /**
     * Variable para controlar el servicio de cancion
     */
    @Inject
    CancionService cancionService;
    
    /**
     * Variable para almacenar el id del album
     */
    private int id;
    /**
     * Variable para guardar las canciones agregadas 
     */
    private ArrayList<Cancion> canciones;
    private ArrayList<Cancion> cancionesAgregadas;
    private ArrayList<Album> albumes;
    private Album album;
    private String nombre;
    private String artista;
    private double precio;
    private int añoLanzamiento;
    private Cancion albumCancion;

    public CrearAlbum() {
        this.cancionesAgregadas = new ArrayList<>();
        this.albumes = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.dbService.leer();
        this.albumes = this.dbService.getAlbum();
    }

    public void agregarCancion(Cancion data) {
        this.cancionesAgregadas.add(data);
        this.dbService.getCanciones().remove(data);

    }

    public void crearAlbum() {
        for (Cancion cancione : cancionesAgregadas) {
            System.out.println(cancione.getNombre());
            this.precio += cancione.getPrecio();
        }
        this.precio = precio - (precio * 0.1);
        System.out.println(getId() + "-" + getNombre() + "-" + getArtista() + "-" + getPrecio() + "-" + getAñoLanzamiento());
        this.albumes.add(new Album(getId(), getNombre(), getArtista(), getPrecio(), getAñoLanzamiento(), this.cancionesAgregadas));
        this.dbService.setAlbum(this.albumes);
        for (Album cancione : this.dbService.getAlbum()) {
            System.out.println("entra for");
            System.out.println(cancione.getArtista());
        }
        this.dbService.llenar();

        this.cancionesAgregadas = null;
        this.cancionesAgregadas = new ArrayList<>();
        FacesMessage message = new FacesMessage("¡Álbum agregado correctamente! ");
        FacesContext.getCurrentInstance().addMessage(null, message);

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Cancion> getCancionesAgregadas() {
        return cancionesAgregadas;
    }

    public void setCancionesAgregadas(ArrayList<Cancion> cancionesAgregadas) {
        this.cancionesAgregadas = cancionesAgregadas;
    }

    public CancionService getCancionService() {
        return cancionService;
    }

    public void setCancionService(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    public Cancion getAlbumCancion() {
        return albumCancion;
    }

    public void setAlbumCancion(Cancion albumCancion) {
        this.albumCancion = albumCancion;
    }

    public int getId() {
        return (int) (Math.floor(Math.random() * 2000 + 1) + Math.floor(Math.random() * 2000 + 1));
    }

    public void setId(int id) {
        this.id = id;
    }

    public DbService getDbService() {
        return dbService;
    }

    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

}
