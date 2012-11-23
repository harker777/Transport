/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface StationFacadeLocal {

    void create(Station station);

    void edit(Station station);

    void remove(Station station);

    Station find(Object id);

    List<Station> findAll();

    List<Station> findRange(int[] range);

    int count();
    
}
