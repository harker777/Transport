package ua.kpi.transport.db.entities;

/**
 *
 * @author harker777
 */
public class TransportTypeBean extends BaseBean{

    private String name;
    private Integer id;

    public TransportTypeBean(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
