/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TransportType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author harker777
 */
@Local
public interface TransportTypeFacadeLocal {

    void create(TransportType transportType);

    void edit(TransportType transportType);

    void remove(TransportType transportType);

    TransportType find(Object id);

    List<TransportType> findAll();

    List<TransportType> findRange(int[] range);

    int count();
    
}
