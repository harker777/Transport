/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.RouteToStation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface RouteToStationFacadeLocal {

    void create(RouteToStation routeToStation);

    void edit(RouteToStation routeToStation);

    void remove(RouteToStation routeToStation);

    RouteToStation find(Object id);

    List<RouteToStation> findAll();

    List<RouteToStation> findRange(int[] range);

    int count();
    
}
