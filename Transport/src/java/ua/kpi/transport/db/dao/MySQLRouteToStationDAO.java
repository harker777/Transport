/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.interfaces.IRouteToStationDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.RouteToStationBean;

/**
 *
 * @author harker777
 */
public class MySQLRouteToStationDAO implements IRouteToStationDAO{

    @Override
    public RouteToStationBean find(Integer id) {
        String query = "SELECT * FROM routetostation WHERE (Id = ?) LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query, id);
        return fromResultSet(rs).get(0);
    }

    @Override
    public List<RouteToStationBean> findAll() {
        String query = "SELECT * FROM routetostation";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs);
    }

    @Override
    public RouteToStationBean create() {
        String query = "INSERT INTO routetostation VALUES "
                + "(NULL, NULL, NULL, NULL)";
        MySQLQueryExecutioner.executeUpdate(query);

        query = "SELECT * FROM routetostation ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query);
        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(RouteToStationBean bean) {
        String query = "DELETE FROM routetostation WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query, bean.getId());
    }

    @Override
    public void delete(List<RouteToStationBean> beans) {
        for (RouteToStationBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(RouteToStationBean bean) {
        String query = ""
                + "UPDATE routetostation SET "
                + "RouteId = ?, StationId = ?, StationNum = ? "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(query,
                bean.getRouteId(),
                bean.getStationId(),
                bean.getStationNum());
    }

    @Override
    public void update(List<RouteToStationBean> beans) {
        for (RouteToStationBean bean : beans){
            update(bean);
        }
    }

    @Override
    public List<RouteToStationBean> fromResultSet(ResultSet rs) {
        List<RouteToStationBean> result = new ArrayList<RouteToStationBean>();
        try {
            while(rs.next()){
                RouteToStationBean bean = new RouteToStationBean(rs.getInt("Id"));
                bean.setRouteId(rs.getInt("RouteId"));
                bean.setStationId(rs.getInt("StationId"));
                bean.setStationNum(rs.getInt("StationNum"));
                result.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRouteToStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
