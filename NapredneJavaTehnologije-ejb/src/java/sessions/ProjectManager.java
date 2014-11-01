/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domen.Korisnik;
import domen.Projekat;
import domen.Zaposleni;
import interfaces.SBProjekatLocal;
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
public class ProjectManager implements SBProjekatLocal {
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;

    @Override
    public List<Projekat> vratiListuProjekata(Korisnik k){
        Query query = em.createNamedQuery("Projekat.findByAktuelanAndID");
        query.setParameter("aktuelan", true);
        query.setParameter("korisnikID", k.getKorisnikID() );
        List<Projekat> projekti = query.getResultList();
        return projekti;
    }
    @Override
    public Projekat azurirajProjekat(Projekat p){
        return em.merge(p);
    }
    @Override
    public void persist(Projekat p) {
        em.persist(p);
    }
    @Override
    public List<Zaposleni> vratiZaposlene(){
        Query query = em.createNamedQuery("Zaposleni.findAll");
        return query.getResultList();
    }

    @Override
    public List<Projekat> vratiProjekteKorisnika(Korisnik korisnik) {
        Query query = em.createNamedQuery("Projekat.findAllById");
        query.setParameter("korisnikID", korisnik);
        return query.getResultList();
    }

    @Override
    public Projekat vratiProjekatPoId(Integer projekatId) {
        return em.find(Projekat.class, projekatId);
    }

    @Override
    public Integer generisiNoviId() {
        Query query = em.createNativeQuery("SELECT MAX(idProjekta) FROM Projekat");
        Integer id = (Integer)query.getSingleResult();
        return id+1;
    }
    
    @Override
    public List<Zaposleni> vratiTrenutnoZaposlene() {
        Query query = em.createNamedQuery("Zaposleni.findByZaposlen");
        query.setParameter("zaposlen", true);
        return query.getResultList();
    }
}
