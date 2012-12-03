package ua.kpi.transport.db.entities;

/**
 *
 * @author harker777
 */
public class StationBean extends BaseBean {

    private Integer id;
    private String name;
    private Float longitude;
    private Float lattitude;

    public StationBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLattitude() {
        return lattitude;
    }

    public void setLattitude(Float lattitude) {
        this.lattitude = lattitude;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 47 * hash + (this.lattitude != null ? this.lattitude.hashCode() : 0);
        return hash;
    }
}
