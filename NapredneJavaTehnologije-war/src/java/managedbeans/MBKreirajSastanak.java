/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import domen.Projekat;
import domen.Sastanak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.ProjectManager;
import sessions.SastanakManager;

/**
 *
 * @author Damjan
 */
@Named(value="mBKreirajSastanak")
public class MBKreirajSastanak implements Serializable{
    
    @EJB
    private SastanakManager sastanakManager;
    @EJB
    private ProjectManager projectManager;
    @Inject
    private MBSesija mbSesija;
    
    private Sastanak sastanak;
    private List<Projekat> projekti;
    /**
     * Creates a new instance of SastanakManagedBean
     */
    public MBKreirajSastanak() {
        sastanak = new Sastanak();
        projekti = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        projekti = projectManager.vratiListuProjekata(mbSesija.getUlogovaniKorisnik());
    }
    
     public List<Projekat> getProjekti(){
        return projekti;    
    }
     
    public Sastanak getSastanak(){
        return sastanak;
    }
    
    public void setSastanak(Sastanak sastanak){
        this.sastanak = sastanak;
    }
    
    public String sacuvajSastanak(){
        sastanak.setIdSastanka(sastanakManager.vratiId());
        sastanakManager.persist(sastanak);
        return "pocetna";
    }
    
}
