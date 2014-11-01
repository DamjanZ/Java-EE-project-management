/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import domen.Korisnik;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import sessions.KorisnikManager;

/**
 *
 * @author DamjanZ
 */
public class MBPromenaSifre implements Serializable{

    @EJB
    private KorisnikManager korisnikManager;
    
    @Inject
    private MBSesija mbSesija;
    
    private String staraSifra;
    private String novaSifra;
    private String ponoviNovuSifru;

    public String getPonoviNovuSifru() {
        return ponoviNovuSifru;
    }

    public void setPonoviNovuSifru(String ponoviNovuSifru) {
        this.ponoviNovuSifru = ponoviNovuSifru;
    }

    private Korisnik korisnik;
    
    public MBPromenaSifre() {
        staraSifra = "";
        novaSifra = "";
        ponoviNovuSifru = "";
    }
    
    @PostConstruct
    public void init(){
        korisnik = mbSesija.getUlogovaniKorisnik();
    }
    public String getStaraSifra() {
        return staraSifra;
    }

    public void setStaraSifra(String staraSifra) {
        this.staraSifra = staraSifra;
    }

    public String getNovaSifra() {
        return novaSifra;
    }

    public void setNovaSifra(String novaSifra) {
        this.novaSifra = novaSifra;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public String promeniSifruKorisnika(){
        String sifra = korisnik.getPassword();
        if(!staraSifra.equals(sifra)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Niste uneli staru sifru dobro.", "");
            throw new ValidatorException(message);
        }else if(!novaSifra.equals(ponoviNovuSifru)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proverite da li su nove sifre dobro postavljene.", "");
            throw new ValidatorException(message);
        }else{
            korisnik.setPassword(novaSifra);
            korisnikManager.updateUser(korisnik);
            mbSesija.getUlogovaniKorisnik().setPassword(novaSifra);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Uspesno ste promenili sifru vaseg naloga.", ""));
            return "pocetna?faces-redirect=true";
        }   
    }
    
}
