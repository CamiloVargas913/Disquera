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
 * @author Camilo
 */
public class Carrito implements Serializable {

    /**
     * variable para almacenar el nombre del producto
     */
    private String nombre;
    /**
     * variable para almacenar precio del producto
     */
    private double Precio;
    /**
     * varibale que almacena el tipo de producto
     */
    private String tipo;
    /**
     * variable que almacena el id unico del producto
     */
    private int id;
    /**
     * variable que lamacena el album de tipo producto
     */
    private Album album;
    /**
     * variable que almacena la cancion de tipo cancion
     */
    private Cancion cancion;

    /**
     * metodo para obtener el nombre del producto
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo para almacenar el nombre del producto
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo para obtener el precio del producto
     *
     * @return
     */
    public double getPrecio() {
        return Precio;
    }

    /**
     * metodo para almacenar el precio del producto
     *
     * @param Precio
     */
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    /**
     * metodo para obtener el tipo de producto
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo para almacenar el tipo del producto
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * meodo para obtener el id del producto
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * metodo para almacenar el id del producto
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * metodo para obtener el albun del producto
     *
     * @return
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * metodo para almacenar el albun del producto
     *
     * @param album
     */
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * metodo para obtener la cancion del producto
     *
     * @return
     */
    public Cancion getCancion() {
        return cancion;
    }

    /**
     * metodo para almacenar la cancion del producto
     * @param cancion
     */
    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

}
