/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import domen.Mesto;
import domen.Zaposleni;
import interfaces.SBMestoLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.ZaposleniManager;

/**
 *
 * @author Damjan
 */
@Named("zaposleniManagedBean")
@ViewScoped
public class MBAzurirajZaposlenog implements Serializable {
    
    @EJB
    private ZaposleniManager zaposleniManager;
    @EJB
    private SBMestoLocal mestoManager;
    @Inject
    private MBSesija mbSesija;
    private Zaposleni zaposlen;
    private List<Mesto> mesta;

    public MBAzurirajZaposlenog() {
    }
    
    @PostConstruct
    public void init(){
        zaposlen = (Zaposleni)mbSesija.getMapaPodataka().get("azuriraj zaposlenog");
        mesta = mestoManager.vratiMesta();
    }
    
    public List<Mesto> getMesta(){
        return mesta;
    }

    public Zaposleni getZaposlen() {
        return zaposlen;
    }
    
    public String vratiNaZaposlene(){
        return "sviZaposleni?faces-redirect=true";
    }
    
    public String uradiUpdate(){
        zaposlen = zaposleniManager.azurirajZaposlenog(zaposlen);
        mbSesija.setMapaPodataka(null);
        zaposlen = new Zaposleni();
        return "sviZaposleni?faces-redirect=true";
    }
}
