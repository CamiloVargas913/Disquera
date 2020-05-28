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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.service.CancionService;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author user
 */
@Named(value = "crearCancion")
@SessionScoped
public class CrearCancion implements Serializable {

    private int id;
    private String nombre;
    private double duracion;
    private String formato;
    private double precio;
    private String album;
    private List<Cancion> canciones;
    private Album albumes;

    @Inject
    CancionService cancionService;
    @Inject
    DbService dbService;

    public CrearCancion() {
        this.canciones = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.canciones = this.dbService.getCanciones();
    }

    public void agregarCancion() {
        this.canciones.add(new Cancion(getId(), getNombre(), getDuracion(), getFormato(), getPrecio(), getAlbum()));
        cancionService.setCanciones(this.canciones);
        this.dbService.setCanciones((ArrayList<Cancion>) canciones);
        this.dbService.llenar();
        FacesMessage message = new FacesMessage("¡Canción agregada correctamente! ");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Editó la cancion: ");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminarCancion(Cancion can) {
        this.canciones.remove(can);
        this.dbService.setCanciones((ArrayList<Cancion>) this.canciones);
        FacesMessage message = new FacesMessage("Canción eliminada con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public CancionService getCancionService() {
        return cancionService;
    }

    public void setCancionService(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return (int) (Math.floor(Math.random() * 2000 + 1) + Math.floor(Math.random() * 2000 + 1));
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Album albumes) {
        this.albumes = albumes;
    }

    public DbService getDbService() {
        return dbService;
    }

    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

}
