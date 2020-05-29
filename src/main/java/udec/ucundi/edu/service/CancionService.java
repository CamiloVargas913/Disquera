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
 * Clase para controlar las canciones del album
 *
 * @author David Márquez
 */
@Named(value = "cancionService")
@SessionScoped
public class CancionService implements Serializable {

    /**
     * Variable para almacenar las canciones del album
     */
    private List<Cancion> canciones;

    /**
     * Constructor principal de la clase
     */
    public CancionService() {
        this.canciones = new ArrayList<>();
    }

    /**
     * PostConstruct de la clase
     */
    @PostConstruct
    public void init() {

    }

    /**
     * Metodo para obtener las canciones
     *
     * @return List
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer el valor de las canciones
     *
     * @param canciones Variable para almacenar las canciones del album
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

}
