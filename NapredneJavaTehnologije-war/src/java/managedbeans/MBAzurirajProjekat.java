/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import domen.Projekat;
import domen.Ucesce;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.ProjectManager;
import sessions.UcesceManager;

/**
 *
 * @author DamjanZ
 */
@Named(value = "mBAzurirajProjekat")
@ViewScoped
public class MBAzurirajProjekat implements Serializable{

    private Projekat projekat;
    private List<Ucesce> ucesca;
    
    @EJB
    private ProjectManager projectManager;
    @EJB
    private UcesceManager ucesceManager;
    @Inject
    private MBSesija mbSesija;

    public MBAzurirajProjekat() {
    }
    
    @PostConstruct
    public void init(){
        projekat = (Projekat) mbSesija.getMapaPodataka().get("azuriraj projekat");
        ucesca = ucesceManager.vratiZaposleneKojiUcestvujuUProjektu(projekat);
    }
    
    public Projekat getProjekat(){
        return projekat;
    }
    
    public void setProjekat(Projekat projekat){
        this.projekat = projekat;
    }

    public List<Ucesce> getUcesca() {
        return ucesca;
    }

    public void setUcesca(List<Ucesce> ucesca) {
        this.ucesca = ucesca;
    }
    
    public String azurirajProjekat(){
        projectManager.azurirajProjekat(projekat);
        mbSesija.setMapaPodataka(null);
        return "projekti?faces-redirect=true";
    }
    
}
