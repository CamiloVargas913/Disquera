/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.model.Db;
import udec.ucundi.edu.model.Usuario;

/**
 * Clase para controlar los datos del archivo de almacenamiento
 *
 * @author Camilo Vargas
 */
@Named(value = "dbService")
@ApplicationScoped
public class DbService implements Serializable {

    /**
     * Variable para almacenar la instancia de Db
     */
    private Db ListaDb;
    /**
     * Variable para almacenar las canciones
     */
    private ArrayList<Cancion> canciones;
    /**
     * Variable para almacenar los usuarios
     */
    private ArrayList<Usuario> usuario;
    /**
     * Variable para almacenar los albumes
     */
    private ArrayList<Album> album;

    /**
     * Variable para obtener los datos del bean AlbunService
     */
    @Inject
    private AlbunService service;

    /**
     * Contructor principal de la clase
     */
    public DbService() {

    }

    /**
     * PostConstruct de la clase
     */
    @PostConstruct
    public void init() {
//        for (Album album1 : this.ListaDb.getAlbum()) {
//            System.out.println(album1.getArtista());
//        }
    }

    /**
     * Metodo para llenar el archivo
     */
    public void llenar() {
        this.ListaDb = new Db(this.canciones, service.getUsuario(), this.album);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("C:\\Users\\user\\Documents\\VII semestre\\Linea de profundizacion I\\Disquera\\data.txt");
            ObjectOutputStream db = new ObjectOutputStream(fos);
            db.writeObject(this.ListaDb);
            db.flush();
            db.close();
        } catch (IOException ex) {
            Logger.getLogger(DbService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para leer el archivo
     */
    public void leer() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("C:\\Users\\user\\Documents\\VII semestre\\Linea de profundizacion I\\Disquera\\data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.ListaDb = (Db) ois.readObject();
            this.album = this.ListaDb.getAlbum();
            this.canciones = this.ListaDb.getCanciones();
            this.usuario = this.ListaDb.getUsuario();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DbService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para obtener las canciones
     *
     * @return ArrayList
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo para establecer el valor de las canciones
     *
     * @param canciones Variable para almacenar las canciones
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * Metodo para obtener los usuarios
     *
     * @return ArrayList
     */
    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * Metodo para establecer el valor de los usuarios
     *
     * @param usuario Variable para almacenar los usuarios
     */
    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo para obtener los albumes
     *
     * @return ArrayList
     */
    public ArrayList<Album> getAlbum() {
        return album;
    }

    /**
     * Metodo para establecer el valor de los albumes
     *
     * @param album Variable para almacenar los albumes
     */
    public void setAlbum(ArrayList<Album> album) {
        this.album = album;
    }

}
