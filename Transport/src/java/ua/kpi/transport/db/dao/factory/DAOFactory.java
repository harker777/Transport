package ua.kpi.transport.db.dao.factory;

import ua.kpi.transport.db.dao.IDistanceDAO;
import ua.kpi.transport.db.dao.IStationDAO;
import ua.kpi.transport.db.dao.IStationToTypeDAO;
import ua.kpi.transport.db.dao.ITransportTypeDAO;

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
}
