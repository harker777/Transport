/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.dao.interfaces.ITransportTypeDAO;
import ua.kpi.transport.db.dao.utils.MySQLQueryExecutioner;
import ua.kpi.transport.db.entities.BaseBean;
import ua.kpi.transport.db.entities.TransportTypeBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harker777
 */
public class MySQLTransportTypeDAO implements ITransportTypeDAO {

    @Override
    public TransportTypeBean find(Integer id) {
        String query = "SELECT * FROM transporttype WHERE Id = ?";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{id});

        return fromResultSet(rs).get(0);
    }

    @Override
    public List<TransportTypeBean> findAll() {
        String query = "SELECT * FROM transporttype ORDER BY Id ASC";
        ResultSet rs = MySQLQueryExecutioner.execute(
                query, new Object[]{});

        return fromResultSet(rs);
    }

    @Override
    public TransportTypeBean create() {
        String query = "INSERT INTO transporttype (Name) VALUES (?)";
        MySQLQueryExecutioner.executeUpdate(query, new Object[]{"Name"});

        query = "SELECT * FROM transporttype ORDER BY Id DESC LIMIT 1";
        ResultSet rs = MySQLQueryExecutioner.execute(query, new Object[]{});

        return fromResultSet(rs).get(0);
    }

    @Override
    public void delete(TransportTypeBean bean) {
        String query = "DELETE FROM transporttype WHERE Id = ?";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[]{bean.getId()});
    }

    @Override
    public void delete(List<TransportTypeBean> beans) {
        for (TransportTypeBean bean : beans) {
            delete(bean);
        }
    }

    @Override
    public void update(TransportTypeBean bean) {
        String query = ""
                + "UPDATE TABLE transporttype "
                + "SET Name = ? "
                + "WHERE (Id = ?)";
        MySQLQueryExecutioner.executeUpdate(
                query, new Object[] {bean.getName(),bean.getId()});
    }

    @Override
    public void update(List<TransportTypeBean> beans) {
        for (TransportTypeBean bean : beans){
            update(bean);
        }
    }

    @Override
    public List<TransportTypeBean> fromResultSet(ResultSet rs) {
        ArrayList<TransportTypeBean> res = new ArrayList<TransportTypeBean>();
        try {
            while (rs.next()) {
                TransportTypeBean b = new TransportTypeBean(rs.getInt("Id"));
                b.setName(rs.getString("Name"));
                res.add(b);
            }
        } catch (SQLException ex) {
            //TODO: Log
            System.out.println("Cannot get TransportTypeBean");
        }
        return res;
    }
}
