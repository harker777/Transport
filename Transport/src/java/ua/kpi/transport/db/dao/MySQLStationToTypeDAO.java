package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.entities.StationToTypeBean;

/**
 *
 * @author harker777
 */
public class MySQLStationToTypeDAO implements IStationToTypeDAO {

    @Override
    public StationToTypeBean find(Integer id) {
        String query = "SELECT * FROM stationtotype WHERE Id = ?";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{id});
        return fromResultSet(rs).get(0);
    }

    @Override
    public List<StationToTypeBean> findAll() {
        String query = "SELECT * FROM stationtotype ORDER BY Id ASC";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});
        return fromResultSet(rs);
    }

    @Override
    public StationToTypeBean create() {
        String query = "INSERT INTO stationtotype VALUES (NULL,NUll,NULL)";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[]{});

        query = "SELECT * FROM stationtotype ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(StationToTypeBean bean) {
        String query = "DELETE FROM stationtotype WHERE Id = ?";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[]{bean.getId()});
    }

    @Override
    public void delete(List<StationToTypeBean> beans) {
        for (StationToTypeBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(StationToTypeBean bean) {
        String query = ""
                + "UPDATE stationtotype "
                + "SET StationId = ?, "
                + "    TransportTypeId = ? "
                + "WHERE Id = ?";
        MySQLQueryExecutioner.executeUpdate(
                query,
                new Object[]{
                    bean.getStationId(),
                    bean.getTransportTypeId(),
                    bean.getId()});
    }

    @Override
    public void update(List<StationToTypeBean> beans) {
        for (StationToTypeBean bean : beans){
            update(bean);
        }
    }

    @Override
    public List<StationToTypeBean> fromResultSet(ResultSet rs) {
        List<StationToTypeBean> result = new ArrayList<StationToTypeBean>();
        try {
            while (rs.next()) {
                StationToTypeBean bean = new StationToTypeBean(rs.getInt("Id"));
                bean.setStationId(rs.getInt("StationId"));
                bean.setTransportTypeId(rs.getInt("TransportTypeId"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLStationToTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
