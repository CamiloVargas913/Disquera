/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.ucundi.edu.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import udec.ucundi.edu.model.Album;
import udec.ucundi.edu.model.Cancion;
import udec.ucundi.edu.service.AlbunService;
import udec.ucundi.edu.service.DbService;

/**
 *
 * @author PROFESIONAL
 */
@Named(value = "index")
@SessionScoped
public class Index implements Serializable {

    private List<Album> albunes;
    private Album albun;

    @Inject
    private AlbunService service;
    @Inject
    private DbService serviceDb;

    public Index() {

    }

    @PostConstruct
    public void init() {
        this.albunes = service.getAlbun();

//        albunes.forEach((albune) -> {
//            this.canciones = albune.getCanciones();
//            System.out.println(albune.getArtista());
//            canciones.forEach((cansion)-> {
//                System.out.println(cansion.getNombre());
//           
//            });
//        });
    }

    public void actualizar(RowEditEvent event) {
        Cancion can = (Cancion) event.getObject();
    }

    public void eliminar() {
        serviceDb.llenar();
        System.out.println("ok-----");
        serviceDb.leer();
    }

    public List<Album> getAlbunes() {
        return albunes;
    }

    public void setAlbunes(List<Album> albunes) {
        this.albunes = albunes;
    }

    public Album getAlbun() {
        return albun;
    }

    public void setAlbun(Album albun) {
        this.albun = albun;
    }

    public AlbunService getService() {
        return service;
    }

    public void setService(AlbunService service) {
        this.service = service;
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
            showMessage(clientId);
        });
    }

    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }

}
