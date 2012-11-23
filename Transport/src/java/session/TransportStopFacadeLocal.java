/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TransportStop;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface TransportStopFacadeLocal {

    void create(TransportStop transportStop);

    void edit(TransportStop transportStop);

    void remove(TransportStop transportStop);

    TransportStop find(Object id);

    List<TransportStop> findAll();

    List<TransportStop> findRange(int[] range);

    int count();
    
}
