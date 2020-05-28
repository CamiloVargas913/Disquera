/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udec.ucundi.edu.model.Cancion;

/**
 *
 * @author user
 */
@Named(value = "cancionService")
@SessionScoped
public class CancionService implements Serializable {

    private List<Cancion> canciones;

    public CancionService() {
        this.canciones = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

}
