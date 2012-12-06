package ua.kpi.transport.db.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ua.kpi.transport.db.dao.interfaces.IDistanceDAO;
import ua.kpi.transport.db.dao.interfaces.IRouteDAO;
import ua.kpi.transport.db.dao.interfaces.IRouteToStationDAO;
import ua.kpi.transport.db.dao.interfaces.IStationDAO;
import ua.kpi.transport.db.dao.interfaces.IStationToTypeDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportTypeDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportUnitDAO;
import ua.kpi.transport.db.dao.MySQLDistanceDAO;
import ua.kpi.transport.db.dao.MySQLRouteDAO;
import ua.kpi.transport.db.dao.MySQLRouteToStationDAO;
import ua.kpi.transport.db.dao.MySQLStationDAO;
import ua.kpi.transport.db.dao.MySQLStationToTypeDAO;
import ua.kpi.transport.db.dao.MySQLTransportStopDAO;
import ua.kpi.transport.db.dao.MySQLTransportTypeDAO;
import ua.kpi.transport.db.dao.MySQLTransportUnitDAO;
import ua.kpi.transport.db.dao.interfaces.ITransportStopDAO;

/**
 *
 * @author harker777
 */
public class MySQLDAOFactory extends DAOFactory {

    private static Connection conn;

    public MySQLDAOFactory() {
    }

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        } else {
            //First - load the library
            String url = "jdbc:mysql://localhost/transport";
            String driver = "org.gjt.mm.mysql.Driver";
            String user = "root";
            String pass = "root";
            try {
                Class.forName(driver).newInstance();
            } catch (ClassNotFoundException e) {
                //TODO: Log
                System.out.println("Cannot create connection - no driver found");
            } catch (InstantiationException e) {
                //TODO: Log
                System.out.println("Cannot create connection - instantiation problem");
            } catch (Exception e) {
                //TODO: Log
                System.out.println("Some other exception =(");
            }

            //And now - create the static connection to return
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                //TODO: Log
                System.out.println("Cannot create connection - check user/pass");
            }

            //And, well, return that connection =)
            return conn;
        }
    }

    @Override
    public IStationDAO getStationDAO() {
        return new MySQLStationDAO();
    }

    @Override
    public ITransportTypeDAO getTransportTypeDAO() {
        return new MySQLTransportTypeDAO();
    }

    @Override
    public IStationToTypeDAO getStationToTypeDAO() {
        return new MySQLStationToTypeDAO();
    }

    @Override
    public IDistanceDAO getDistanceDAO() {
        return new MySQLDistanceDAO();
    }

    @Override
    public IRouteDAO getRouteDAO() {
        return new MySQLRouteDAO();
    }

    @Override
    public ITransportUnitDAO getTransportUnitDAO() {
        return new MySQLTransportUnitDAO();
    }

    @Override
    public IRouteToStationDAO getRouteToStationDAO() {
        return new MySQLRouteToStationDAO();
    }

    @Override
    public ITransportStopDAO getTransportStopDAO() {
        return new MySQLTransportStopDAO();
    }
}
