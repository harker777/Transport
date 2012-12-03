package ua.kpi.transport.db.dao;

import ua.kpi.transport.db.entities.BaseBean;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author harker777
 */
public interface EntityDAO<T extends BaseBean> {
    
    public T find(Integer id);

    public List<T> findAll();

    public T create();
    
    public void delete(T bean);
    
    public void delete(T ... beans);

    public void update(T bean);
    
    public void update(T ... beans);

    public List<T> fromResultSet(ResultSet rs);
}