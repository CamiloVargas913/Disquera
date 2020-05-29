/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.model.Album;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.service.DbService;

/**
 * Clase para controlar el inicio del administrador
 *
 * @author David Márquez
 */
@Named(value = "admin")
@RequestScoped
public class Admin implements Serializable {

    /**
     * Variable para controlar el servicio de la BD
     */
    @Inject
    DbService dbService;
    /**
     * Lista para almacenar los albumes
     */
    private List<Album> albumes;
    /**
     * Instancia del modelo album para poder acceder a sus metodos
     */
    private Album album;

    /**
     * Constructor principal de la clase
     */
    public Admin() {
//        System.out.println("entra postconstruct");
    }

    /**
     * PostConstruct de la clase
     */
    @PostConstruct
    public void init() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (us == null) {
            redireccionarNoAutorizado();
        } else {
            dbService.leer();
            this.albumes = dbService.getAlbum();
        }

//        for (Album albume : dbService.getAlbum()) {
//            System.out.println("artista:"+albume.getArtista());
//        }
    }

    public void redireccionarNoAutorizado() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("401.xhtml");
        } catch (IOException ex) {
            //Logger.getLogger(CrearArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para editar los datos de los albumes
     *
     * @param event evento de escucha al dar clic
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Editó el album: ");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para cancelar la edicion de los albumes
     *
     * @param event evento de escucha al dar clic
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para eliminar un album de la lista
     *
     * @param alb parametro de tipo album para identificar lo que se debe
     * eliminar
     */
    public void eliminarAlbum(Album alb) {
        this.albumes.remove(alb);
        this.dbService.setAlbum((ArrayList<Album>) this.albumes);
        this.dbService.llenar();
        FacesMessage message = new FacesMessage("Album eliminado con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /*public void redireccionCrearAlbum() throws IOException {
     FacesContext.getCurrentInstance().getExternalContext().redirect("faces/crearAlbum.xhtml");
     }

     public void redireccionCrearCancion() throws IOException {
     FacesContext.getCurrentInstance().getExternalContext().redirect("faces/crearCancion.xhtml");
     }

     public void redireccionInicioAdmin() throws IOException {
     FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
     }*/
    /**
     * Metodo para obtener los albumes guardados
     *
     * @return List
     */
    public List<Album> getAlbumes() {
        return albumes;
    }

    /**
     * Metodo para establecer el valor de los albumes
     *
     * @param albumes variable para guardar los albumes agregados
     */
    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }

    /**
     * Metodo para obtener el valor de la instancia del album
     *
     * @return variable para el control del album
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * Metodo para establecer el valor de la instancia del album
     *
     * @param album variable para guardar el valor de la instancia de album
     */
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * Metodo para obtener los valos del servicio de DB
     *
     * @return objeto para obtener los valores de DB
     */
    public DbService getDbService() {
        return dbService;
    }

    /**
     * Metodo para establecer el valor del servicio de db
     *
     * @param dbService objeto de db
     */
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

}
