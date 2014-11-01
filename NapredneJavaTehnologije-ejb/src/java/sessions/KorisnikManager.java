/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domen.Korisnik;
import interfaces.SBKorisnikLocal;
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
public class KorisnikManager implements SBKorisnikLocal {
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;
    
    @Override
    public Korisnik loginUser(Korisnik k) {
        Query query = em.createNamedQuery("Korisnik.findByUsernameAndPassword");
        query.setParameter("username", k.getUsername());
        query.setParameter("password", k.getPassword());
        return (Korisnik)query.getSingleResult();
    }

    @Override
    public Korisnik updateUser(Korisnik k){
        return em.merge(k);
    }
    @Override
    public void persist(Korisnik k) {
        em.persist(k);
    }

    @Override
    public Integer getIdCount() {
        
        Query query = em.createNativeQuery("SELECT MAX(korisnikID) FROM Korisnik");
        Integer id1 = (Integer)query.getSingleResult()+1;
        return id1;
        
    }

}
