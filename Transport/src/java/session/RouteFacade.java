/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Route;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harker777
 */
@Stateless
public class RouteFacade extends AbstractFacade<Route> implements RouteFacadeLocal {
    @PersistenceContext(unitName = "TransportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RouteFacade() {
        super(Route.class);
    }
    
}
