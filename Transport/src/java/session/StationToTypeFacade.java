/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.StationToType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harker777
 */
@Stateless
public class StationToTypeFacade extends AbstractFacade<StationToType> implements StationToTypeFacadeLocal {
    @PersistenceContext(unitName = "TransportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationToTypeFacade() {
        super(StationToType.class);
    }
    
}
