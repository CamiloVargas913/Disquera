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
 *
 * @author PROFESIONAL
 */
@Named(value = "carritoService")
@SessionScoped
public class CarritoService implements Serializable {

    private ArrayList<Carrito> carrito;
    private Carrito carritoAux;
    private boolean bandera;

    public CarritoService() {

    }

    @PostConstruct
    public void Init() {
        this.carrito = new ArrayList<>();
        this.bandera = true;
    }

    public void Agregar(Carrito carr) {
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

                    }else{
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
        }

        System.out.println("----------------------------------------------------------");
        for (Carrito carrito1 : this.carrito) {
            System.out.println(carrito1.getTipo() + "" + carrito1.getId());
        }

    }

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
        System.out.println(validacion);
        return validacion;
    }

    public void Eliminar(Carrito carrito) {
        this.carrito.remove(carrito);
    }

    public ArrayList getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList carrito) {
        this.carrito = carrito;
    }

}
