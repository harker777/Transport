package testing;

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
//        System.out.println(Pages.getPage("HOME_PAGE"));
    }
    
    public static void testDistanceDAO(){
        DistanceDAO sd = DAOFactory.getDAOFactory("MYSQl").getDistanceDAO();
        sd.create();
        sd.create();
        DistanceBean db = sd.find(1);
        db.setDistance(3);
        db.setStationFromId(61);
        db.setStationToId(62);
        sd.update(db);
        sd.delete(sd.find(2));
        for (DistanceBean bean : sd.findAll()){
            System.out.println(bean);
        }
        
        
    }
}
