/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TransportUnit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface TransportUnitFacadeLocal {

    void create(TransportUnit transportUnit);

    void edit(TransportUnit transportUnit);

    void remove(TransportUnit transportUnit);

    TransportUnit find(Object id);

    List<TransportUnit> findAll();

    List<TransportUnit> findRange(int[] range);

    int count();
    
}
