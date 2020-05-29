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
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camilo
 */
@Named(value = "masterAdmin")
@RequestScoped
public class masterAdmin {

    /**
     * metodo principal
     */
    public masterAdmin() {

    }

    /**
     * metodo de la clase
     */
    @PostConstruct
    public void init() {

    }

    /**
     * metodo que cierra la sesion de un usuario
     */
    public void cerrarSesion() {
        System.out.println("HOLA");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
