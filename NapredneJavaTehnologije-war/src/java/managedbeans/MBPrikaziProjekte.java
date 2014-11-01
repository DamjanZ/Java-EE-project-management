/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import domen.Projekat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.ProjectManager;


@Named(value = "mBPrikaziProjekat")
@ViewScoped
public class MBPrikaziProjekte implements Serializable {
    @EJB
    private ProjectManager projectManager;
    @Inject
    private MBSesija mbSesija;
    
    private List<Projekat> projekti;

    public MBPrikaziProjekte() {
    }
    
    @PostConstruct
    public void init(){
        projekti = projectManager.vratiProjekteKorisnika(mbSesija.getUlogovaniKorisnik());
    }
    
    public List<Projekat> getProjekti(){
        return projekti;
    }

    public String pokaziIzabraniProjekat(Projekat projekat){
        HashMap hashMap = new HashMap<>();
        hashMap.put("azuriraj projekat", projekat);
        mbSesija.setMapaPodataka(hashMap);
        return "projektiDetaljno?faces-redirect=true";
    }

}
