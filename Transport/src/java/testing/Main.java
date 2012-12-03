package testing;

import java.sql.SQLException;
import ua.kpi.transport.db.dao.*;
import ua.kpi.transport.db.entities.StationBean;

/**
 *
 * @author harker777
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        StationDAO sd = DAOFactory.getDAOFactory("MYSQl").getStationDAO();
        for (StationBean bean : sd.findAll()){
            System.out.println(bean);
        }
    }
}
