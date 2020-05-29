/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ASUS-PC
 */
@Named(value = "errorHandler")
@RequestScoped
public class ErrorHandler {

    /**
     * contructor principañ
     */
    public ErrorHandler() {
    }
    /**
     * obtiene el estado de la peticion y el error
     * @return 
     */
    public String getStatusCode() {
        String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.status_code"));
        return val;
    }    
    /**
     * obtiene el mensaje del servidor 
     * @return 
     */
    public String getMessage() {
        String val = (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.message");
        return val;
    }    
    /**
     * obtiene la url a la que se le hacer la peticion
     * @return 
     */
    public String getRequestURI() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.request_uri");
    }    
    /**
     * obtiene el noobre de la peticion
     * @return 
     */
    public String getServletName() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.servlet_name");
    }    
    
}
