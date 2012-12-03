package ua.kpi.transport.db.entities;

/**
 *
 * @author harker777
 */
public class RouteBean extends BaseBean {
    
    private Integer id;
    private String name;

    public RouteBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    
}
