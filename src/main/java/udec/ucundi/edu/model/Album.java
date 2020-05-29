/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PROFESIONAL
 */
public class Album implements Serializable {

    /**
     * Variable para almacenar el id del album
     */
    private int id;
    /**
     * Variable para almacenar el nombre del album
     */
    private String nombre;
    /**
     * Variable para almacenar el nombre del artista
     */
    private String artista;
    /**
     * Variable para almacenar el precio del album
     */
    private double precio;
    /**
     * Variable para almacenar el año de lanzamiento del album
     */
    private int añoLanzamiento;
    /**
     * Variable para almacenar las canciones agregadas al album
     */
    private ArrayList<Cancion> canciones;

    /**
     * Constructor principal de la clase
     *
     * @param id Variable para almacenar el id del album
     * @param nombre Variable para almacenar el nombre del album
     * @param artista Variable para almacenar el nombre del artista
     * @param precio Variable para almacenar el precio del album
     * @param añoLanzamiento Variable para almacenar el año de lanzamiento del
     * album
     * @param canciones Variable para almacenar las canciones agregadas al album
     */
    public Album(int id, String nombre, String artista, double precio, int añoLanzamiento, ArrayList<Cancion> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.precio = precio;
        this.añoLanzamiento = añoLanzamiento;
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener el id del album
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para establecer el valor del id
     *
     * @param id guarda el valor del id del album
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obtener las canciones agregadas al album
     *
     * @return ArrayList
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer las canciones agregadas
     *
     * @param canciones guarda las canciones agregadas
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener el nombre del album
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer el nombre del album
     *
     * @param nombre almacena el nombre del album
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo para obtener el nombre del artista
     *
     * @return String
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Metodo para establecer el nombre del artista
     *
     * @param artista guarda el valor del nombre del artista
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * metodo para obtener el precio del album
     *
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * metodo para establecer el precio del album
     *
     * @param precio guarda el valor del precio del album
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo para obtener el año de lanzamiento del album
     *
     * @return int
     */
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    /**
     * metodo para establecer el año de lanzamiento del album
     *
     * @param añoLanzamiento guarda el año de lanzamiento del album
     */
    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

}
