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
 *
 * @author PROFESIONAL
 */
@Named(value = "dbService")
@ApplicationScoped
public class DbService implements Serializable {

    private Db ListaDb;
    private ArrayList<Cancion> canciones;
    private ArrayList<Usuario> usuario;
    private ArrayList<Album> album;

    @Inject
    private AlbunService service;

    public DbService() {

    }

    @PostConstruct
    public void init() {
//        for (Album album1 : this.ListaDb.getAlbum()) {
//            System.out.println(album1.getArtista());
//        }
    }

    public void llenar() {
        this.ListaDb = new Db(service.getCanciones(), usuario, service.getAlbun()); 
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("bd.txt");
            ObjectOutputStream db = new ObjectOutputStream(fos);
            db.writeObject(this.ListaDb);
            db.flush();
            db.close();
        } catch (IOException ex) {
            Logger.getLogger(DbService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leer() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("bd.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.ListaDb = (Db) ois.readObject();
            this.album = this.ListaDb.getAlbum();
            this.canciones = this.ListaDb.getCanciones();
            this.usuario = this.ListaDb.getUsuario();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DbService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("canciones");
        for (Album cancione : this.album) {
            System.out.println(cancione.getArtista());
        }


    }

}
