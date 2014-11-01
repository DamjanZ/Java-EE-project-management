/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import domen.Korisnik;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DamjanZ
 */
@Named(value = "mBSesija")
@SessionScoped
public class MBSesija implements Serializable {

    private Korisnik ulogovaniKorisnik;
    private HashMap<String, Object> mapaPodataka;

    public MBSesija() {
        mapaPodataka = new HashMap<String, Object> ();
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }
    
    public HashMap<String, Object> getMapaPodataka() {
        return mapaPodataka;
    }

    public void setMapaPodataka(HashMap<String, Object> mapaPodataka) {
        this.mapaPodataka = mapaPodataka;
    }
    
    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        setUlogovaniKorisnik(null);
        ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
    }
    
    public void redirect() throws IOException{
        if(ulogovaniKorisnik==null){
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
        }
    }
}
