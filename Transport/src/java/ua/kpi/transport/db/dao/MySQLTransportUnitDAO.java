package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.interfaces.ITransportUnitDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.TransportUnitBean;

/**
 *
 * @author harker777
 */
public class MySQLTransportUnitDAO implements ITransportUnitDAO {

    @Override
    public TransportUnitBean find(Integer id) {
        String query = "SELECT * FROM transportunit WHERE (Id = ?)";
        ResultSet rs = MySQLQueryExecutioner.execute(query, id);
        return fromResultSet(rs).get(0);
    }

    @Override
    public List<TransportUnitBean> findAll() {
        String query = "SELECT * FROM transportunit";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs);
    }

    @Override
    public TransportUnitBean create() {
        String query = "INSERT INTO transportuint VALUES (NULL,?,NULL,NULL)";
        MySQLQueryExecutioner.executeUpdate(query, "AA00000");

        query = "SELECT * FROM transportunit ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(TransportUnitBean bean) {
        String query = "DELETE FROM transportunit WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query);
    }

    @Override
    public void delete(List<TransportUnitBean> beans) {
        for (TransportUnitBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(TransportUnitBean bean) {
        String query = "UPDATE transportunit SET "
                + "RegNumber = ?, "
                + "RouteId = ?, "
                + "TransportTypeId = ? "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query,
                bean.getRegNumber(),
                bean.getRouteId(),
                bean.getTransportTypeId(),
                bean.getId());
    }

    @Override
    public void update(List<TransportUnitBean> beans) {
        for (TransportUnitBean bean : beans) {
            update(bean);
        }
    }

    @Override
    public List<TransportUnitBean> fromResultSet(ResultSet rs) {
        List<TransportUnitBean> result = new ArrayList<TransportUnitBean>();
        try {
            while (rs.next()) {
                TransportUnitBean bean = new TransportUnitBean(rs.getInt("Id"));
                bean.setRegNumber(rs.getString("RegNumber"));
                bean.setRouteId(rs.getInt("RouteId"));
                bean.setTransportTypeId(rs.getInt("TransportTypeId"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTransportUnitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
