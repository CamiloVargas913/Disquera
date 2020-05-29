/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.model;

import java.io.Serializable;

/**
 * Clase para controlar todo lo relacionado al usuario
 *
 * @author Camilo vargas
 */
public class Usuario implements Serializable {

    /**
     * Variable para almacenar el nombre del usuario
     */
    private String nombre;
    /**
     * Variable para almacenar el apellido del usuario
     */
    private String apellido;
    /**
     * Variable para almacenar el nick del usuario
     */
    private String nick;
    /**
     * Variable para almacenar la clave del usuario
     */
    private String clave;

    /**
     * Metodo para obtener el nombre del usuario
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer el nombre del usuario
     *
     * @param nombre Variable para almacenar el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el apellido del usuario
     *
     * @return String
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Metodo para establecer el apellido del usuario
     *
     * @param apellido Variable para almacenar el apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Metodo para obtener el nick del usuario
     *
     * @return String
     */
    public String getNick() {
        return nick;
    }

    /**
     * Metodo para establecer el nick del usuario
     *
     * @param nick Variable para almacenar el nick del usuario
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Metodo para obtener la clave del usuario
     *
     * @return String
     */
    public String getClave() {
        return clave;
    }

    /**
     * Metodo para establecer la clave del usuario
     *
     * @param clave Variable para almacenar la clave del usuario
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

}
