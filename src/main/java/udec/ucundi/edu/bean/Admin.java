/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.model.Album;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author user
 */
@Named(value = "admin")
@SessionScoped
public class Admin implements Serializable {

    @Inject
    DbService dbService;

    private List<Album> albumes;
    private Album album;

    public Admin() {

    }

    @PostConstruct
    public void init() {
        dbService.leer();
        this.albumes = dbService.getAlbum();
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Editó el album: ");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage message = new FacesMessage("Canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void redireccionCrearAlbum() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/crearAlbum.xhtml");
    }
    
    public void seleccionar(){
        System.out.println("hola");
    }

    public void redireccionCrearCancion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/crearCancion.xhtml");
    }

    public void redireccionInicioAdmin() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
