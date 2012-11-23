/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Distance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface DistanceFacadeLocal {

    void create(Distance distance);

    void edit(Distance distance);

    void remove(Distance distance);

    Distance find(Object id);

    List<Distance> findAll();

    List<Distance> findRange(int[] range);

    int count();
    
}
