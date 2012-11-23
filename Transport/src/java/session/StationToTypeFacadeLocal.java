/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.StationToType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface StationToTypeFacadeLocal {

    void create(StationToType stationToType);

    void edit(StationToType stationToType);

    void remove(StationToType stationToType);

    StationToType find(Object id);

    List<StationToType> findAll();

    List<StationToType> findRange(int[] range);

    int count();
    
}
