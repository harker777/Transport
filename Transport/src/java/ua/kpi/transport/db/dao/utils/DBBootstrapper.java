package ua.kpi.transport.db.dao.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import ua.kpi.transport.db.dao.factory.DAOFactory;
import ua.kpi.transport.db.dao.interfaces.IDistanceDAO;
import ua.kpi.transport.db.dao.interfaces.IRouteDAO;
import ua.kpi.transport.db.dao.interfaces.IStationDAO;
import ua.kpi.transport.db.entities.RouteBean;
import ua.kpi.transport.db.entities.StationBean;

/**
 *
 * @author harker777
 */
public class DBBootstrapper {
    
    private static final Integer ENTITY_NUM = 20;

    private static Random rand = new Random(42);

    public static void bootstrap() {
        bootstrapStation();
        bootstrapRoute();
        bootstrapDistance();
    }
    
    public static void bootstrapDistance() {
        IDistanceDAO dd = DAOFactory.getDAOFactory("MYSQL").getDistanceDAO();
        IStationDAO sd = DAOFactory.getDAOFactory("MYSQL").getStationDAO();
    }

    public static void bootstrapStation() {
        IStationDAO sd = DAOFactory.getDAOFactory("MYSQL").getStationDAO();
        sd.delete(sd.findAll());
        for (int i = 0; i < ENTITY_NUM; i++) {
            StationBean bean = sd.create();
            bean.setName("Station " + (i + 1));
            bean.setLattitude(rand.nextFloat() * 20.0F + 1.0F);
            bean.setLongitude(rand.nextFloat() * 20.0F + 1.0F);
            sd.update(bean);
        }
    }

    public static void bootstrapRoute() {
        IRouteDAO rd = DAOFactory.getDAOFactory("MYSQL").getRouteDAO();
        rd.delete(rd.findAll());
        for (int i = 0; i < ENTITY_NUM; i++) {
            RouteBean bean = rd.create();
            bean.setName("Route " + (i +1));
            rd.update(bean);
        }
        
    }
    
}
