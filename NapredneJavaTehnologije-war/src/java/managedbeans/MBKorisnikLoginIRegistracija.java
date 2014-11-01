/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import domen.Korisnik;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.KorisnikManager;

/**
 *
 * @author Damjan
 */
@Named(value = "korisnikManagedBean")
@RequestScoped
public class MBKorisnikLoginIRegistracija implements Serializable {

    private Korisnik korisnik;
    @EJB
    private KorisnikManager korisnikManager;
    @Inject 
    MBSesija mbSesija;

    public MBSesija getMbSesija() {
        return mbSesija;
    }
 
    public MBKorisnikLoginIRegistracija() {
        korisnik = new Korisnik();
    }
    
    public Korisnik getKorisnik(){
        return korisnik;
    }
    
    public void setKorisnik(Korisnik korisnik){
        this.korisnik = korisnik;
    }
    
    public String login(){
        try{
        korisnik = korisnikManager.loginUser(korisnik);
        mbSesija.setUlogovaniKorisnik(korisnik);
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogresan username ili password. Pokusajte ponovo.",""));
            return "index";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste se ulogovali pod nazivom: "+korisnik.getUsername()+".", ""));
        return "pocetna?faces-redirect=true";
    }
    
    public String editujPodatkeKorisnika(){
        return "azurirajKorisnika";
    } 
    
    public void update(){
        korisnik = korisnikManager.updateUser(korisnik);
    }
    
    public String register(){
        korisnik.setKorisnikID(korisnikManager.getIdCount());
        korisnikManager.persist(korisnik);
        return "index?faces-redirect=true";
    }
    
    public String logout(){
        mbSesija.setUlogovaniKorisnik(null);
        return "index?faces-redirect=true";
    }
    
    public boolean daLiJeUlogovan(){
        return korisnik!=null;
    }
}