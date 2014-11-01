/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import domen.Korisnik;
import domen.Projekat;
import domen.Ucesce;
import domen.Zaposleni;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import sessions.ProjectManager;

/**
 *
 * @author DamjanZ
 */
@ManagedBean(name = "mbKreirajProjekat")
@ViewScoped
public class MBKreirajProjekat implements Serializable {
    @EJB
    private ProjectManager projectManager;
    @Inject
    private MBSesija mbSesija;
    
    private Projekat projekat;
    private Ucesce novoUcesce;
    private List<Ucesce> ucesca;
    private List<Zaposleni> zaposleni;
    
    public MBKreirajProjekat() {
        projekat = new Projekat();
        ucesca = new ArrayList<>();
        projekat.setUcesceCollection(ucesca);
        novoUcesce = new Ucesce();
    }
    
    @PostConstruct
    public void init(){
        setZaposleni(projectManager.vratiTrenutnoZaposlene());
    }
    
    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(List<Zaposleni> zaposleni) {
        this.zaposleni = zaposleni;
    }
    
    public Projekat getProjekat(){
        return projekat;
    }
    
    public List<Ucesce> getListaUcesca(){
        return ucesca;
    }
    
    public Ucesce getNovoUcesce(){
        return novoUcesce;
    }
    public List<Zaposleni> getZaposlene(){
        return getZaposleni();
    }
    
    public void dodajUcesce(){
        
        boolean postoji = false;
        
        if(!projekat.getUcesceCollection().isEmpty()){    
            System.out.println("Ucesce 3");
            for(Iterator<Ucesce> it = projekat.getUcesceCollection().iterator(); it.hasNext();){
                Ucesce ucesce = it.next();
                if(ucesce.getIdZaposlenog().getIdZaposlenog() == novoUcesce.getIdZaposlenog().getIdZaposlenog()){
                    postoji = true;
                }
            }
        }
        
        if(postoji==false){
            projekat.getUcesceCollection().add(novoUcesce);
            novoUcesce = new Ucesce();
        }
    }
    
    public String ubaciProjekat(){
        Korisnik k = mbSesija.getUlogovaniKorisnik();
        projekat.setKorisnikID(k);
        projekat.setIdProjekta(projectManager.generisiNoviId());
        projekat.setAktuelan(true);
        
        for (Ucesce ucesce : projekat.getUcesceCollection()) {
            ucesce.setIdProjekta(projekat);
        }
        projectManager.persist(projekat);
        return "pocetna";
    }
}