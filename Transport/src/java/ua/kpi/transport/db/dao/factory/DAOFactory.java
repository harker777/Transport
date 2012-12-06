package ua.kpi.transport.db.dao.factory;

import ua.kpi.transport.db.dao.interfaces.IDistanceDAO;
import ua.kpi.transport.db.dao.interfaces.IRouteDAO;
import ua.kpi.transport.db.dao.interfaces.IRouteToStationDAO;
import ua.kpi.transport.db.dao.interfaces.IStationDAO;
import ua.kpi.transport.db.dao.interfaces.IStationToTypeDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportStopDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportTypeDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportUnitDAO;

/**
 *
 * @author harker777
 */
public abstract class DAOFactory {
    private static final String MYSQL = "MYSQL";
    private static final String ORACLE = "ORACLE";
    
    public static DAOFactory getDAOFactory(String type){
        if (type.toUpperCase().equals(MYSQL)){
            return new MySQLDAOFactory();
        }
        if (type.toUpperCase().equals(ORACLE)){
            return new MySQLDAOFactory();
        }
        return null;
    }
    
    public abstract IStationDAO getStationDAO();
    
    public abstract ITransportTypeDAO getTransportTypeDAO();
    
    public abstract IStationToTypeDAO getStationToTypeDAO();
    
    public abstract IDistanceDAO getDistanceDAO();
    
    public abstract IRouteDAO getRouteDAO();
    
    public abstract ITransportUnitDAO getTransportUnitDAO();
    
    public abstract IRouteToStationDAO getRouteToStationDAO();
    
    public abstract ITransportStopDAO getTransportStopDAO();
}
