/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Sastanak;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBSastanakLocal {
    
    void persist(Sastanak sastanak);
    
    int vratiId();
    
    Sastanak vratiSastanakPoId(int sastanakId);
}
