/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Route;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface RouteFacadeLocal {

    void create(Route route);

    void edit(Route route);

    void remove(Route route);

    Route find(Object id);

    List<Route> findAll();

    List<Route> findRange(int[] range);

    int count();
    
}
