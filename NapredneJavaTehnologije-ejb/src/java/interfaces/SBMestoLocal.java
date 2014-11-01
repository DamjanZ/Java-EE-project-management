/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Mesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBMestoLocal {
    
    public List<Mesto> vratiMesta();
    public Mesto vratiMestoNaOsnovuPtt(Integer ptt);
}
