package ua.kpi.transport.db.dao;

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
    
    public abstract StationDAO getStationDAO();
    
    public abstract TransportTypeDAO getTransportTypeDAO();
}
