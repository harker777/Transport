package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.entities.StationBean;
import ua.kpi.transport.db.entities.TransportTypeBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harker777
 */
public class MySQLStationDAO implements StationDAO {

    @Override
    public StationBean find(Integer id) {
        String query = "SELECT * FROM station WHERE id = ?";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{id});

        return fromResultSet(rs).get(0);
    }

    @Override
    public List<StationBean> findAll() {
        String query = "SELECT * FROM station ORDER BY Id ASC";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});

        return fromResultSet(rs);
    }

    @Override
    public StationBean findByName(String name) {
        String query = "SELECT * FROM station WHERE Name = ? LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{name});

        return fromResultSet(rs).get(0);
    }

    @Override
    public StationBean create() {
        String query = "INSERT INTO station (Name,Lattitude,Longitude) VALUES (?,?,?)";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[]{"Name", 0.0F, 0.0F});

        query = "SELECT * FROM station ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(StationBean bean) {
        String query = "DELETE FROM station WHERE id = ?";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[]{bean.getId()});
    }

    @Override
    public void update(StationBean bean) {
        String query = "UPDATE station SET Name = ?, Lattitude = ?, Longitude = ? WHERE Id = ?";
        Object[] data = {
            bean.getName(),
            bean.getLattitude(),
            bean.getLongitude(),
            bean.getId()};
        MySQLQueryExecutioner.executeUpdate(
                query, data);
    }

    @Override
    public void delete(StationBean... beans) {
        for (StationBean bean : beans) {
            delete(bean);
        }
    }

    private PreparedStatement prepareStatement(String query) {
        try {
            return MySQLDAOFactory.getConnection().prepareStatement(query);
        } catch (SQLException ex) {
            //TODO: Log
        }
        return null;
    }

    @Override
    public void update(StationBean... beans) {
        for (StationBean bean : beans) {
            update(bean);
        }
    }

    @Override
    public List<StationBean> findByType(TransportTypeBean type) {
        String query = ""
                + "SELECT "
                + "  station.Id Id, "
                + "  station.Name Name, "
                + "  station.Lattitude Lattitude, "
                + "  station.Longitude Longitude "
                + "FROM"
                + "  station, transporttype, stationtotype "
                + "WHERE "
                + "(transporttype.Id = ?) AND "
                + "(stationtotype.StationId = station.Id) AND "
                + "(stationtotype.TransportTypeId = transporttype.Id)";

        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{type.getId()});
        return fromResultSet(rs);
    }
    
    @Override
    public List<StationBean> fromResultSet(ResultSet rs) {
        ArrayList<StationBean> res = new ArrayList<StationBean>();
        try {
            while (rs.next()) {
                StationBean sb = new StationBean(rs.getInt("Id"));
                sb.setName(rs.getString("Name"));
                sb.setLattitude(rs.getFloat("Lattitude"));
                sb.setLongitude(rs.getFloat("Longitude"));
                res.add(sb);
            }
        } catch (SQLException ex) {
            //TODO: Log
            System.out.println("Cannot get StationBean");
        }
        return res;
    }

}
