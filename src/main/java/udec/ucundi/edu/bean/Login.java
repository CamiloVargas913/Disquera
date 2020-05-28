/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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

    private Usuario usuario;
    @Inject
    private DbService serviceDb;
    
    public Login() {
        
    }
    
    @PostConstruct
    public void Init(){
        this.usuario= new Usuario();  
        this.serviceDb.leer();
    }
    
    public void ingresar(){
        this.serviceDb.getUsuario();
        this.serviceDb.getUsuario().forEach((user) -> {
            if (user.getNick().equals(this.usuario.getNick()) && user.getClave().equals(this.usuario.getClave())) {
                System.out.println("usuario correcto");
            }else{
                System.out.println("usuario incorrecto");
            }
        });
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
