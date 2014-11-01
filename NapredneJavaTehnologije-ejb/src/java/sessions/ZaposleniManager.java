/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domen.Mesto;
import domen.Zaposleni;
import interfaces.SBZaposleniLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Damjan
 */
@Stateless
@LocalBean
public class ZaposleniManager implements SBZaposleniLocal{
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;

    @Override
    public List<Mesto> vratiMesta(){
        Query query = em.createNamedQuery("Mesto.findAll");
        return query.getResultList();
    }
    
    @Override
    public List<Zaposleni> vratiZaposlene(){
        Query query = em.createNamedQuery("Zaposleni.findAll");
        return query.getResultList();
    }

    @Override
    public void sacuvajZaposlenog(Zaposleni zaposleni) {
        em.merge(zaposleni);
    }
    
    @Override
    public Zaposleni vratiZaposlenogPoId(Integer idZaposlenog) {
        Zaposleni zaposlen = em.find(Zaposleni.class, idZaposlenog);
        return zaposlen;
    }
    
    @Override
    public Zaposleni azurirajZaposlenog(Zaposleni zaposleni) {
        return em.merge(zaposleni);
    }

    @Override
    public Integer vratiNoviId() {
        Query query = em.createNativeQuery("SELECT MAX(idZaposlenog) FROM Zaposleni");
        Integer id = (Integer)query.getSingleResult()+1;
        return id;
    }
}
