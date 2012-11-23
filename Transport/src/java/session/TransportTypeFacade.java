/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TransportType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harker777
 */
@Stateless
public class TransportTypeFacade extends AbstractFacade<TransportType> implements TransportTypeFacadeLocal {
    @PersistenceContext(unitName = "TransportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportTypeFacade() {
        super(TransportType.class);
    }
    
}
