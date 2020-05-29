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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import udec.ucundi.edu.service.CancionService;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.service.DbService;

/**
 * Clase para el control de creacion de albumes
 *
 * @author David Márquez
 */
@Named(value = "crearAlbum")
@SessionScoped
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
    /**
     * Variable para almacenar las canciones agregadas al album
     */
    private ArrayList<Cancion> cancionesAgregadas;
    /**
     * Variable para guardar los albumes agregados
     */
    private ArrayList<Album> albumes;
    /**
     * Variable para obtener los valores de Album
     */
    private Album album;
    /**
     * Variable para almacenar el nombre del album
     */
    private String nombre;
    /**
     * Variable para almacenar el nombre del artista
     */
    private String artista;
    /**
     * Variable para almacenar el precio del album
     */
    private double precio;
    /**
     * Variable para almacenar el año de lanzamiento del album
     */
    private int añoLanzamiento;
    /**
     * Variable para obtener los datos de cancion
     */
    private Cancion albumCancion;

    /**
     * Constructor principal de la clase
     */
    public CrearAlbum() {
        this.cancionesAgregadas = new ArrayList<>();
        this.albumes = new ArrayList<>();
    }

    /**
     * Postconstruct de la clase
     */
    @PostConstruct
    public void init() {
        this.canciones = dbService.getCanciones();

    }

    /**
     * Metodo para agregar la cancion al album
     *
     * @param data obtiene los datos de la cancion a agregar
     */
    public void agregarCancion(Cancion data) {
        this.cancionesAgregadas.add(data);
        this.dbService.getCanciones().remove(data);

    }

    /**
     * Metodo para crear el album
     */
    public void crearAlbum() {
        for (Cancion cancione : cancionesAgregadas) {
            System.out.println(cancione.getNombre());
            this.precio += cancione.getPrecio();
        }
        this.precio = precio - (precio * 0.1);
        System.out.println(getId() + "-" + getNombre() + "-" + getArtista() + "-" + getPrecio() + "-" + getAñoLanzamiento());
        this.albumes.add(new Album(getId(), getNombre(), getArtista(), getPrecio(), getAñoLanzamiento(), this.cancionesAgregadas));
        this.dbService.setAlbum(this.albumes);
        this.dbService.llenar();

        this.cancionesAgregadas = null;
        this.cancionesAgregadas = new ArrayList<>();
        FacesMessage message = new FacesMessage("¡Álbum agregado correctamente! ");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /**
     * Metodo para obtener las canciones del album
     *
     * @return ArrayList de tipo Cancion
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer las canciones del album
     *
     * @param canciones Variable para guardar las canciones del album
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener el nombre del album
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer el nombre del album
     *
     * @param nombre almacena el nombre del album
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo para obtener el nombre del artista
     *
     * @return String
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Metodo para establecer el nombre del artista
     *
     * @param artista guarda el valor del nombre del artista
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * metodo para obtener el precio del album
     *
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * metodo para establecer el precio del album
     *
     * @param precio guarda el valor del precio del album
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo para obtener el año de lanzamiento del album
     *
     * @return int
     */
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    /**
     * metodo para establecer el año de lanzamiento del album
     *
     * @param añoLanzamiento guarda el año de lanzamiento del album
     */
    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    /**
     * metodo para obtener los albumes agregados
     *
     * @return List
     */
    public List<Album> getAlbumes() {
        return albumes;
    }

    /**
     * metodo para establecer los albumes a agregar
     *
     * @param albumes guarda los albumes agregados
     */
    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    /**
     * metodo para obtener el album
     *
     * @return Album
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * metodo para establecer el valor del album
     *
     * @param album guarda el valor del album
     */
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * Metodo para obtener las canciones agregadas al album
     *
     * @return List
     */
    public List<Cancion> getCancionesAgregadas() {
        return cancionesAgregadas;
    }

    /**
     * Metodo para establecer las canciones agregadas
     *
     * @param cancionesAgregadas guarda las canciones agregadas
     */
    public void setCancionesAgregadas(ArrayList<Cancion> cancionesAgregadas) {
        this.cancionesAgregadas = cancionesAgregadas;
    }

    /**
     * Metodo para obtener el valor del servicio de canciones
     *
     * @return CancionService
     */
    public CancionService getCancionService() {
        return cancionService;
    }

    /**
     * Metodo para establecer el valor del servicio de cancion
     *
     * @param cancionService
     */
    public void setCancionService(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    /**
     * Metodo para obtener los valores de cancion
     *
     * @return Cancion
     */
    public Cancion getAlbumCancion() {
        return albumCancion;
    }

    /**
     * Metodo para establecer el valor de la cancion
     *
     * @param albumCancion guarda los valores de la cancion
     */
    public void setAlbumCancion(Cancion albumCancion) {
        this.albumCancion = albumCancion;
    }

    /**
     * Metodo para establecer el id del album
     *
     * @return int
     */
    public int getId() {
        return (int) (Math.floor(Math.random() * 2000 + 1) + Math.floor(Math.random() * 2000 + 1));
    }

    /**
     * Metodo para establecer el valor del id
     *
     * @param id guarda el valor del id del album
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obtener los valores del servicio de DB
     *
     * @return dbService
     */
    public DbService getDbService() {
        return dbService;
    }

    /**
     * Metodo para establecer el valor del db service
     *
     * @param dbService guarda el valor del db service
     */
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

}
