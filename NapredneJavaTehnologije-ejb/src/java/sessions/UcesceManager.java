/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessions;

import domen.Projekat;
import domen.Ucesce;
import interfaces.SBUcesceLocal;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DamjanZ
 */
@Stateless
@LocalBean
public class UcesceManager implements SBUcesceLocal {
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;
    
    @Override
    public void sacuvajUcesce(Ucesce ucesce) {
        em.persist(ucesce);
    }

    @Override
    public List<Ucesce> vratiZaposleneKojiUcestvujuUProjektu(Projekat p) {
        Query query = em.createNamedQuery("Ucesce.findByIdProjekta");
        query.setParameter("idProjekta", p.getIdProjekta());
        return query.getResultList();
    }
}
