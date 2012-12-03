package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.entities.BaseBean;
import ua.kpi.transport.db.entities.StationBean;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harker777
 */
public class MySQLQueryExecutioner{

    public static ResultSet execute(String query, Object[] args) {
        PreparedStatement ps = fillStatement(query, args);
        try {
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLQueryExecutioner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void executeUpdate(String query, Object[] args){
        PreparedStatement ps = fillStatement(query, args);
        try {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLQueryExecutioner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PreparedStatement fillStatement(String query, Object[] args){
        PreparedStatement ps = prepareStatement(query);
        for (int i = 0; i<args.length; i++){
            try {
                String name = args[i].getClass().getSimpleName();
                if (name.equals("Integer")) ps.setInt(i+1, (Integer)args[i]);
                if (name.equals("Float")) ps.setFloat(i+1, (Float)args[i]);
                if (name.equals("String")) ps.setString(i+1, (String)args[i]);
            } catch (SQLException ex) {
                Logger.getLogger(MySQLQueryExecutioner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ps;
    }
    
    private static PreparedStatement prepareStatement(String query){
        try {
            return MySQLDAOFactory.getConnection().prepareStatement(query);
        } catch (SQLException ex) {
            //TODO: Log
        }
        return null;
    }
    
}
