/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import domen.Mesto;
import domen.Zaposleni;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DamjanZ
 */
@Local
public interface SBZaposleniLocal {
    public List<Zaposleni> vratiZaposlene();
    public void sacuvajZaposlenog(Zaposleni zaposleni);
    public List<Mesto> vratiMesta();
    public Zaposleni vratiZaposlenogPoId(Integer idZaposlenog);
    public Zaposleni azurirajZaposlenog(Zaposleni zaposleni);
    public Integer vratiNoviId();
}
