package ua.kpi.transport.db.dao;

import java.util.Random;
import ua.kpi.transport.db.entities.StationBean;

/**
 *
 * @author harker777
 */
public class DBBootstrapper {

    private static Random rand = new Random(42);

    public static void bootstrap() {
        bootstrapStation();
    }

    public static void bootstrapStation() {
        StationDAO sd = DAOFactory.getDAOFactory("MYSQL").getStationDAO();
        for (int i = 0; i < 10; i++) {
            StationBean bean = sd.create();
            bean.setName("Station " + (i + 1));
            bean.setLattitude(rand.nextFloat() * 20.0F + 1.0F);
            bean.setLongitude(rand.nextFloat() * 20.0F + 1.0F);
            sd.update(bean);
        }
    }
}
