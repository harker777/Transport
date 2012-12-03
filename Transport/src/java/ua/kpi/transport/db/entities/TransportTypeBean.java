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
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof TransportTypeBean)) {
            return false;
        }
        TransportTypeBean other = (TransportTypeBean) object;
        
        return (this.getId().equals(other.getId())) && 
                (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "\nEntity - TransportType:\n"
                + "Id - " + getId() + "\n"
                + "Name - " + getName() + "\n";
    }
}
