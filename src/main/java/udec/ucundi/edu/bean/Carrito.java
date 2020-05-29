/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.service.CarritoService;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author Camilo
 */
@Named(value = "carrito")
@RequestScoped
public class Carrito {

    /**
     * variable que almacenael objeto de carrito
     */

    @Inject
    private CarritoService serviceCarrito;

    /**
     * constructor principal
     */
    public Carrito() {
    }
    /**
     * PostConstruct de la clase 
     */
    @PostConstruct
    public void init() {

    }

    /**
     * METODO QUE CONFIRMA LA COMPRA
     */
    public void confirmarCompra() {
        this.serviceCarrito.getCarrito().clear();
        FacesMessage message = new FacesMessage("Compra Confirmada");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
