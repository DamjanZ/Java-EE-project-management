/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Korisnik;
import domen.Projekat;
import domen.Zaposleni;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBProjekatLocal {
    
    List<Projekat> vratiListuProjekata(Korisnik k);
    
    Projekat azurirajProjekat(Projekat p);
    
    void persist(Projekat p);
    
    List<Zaposleni> vratiZaposlene();
    
    List<Projekat> vratiProjekteKorisnika(Korisnik korisnik);
    
    Projekat vratiProjekatPoId(Integer projekatId);
    
    Integer generisiNoviId();
    
    List<Zaposleni> vratiTrenutnoZaposlene();
}
