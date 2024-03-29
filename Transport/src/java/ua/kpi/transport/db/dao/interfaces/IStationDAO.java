package ua.kpi.transport.db.dao.interfaces;

import ua.kpi.transport.db.entities.StationBean;
import ua.kpi.transport.db.entities.TransportTypeBean;
import java.util.List;

/**
 *
 * @author harker777
 */
public interface IStationDAO extends IEntityDAO<StationBean>{
    
    public StationBean findByName(String name);
    
    public List<StationBean> findByType(TransportTypeBean type);
}
