/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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

    /**
     * variable ´para almacenar la lista de los albumes
     */
    private ArrayList<Album> albunes;
    /**
     * variable para almacenar el album selleccionado
     */
    private Album albun;
    /**
     * variable para almacenar los productos agregados al carrito
     */
    private Carrito carrito;
    /**
     * variable que es inyectada del Dbservice para leer los datos del archivo
     */
    @Inject
    private DbService serviceDb;
    /**
     * variable que es inyectada del CarritoService para guardar los productos
     * agregados
     */
    @Inject
    private CarritoService serviceCarrito;

    /**
     * Constructor principal
     */
    public Index() {
        this.albunes = new ArrayList<>();
    }

    /**
     * Constructor de la clase
     */
    @PostConstruct
    public void init() {
        this.serviceDb.leer();
        this.albunes = serviceDb.getAlbum();
    }

    /**
     * Metodo para agregar el album al carrito de compras
     *
     * @param album almacena el albun seleccionado
     */
    public void AgregarAlbum(Album album) {
        this.carrito = new Carrito();
        this.carrito.setNombre("Album: " + album.getNombre());
        this.carrito.setPrecio(album.getPrecio());
        this.carrito.setTipo("album");
        this.carrito.setId(album.getId());
        this.carrito.setAlbum(album);
        this.serviceCarrito.Agregar(this.carrito);

        if (this.serviceCarrito.Agregar(this.carrito)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Agregado Correctamente", "Album: " + album.getNombre()));
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se puede agregar Album: " + album.getNombre());
            FacesContext.getCurrentInstance().addMessage(null, message);

        }
    }

    /**
     * Metodo para agregar la cancion al carrito de compras
     *
     * @param cancion almacena la cancion seleccionada
     */
    public void AgregarCancion(Cancion cancion) {
        this.carrito = new Carrito();
        this.carrito.setNombre("Cancion: " + cancion.getNombre());
        this.carrito.setPrecio(cancion.getPrecio());
        this.carrito.setTipo("cancion");
        this.carrito.setId(cancion.getId());
        this.carrito.setCancion(cancion);
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.serviceCarrito.Agregar(this.carrito)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se puede agregar Cancion: " + cancion.getNombre());
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            context.addMessage(null, new FacesMessage("Agregado Correctamente", "Cancion: " + cancion.getNombre()));
        }
    }

    /**
     * Elimina un producto agregado del carrito
     *
     * @param carrito almacena el producto a eliminar
     */
    public void EliminarAgregados(Carrito carrito) {
        this.serviceCarrito.Eliminar(carrito);
    }

    /**
     * metodo para obtener el valor de carrito
     *
     * @return
     */
    public CarritoService getServiceCarrito() {
        return serviceCarrito;
    }

    /**
     * metodo para almacenar el producto al carrito seleccionado
     *
     * @param serviceCarrito
     */
    public void setServiceCarrito(CarritoService serviceCarrito) {
        this.serviceCarrito = serviceCarrito;
    }

    /**
     * *
     * metodo para obtener los albumes
     *
     * @return
     */
    public ArrayList<Album> getAlbunes() {
        return albunes;
    }

    /**
     * metodo para almacenar los albumes
     *
     * @param albunes
     */
    public void setAlbunes(ArrayList<Album> albunes) {
        this.albunes = albunes;
    }

    /**
     * metodo para obtener el album
     *
     * @return
     */
    public Album getAlbun() {
        return albun;
    }

    /**
     * metodo para almacenar un album
     *
     * @param albun
     */
    public void setAlbun(Album albun) {
        this.albun = albun;
    }

}
