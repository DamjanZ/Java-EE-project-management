/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import domen.Zaposleni;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.ZaposleniManager;

/**
 *
 * @author DamjanZ
 */
@Named("mBPrikaziZaposlene")
@ViewScoped
public class MBPrikaziZaposlene implements Serializable{

    private List<Zaposleni> zaposleni;
    @EJB
    private ZaposleniManager zaposleniManager;
    @Inject
    private MBSesija mbSesija;
    
    public MBPrikaziZaposlene() {
    }
    
    @PostConstruct
    public void init(){
        zaposleni = zaposleniManager.vratiZaposlene();
    }
    
    public List<Zaposleni> getZaposleni(){
        return zaposleni;
    }
    
    public String prikaziDetaljno(Zaposleni zaposlen){
        HashMap hashMap = new HashMap<>();
        hashMap.put("azuriraj zaposlenog", zaposlen);
        mbSesija.setMapaPodataka(hashMap);
        return "zaposleniDetaljno";
    }
    
}
