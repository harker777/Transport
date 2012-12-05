package testing;

import ua.kpi.transport.db.dao.factory.DAOFactory;
import java.sql.SQLException;
import ua.kpi.transport.db.dao.*;
import ua.kpi.transport.db.entities.*;
import ua.kpi.transport.util.settings.Pages;

/**
 *
 * @author harker777
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        testDistanceDAO();
    }
    
    public static void testDistanceDAO(){
        IDistanceDAO dd = DAOFactory.getDAOFactory("MYSQl").getDistanceDAO();
        IStationDAO sd = DAOFactory.getDAOFactory("MYSQL").getStationDAO();
        dd.delete(dd.findAll());
        dd.create();
        dd.create();
        dd.create();
        dd.create();
        DistanceBean db = dd.find(dd.findAll().get(2).getId());
        db.setDistance(3);
        db.setStationFromId(sd.findAll().get(0).getId());
        db.setStationToId(sd.findAll().get(1).getId());
        dd.update(db);
        dd.delete(dd.find(dd.findAll().get(1).getId()));
        for (DistanceBean bean : dd.findAll()){
            System.out.println(bean);
        }
    }
}
