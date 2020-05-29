/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.model;

import java.io.Serializable;

/**
 *
 * @author Camilo
 */
public class Cancion implements Serializable {

    /**
     * variable para guardar el id de la cancion
     */
    private int id;
    /**
     * variable para guardar el nombre de la cancion
     */
    private String nombre;
    /**
     * variable para guardar la duracion de la cancion
     */
    private double duracion;
    /**
     * variable para guardar el formato de la cancion
     */
    private String formato;
    /**
     * Variable para guardar el precio de la cancion
     */
    private double precio;
    /**
     * Variable para guardar el album de la cancion
     */
    private String album;

    /**
     *
     * @param id variable para guardar el id de la cancion
     * @param nombre variable para guardar el nombre de la cancion
     * @param duracion variable para guardar la duracion de la cancion
     * @param formato variable para guardar el formato de la cancion
     * @param precio Variable para guardar el precio de la cancion
     * @param album Variable para guardar el album de la cancion
     */
    public Cancion(int id, String nombre, double duracion, String formato, double precio, String album) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.formato = formato;
        this.precio = precio;
        this.album = album;
    }

    /**
     * Metodo para obtener el id de la cancion
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para establecer el valor del id de la cancion
     *
     * @param id almacena el valor del id de la cancion
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el nombre de la cancion
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer el nombre de la cancion
     *
     * @param nombre guarda el nombre de la cancion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la duracion de la cancion
     *
     * @return double
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Metodo para establecer la duracion de la cancion
     *
     * @param duracion almacena la duracion de la cancion
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo para establecer el album de la cancion
     *
     * @return String
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Metodo para establecer el nombre del album
     *
     * @param album almacena el nombre del album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Metodo para establecer el formato de la cancion
     *
     * @return String
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Metodo para establecer el formato de la cancion
     *
     * @param formato guarda el formato de la cancion
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Metodo para obtener el precio de la cancion
     *
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo para establecer el precio de la cancion
     *
     * @param precio almacena el precio de la cancion
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
