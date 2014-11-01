/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessions;

import domen.Mesto;
import interfaces.SBMestoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DamjanZ
 */
@Stateless
public class MestoManager implements SBMestoLocal {
    
    @PersistenceContext(unitName = "NapredneJavaTehnologije-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Mesto> vratiMesta() {
        Query query = em.createNamedQuery("Mesto.findAll");
        return query.getResultList();
    }

    @Override
    public Mesto vratiMestoNaOsnovuPtt(Integer ptt) {
        return em.find(Mesto.class, ptt);
    }
}
