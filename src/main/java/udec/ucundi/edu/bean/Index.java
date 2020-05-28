/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.model.Carrito;
import udec.ucundi.edu.service.CarritoService;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author PROFESIONAL
 */
@Named(value = "index")
@SessionScoped
public class Index implements Serializable {

    private ArrayList<Album> albunes;
    private Album albun;
    private Carrito carrito;

    @Inject
    private DbService serviceDb;
    @Inject
    private CarritoService serviceCarrito;

    public Index() {

    }

    @PostConstruct
    public void init() {
        this.serviceDb.leer();
        this.albunes = serviceDb.getAlbum();

    }

    public void actualizar(RowEditEvent event) {
        Cancion can = (Cancion) event.getObject();
    }

    public void AgregarAlbum(Album album) {
        this.carrito = new Carrito();
        this.carrito.setNombre("Album: " + album.getNombre());
        this.carrito.setPrecio(album.getPrecio());
        this.carrito.setTipo("album");
        this.carrito.setId(album.getId());
        this.carrito.setAlbum(album);
        this.serviceCarrito.Agregar(this.carrito);

        FacesContext context = FacesContext.getCurrentInstance();
        if (this.serviceCarrito.Agregar(this.carrito)) {
            context.addMessage(null, new FacesMessage("No se puede agregar", "Album: " + album.getNombre()));
        } else {
            context.addMessage(null, new FacesMessage("Agregado Correctamente", "Album: " + album.getNombre()));
        }
    }

    public void AgregarCancion(Cancion cancion) {
        this.carrito = new Carrito();
        this.carrito.setNombre("Cancion: " + cancion.getNombre());
        this.carrito.setPrecio(cancion.getPrecio());
        this.carrito.setTipo("cancion");
        this.carrito.setId(cancion.getId());
        this.carrito.setCancion(cancion);
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.serviceCarrito.Agregar(this.carrito)) {
            context.addMessage(null, new FacesMessage("No se puede agregar", "Cancion: " + cancion.getNombre()));
        } else {
            context.addMessage(null, new FacesMessage("Agregado Correctamente", "Cancion: " + cancion.getNombre()));
        }
    }

    public void EliminarAgregados(Carrito carrito) {
        this.serviceCarrito.Eliminar(carrito);
    }

    public CarritoService getServiceCarrito() {
        return serviceCarrito;
    }

    public void setServiceCarrito(CarritoService serviceCarrito) {
        this.serviceCarrito = serviceCarrito;
    }

    public ArrayList<Album> getAlbunes() {
        return albunes;
    }

    public void setAlbunes(ArrayList<Album> albunes) {
        this.albunes = albunes;
    }

    public Album getAlbun() {
        return albun;
    }

    public void setAlbun(Album albun) {
        this.albun = albun;
    }

}
