package ua.kpi.transport.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author harker777
 */
public class MySQLDAOFactory extends DAOFactory{
    private static Connection conn;
    
    public MySQLDAOFactory(){
    }

    public static Connection getConnection(){
        if (conn != null){
            return conn;
        } else{
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
    public StationDAO getStationDAO(){
        return new MySQLStationDAO();
    }
    
    @Override
    public TransportTypeDAO getTransportTypeDAO(){
        return new MySQLTransportTypeDAO();
    }

    @Override
    public StationToTypeDAO getStationToTypeDAO() {
        return new MySQLStationToTypeDAO();
    }
    
    @Override
    public DistanceDAO getDistanceDAO(){
        return new MySQLDistanceDAO();
    }
}
