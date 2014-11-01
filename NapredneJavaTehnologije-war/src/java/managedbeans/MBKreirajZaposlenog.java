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
import javax.inject.Named;
import sessions.ZaposleniManager;

/**
 *
 * @author DamjanZ
 */
@Named("mBKreirajZaposlenog")
@ViewScoped
public class MBKreirajZaposlenog implements Serializable{

    @EJB
    private ZaposleniManager zaposleniManager;
    @EJB
    private SBMestoLocal mestoManager;
    private Zaposleni zaposlen;
    private List<Mesto> mesta;
    /**
     * Creates a new instance of MBKreirajZaposlenog
     */
    public MBKreirajZaposlenog() {
    }
    
    @PostConstruct
    public void init(){
        zaposlen = new Zaposleni();
        mesta = mestoManager.vratiMesta();
    }
    
    public Zaposleni getZaposlen() {
        return zaposlen;
    }
    
    public List<Mesto> getMesta(){
        return mesta;
    }
    
    public String ubaciZaposlenog(){
        zaposlen.setIdZaposlenog(zaposleniManager.vratiNoviId());
        zaposleniManager.sacuvajZaposlenog(zaposlen);
        return "pocetna";
    }
}
