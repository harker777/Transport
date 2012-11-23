/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.RouteToStation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harker777
 */
@Stateless
public class RouteToStationFacade extends AbstractFacade<RouteToStation> implements RouteToStationFacadeLocal {
    @PersistenceContext(unitName = "TransportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RouteToStationFacade() {
        super(RouteToStation.class);
    }
    
}
