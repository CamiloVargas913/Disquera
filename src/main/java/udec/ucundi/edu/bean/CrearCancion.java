/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.service.CancionService;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.service.DbService;

/**
 * Clase para controlar el creado de canciones
 *
 * @author David Márquez
 */
@Named(value = "crearCancion")
@SessionScoped
public class CrearCancion implements Serializable {

    /**
     * variable para guardar el id de la cancion
     */
    private int id;
    /**
     * variable para guardar el nombre de la cancion
     */
    private String nombre;
    /**
     * variable para guardar la duracion de la cancion
     */
    private double duracion;
    /**
     * variable para guardar el formato de la cancion
     */
    private String formato;
    /**
     * Variable para guardar el precio de la cancion
     */
    private double precio;
    /**
     * Variable para guardar el album de la cancion
     */
    private String album;
    /**
     * Variable para guardar la lista de canciones
     */
    private List<Cancion> canciones;
    /**
     * Variable para guardar los datos de album
     */
    private Album albumes;

    /**
     * Se injecta el cancion service
     */
    @Inject
    CancionService cancionService;
    /**
     * Se injecta el db service
     */
    @Inject
    DbService dbService;

    /**
     * constructor principal de la clase
     */
    public CrearCancion() {
        this.canciones = new ArrayList<>();
    }

    /**
     * PostConstruct de la clase
     */
    @PostConstruct
    public void init() {
        this.canciones = this.dbService.getCanciones();
    }

    /**
     * Metodo para agregar las canciones
     */
    public void agregarCancion() {
        this.canciones.add(new Cancion(getId(), getNombre(), getDuracion(), getFormato(), getPrecio(), getAlbum()));
        cancionService.setCanciones(this.canciones);
        this.dbService.setCanciones((ArrayList<Cancion>) canciones);
        this.dbService.llenar();
        FacesMessage message = new FacesMessage("¡Canción agregada correctamente! ");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /**
     * Metodo para editar las canciones
     *
     * @param event evento de escucha al dar clic
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Editó la cancion: ");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para cancelar la edicion de la cancion
     *
     * @param event evento de escucha al dar clic
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para eliminar la cancion
     *
     * @param can variable para identificar la cancion a eliminar
     */
    public void eliminarCancion(Cancion can) {
        this.canciones.remove(can);
        this.dbService.setCanciones((ArrayList<Cancion>) this.canciones);
        FacesMessage message = new FacesMessage("Canción eliminada con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para obtener el nombre de la cancion
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer el nombre de la cancion
     *
     * @param nombre guarda el nombre de la cancion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la duracion de la cancion
     *
     * @return double
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Metodo para establecer la duracion de la cancion
     *
     * @param duracion almacena la duracion de la cancion
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo para establecer el formato de la cancion
     *
     * @return String
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Metodo para establecer el formato de la cancion
     *
     * @param formato guarda el formato de la cancion
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Metodo para obtener el precio de la cancion
     *
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo para establecer el precio de la cancion
     *
     * @param precio almacena el precio de la cancion
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo para obtener las canciones agregadas
     *
     * @return List
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer la cancion
     *
     * @param canciones guarda la cancion a agregar
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener los valores del servicio de la cancion
     *
     * @return CancionService
     */
    public CancionService getCancionService() {
        return cancionService;
    }

    /**
     * Metodo para establecer los valores del cancionservice
     *
     * @param cancionService guarda los valores del cancion service
     */
    public void setCancionService(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    /**
     * Metodo para establecer el album de la cancion
     *
     * @return String
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Metodo para establecer el nombre del album
     *
     * @param album almacena el nombre del album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Metodo para obtener el id de la cancion
     *
     * @return int
     */
    public int getId() {
        return (int) (Math.floor(Math.random() * 2000 + 1) + Math.floor(Math.random() * 2000 + 1));
    }

    /**
     * Metodo para establecer el valor del id de la cancion
     *
     * @param id almacena el valor del id de la cancion
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo apra obtener los albumes
     *
     * @return Album
     */
    public Album getAlbumes() {
        return albumes;
    }

    /**
     * Metodo para establecer los albumes
     *
     * @param albumes guarda el valor de los albumes
     */
    public void setAlbumes(Album albumes) {
        this.albumes = albumes;
    }

    /**
     * Metodo para obtener el valor del db service
     *
     * @return DbService
     */
    public DbService getDbService() {
        return dbService;
    }

    /**
     * Metodo para establecer el valor del db service
     *
     * @param dbService almacena el valor del db service
     */
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

}
