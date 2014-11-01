/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Projekat;
import domen.Ucesce;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBUcesceLocal {
    
    public void sacuvajUcesce(Ucesce ucesce);
    public List<Ucesce> vratiZaposleneKojiUcestvujuUProjektu(Projekat p);
}
