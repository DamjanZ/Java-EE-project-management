/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domen.Sastanak;
import interfaces.SBSastanakLocal;
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
public class SastanakManager implements SBSastanakLocal{
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Sastanak sastanak) {
        em.persist(sastanak);
    }

    @Override
    public int vratiId(){
        Query query = em.createNativeQuery("SELECT MAX(idSastanka) FROM Sastanak");
        Integer i = (Integer)query.getSingleResult()+1;
        return i;
    }

    @Override
    public Sastanak vratiSastanakPoId(int sastanakId) {
        Sastanak sastanak = em.find(Sastanak.class, sastanakId);
        return sastanak;
    }
}
