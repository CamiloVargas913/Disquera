/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.model.Carrito;

/**
 * Clase para el control de carrito
 *
 * @author Camilo Vargas
 */
@Named(value = "carritoService")
@SessionScoped
public class CarritoService implements Serializable {

    /**
     * Variable para almacenar los datos de compra
     */
    private ArrayList<Carrito> carrito;
    /**
     * Variable para controlar los datos de carro
     */
    private Carrito carritoAux;
    /**
     * Variable para controlar el estado del carro de compra
     */
    private boolean bandera;

    /**
     * Constructor principal de la clase
     */
    public CarritoService() {

    }

    /**
     * Postconstruct de la clase
     */
    @PostConstruct
    public void Init() {
        this.carrito = new ArrayList<>();
        this.bandera = true;
    }

    /**
     * Metodo para agregar los datos al carro de compra
     *
     * @param carr Almacena el valor de los datos agregados al carro de compra
     * @return boolean
     */
    public boolean Agregar(Carrito carr) {
        if (this.carrito.size() > 0) {
            for (Carrito carrito1 : carrito) {
                if (carrito1.getTipo().equals(carr.getTipo()) && carrito1.getId() == carr.getId()) {
                    this.bandera = true;
                    break;
                } else {
                    if (carrito1.getTipo().equals("album") && carr.getTipo().equals("cancion")) {

                        if (validar(carrito1.getAlbum(), carr)) {
                            System.out.println(validar(carrito1.getAlbum(), carr));
                            this.bandera = true;
                            break;
                        } else {
                            this.bandera = false;
                        }
                    } else if (carrito1.getTipo().equals("cancion") && carr.getTipo().equals("album")) {

                        if (validar(carr.getAlbum(), carrito1)) {
                            System.out.println(carr.getAlbum() + "-" + carrito1);
                            this.bandera = false;
                            this.carritoAux = carrito1;
                            break;
                        } else {
                            this.bandera = true;
                        }

                    } else {
                        this.bandera = false;
                    }
                }
            }
            if (!bandera) {
                this.carrito.remove(carritoAux);
                this.carrito.add(carr);

            }
        } else {
            this.carrito.add(carr);
            this.bandera = false;
        }
        return this.bandera;
    }

    /**
     * Metodo para validar los datos agregados al carro de compra
     *
     * @param album almacena los datos de los albumes
     * @param carr almacena los datos del carro de compra
     * @return boolean
     */
    public boolean validar(Album album, Carrito carr) {
        boolean validacion = false;
        System.out.println("*************************************************************");
        for (Cancion cancione : album.getCanciones()) {
            if (cancione.getId() == carr.getId()) {
                System.out.println("cancion encontrada");
                validacion = true;
                break;
            } else {
                System.out.println("no encontrada");
                validacion = false;
            }
        }
        return validacion;
    }

    /**
     * Metodo para eliminar los datos del carro de compra
     *
     * @param carrito almacena los datos del carro de compra para eliminar
     */
    public void Eliminar(Carrito carrito) {
        this.carrito.remove(carrito);
    }

    /**
     * Metodo para obtener los datos del carro de compra
     *
     * @return ArrayList
     */
    public ArrayList getCarrito() {
        return carrito;
    }

    /**
     * Metodo para establecer los datos del carro de compra
     *
     * @param carrito almacena los datos del carro de compra
     */
    public void setCarrito(ArrayList carrito) {
        this.carrito = carrito;
    }

}
