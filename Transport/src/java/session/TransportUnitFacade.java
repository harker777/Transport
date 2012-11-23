/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TransportUnit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harker777
 */
@Stateless
public class TransportUnitFacade extends AbstractFacade<TransportUnit> implements TransportUnitFacadeLocal {
    @PersistenceContext(unitName = "TransportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportUnitFacade() {
        super(TransportUnit.class);
    }
    
}
