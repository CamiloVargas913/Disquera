/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import udec.ucundi.edu.model.Usuario;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author PROFESIONAL
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable {

    /**
     * variable para almacenar el usuario ingresado
     */
    private Usuario usuario;
    /**
     * variable inyectada para extraer los usuario del archivo
     */
    @Inject
    private DbService serviceDb;

    /**
     * constructor principal
     */
    public Login() {

    }

    /**
     * contructor de la clase
     */
    @PostConstruct
    public void Init() {
        this.usuario = new Usuario();
        this.serviceDb.leer();
    }

    /**
     * metodo que valida el usuario es correcto su atenticacion
     */
    public void ingresar() {
        this.serviceDb.getUsuario();
        this.serviceDb.getUsuario().forEach((user) -> {
            if (user.getNick().equals(this.usuario.getNick()) && user.getClave().equals(this.usuario.getClave())) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
                FacesMessage message = new FacesMessage("Bienvenido: " + user.getNombre());
                FacesContext.getCurrentInstance().addMessage(null, message);
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/admin.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales incorrectas");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        });
    }

    /**
     * metodo para obtener el usuario
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * metodo para almacenar un usuario
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
