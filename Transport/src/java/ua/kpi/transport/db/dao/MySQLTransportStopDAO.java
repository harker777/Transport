/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.transport.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.dao.interfaces.ITransportStopDAO;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.TransportStopBean;

/**
 *
 * @author harker777
 */
public class MySQLTransportStopDAO implements ITransportStopDAO{

    @Override
    public TransportStopBean find(Integer id) {
        String query = "SELECT * FROM transportstop WHERE id = ?";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, id);

        return fromResultSet(rs).get(0);
    }

    @Override
    public List<TransportStopBean> findAll() {
        String query = "SELECT * FROM transportstop ORDER BY Id ASC";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query);

        return fromResultSet(rs);
    }

    @Override
    public TransportStopBean create() {
        String query = "INSERT INTO transportstop VALUES (NULL,NULL,NULL,NULL,NULL,NULL)";
        MySQLQueryExecutioner.executeUpdate(
                query);

        query = "SELECT * FROM transportstop ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(TransportStopBean bean) {
        String query = "DELETE FROM transportstop WHERE id = ?";
        MySQLQueryExecutioner.executeUpdate(
                query, bean.getId());
    }

    @Override
    public void delete(List<TransportStopBean> beans) {
        for (TransportStopBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(TransportStopBean bean) {
        String query = "UPDATE transportstop SET "
                + "Number = ?, "
                + "RaceNumber = ?, "
                + "StatioId = ?, "
                + "StopTime = ?, "
                + "TransportUnitId = ? "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(
                query,
                bean.getNumber(),
                bean.getRaceNumber(),
                bean.getStationId(),
                bean.getStopTime(),
                bean.getTransportUnitId(),
                bean.getId());
    }

    @Override
    public void update(List<TransportStopBean> beans) {
        for (TransportStopBean bean : beans) {
            update(bean);
        }
    }

    @Override
    public List<TransportStopBean> fromResultSet(ResultSet rs) {
        List<TransportStopBean> result = new ArrayList<TransportStopBean>();
        try {
            while(rs.next()){
                TransportStopBean bean = new TransportStopBean(rs.getInt("Id"));
                bean.setNumber(rs.getInt("Number"));
                bean.setRaceNumber(rs.getInt("RaceNumber"));
                bean.setStationId(rs.getInt("StationId"));
                bean.setStopTime(rs.getDate("StopTime"));
                bean.setTransportUnitId(rs.getInt("TransportUnitId"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTransportStopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}
