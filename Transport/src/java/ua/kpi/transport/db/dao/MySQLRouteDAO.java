package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.interfaces.IRouteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.RouteBean;

/**
 *
 * @author harker777
 */
public class MySQLRouteDAO implements IRouteDAO {

    @Override
    public RouteBean find(Integer id) {
        String query = "SELECT * FROM route WHERE (Id = ?) LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query, id);
        return fromResultSet(rs).get(0);
    }

    @Override
    public List<RouteBean> findAll() {
        String query = "SELECT * FROM route";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs);
    }

    @Override
    public RouteBean create() {
        String query = "INSERT INTO route VALUES (NULL, ?)";
        MySQLQueryExecutioner.executeUpdate(query, "Name");

        query = "SELECT * FROM route ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(RouteBean bean) {
        String query = "DELETE FROM route WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query, bean.getId());
    }

    @Override
    public void delete(List<RouteBean> beans) {
        for (RouteBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(RouteBean bean) {
        String query = ""
                + "UPDATE route "
                + "  SET Name = ? "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query,bean.getName(),bean.getId());
    }

    @Override
    public void update(List<RouteBean> beans) {
        for (RouteBean bean : beans){
            update(bean);
        }
    }

    @Override
    public List<RouteBean> fromResultSet(ResultSet rs) {
        List<RouteBean> result = new ArrayList<RouteBean>();
        try {
            while (rs.next()) {
                RouteBean bean = new RouteBean(rs.getInt("Id"));
                bean.setName(rs.getString("Name"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
