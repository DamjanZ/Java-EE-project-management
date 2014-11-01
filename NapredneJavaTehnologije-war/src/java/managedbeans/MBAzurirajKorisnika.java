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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.KorisnikManager;

/**
 *
 * @author DamjanZ
 */
@Named(value = "mBAzurirajKorisnika")
@ViewScoped
public class MBAzurirajKorisnika implements Serializable{

    Korisnik ulogovaniKorisnik;
    
    @EJB
    private KorisnikManager korisnikManager;
    
    @Inject
    private MBSesija mbSesija;

    public MBAzurirajKorisnika() {
        ulogovaniKorisnik = new Korisnik();
    }
    
    @PostConstruct
    public void init(){
        ulogovaniKorisnik = mbSesija.getUlogovaniKorisnik();
    }
    
    public String update(){
        ulogovaniKorisnik = korisnikManager.updateUser(ulogovaniKorisnik);
        mbSesija.setUlogovaniKorisnik(ulogovaniKorisnik);
        return "pocetna?faces-redirect=true";
    }
}
