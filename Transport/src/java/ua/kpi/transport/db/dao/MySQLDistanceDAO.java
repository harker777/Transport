/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.interfaces.IDistanceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.DistanceBean;

/**
 *
 * @author harker777
 */
public class MySQLDistanceDAO implements IDistanceDAO{

    @Override
    public DistanceBean find(Integer id) {
        String query = "SELECT * FROM distance WHERE (Id = ?)";
        ResultSet rs = MySQLQueryExecutioner.execute(query, id);
        return fromResultSet(rs).get(0);
    }

    @Override
    public List<DistanceBean> findAll() {
        String query = "SELECT * FROM distance";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs);
    }

    @Override
    public DistanceBean create() {
        String query = ""
                + "INSERT INTO distance "
                + "VALUES (NULL,NULL,NULL,?)";
        MySQLQueryExecutioner.executeUpdate(query, 1);
        
        query = "SELECT * FROM distance ORDER BY Id DESC";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(DistanceBean bean) {
        String query = ""
                + "DELETE FROM distance "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query, bean.getId());
    }

    @Override
    public void delete(List<DistanceBean> beans) {
        for (DistanceBean bean : beans){
            delete(bean);
        }
    }

    @Override
    public void update(DistanceBean bean) {
        String query = ""
                + "UPDATE distance "
                + "SET StationFromId = ?, "
                + "    StationToId = ?, "
                + "    Distance = ? "
                + "WHERE Id = ?";
        MySQLQueryExecutioner.executeUpdate(query,
                bean.getStationFromId(),
                bean.getStationToId(),
                bean.getDistance(),
                bean.getId());
    }

    @Override
    public void update(List<DistanceBean> beans) {
        for (DistanceBean bean : beans){
            update(bean);
        }
    }

    @Override
    public List<DistanceBean> fromResultSet(ResultSet rs) {
        List<DistanceBean> result = new ArrayList<DistanceBean>();
        try {
            while (rs.next()){
                DistanceBean bean = new DistanceBean(rs.getInt("Id"));
                bean.setDistance(rs.getInt("Distance"));
                bean.setStationFromId(rs.getInt("StationFromId"));
                bean.setStationToId(rs.getInt("StationToId"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDistanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
