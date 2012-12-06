package testing;

import ua.kpi.transport.db.dao.interfaces.IStationDAO;
import ua.kpi.transport.db.dao.interfaces.IDistanceDAO;
import ua.kpi.transport.db.dao.factory.DAOFactory;
import java.sql.SQLException;
import ua.kpi.transport.db.dao.*;
import ua.kpi.transport.db.dao.utils.DBBootstrapper;
import ua.kpi.transport.db.entities.*;
import ua.kpi.transport.util.settings.Pages;

/**
 *
 * @author harker777
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        DBBootstrapper.bootstrap();
//        testDistanceDAO();
    }
}
