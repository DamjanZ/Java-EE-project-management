/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Korisnik;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBKorisnikLocal {
    
    Korisnik loginUser(Korisnik k);
    
    Korisnik updateUser(Korisnik k);
    
    Integer getIdCount();
    
    void persist(Korisnik k);
}
