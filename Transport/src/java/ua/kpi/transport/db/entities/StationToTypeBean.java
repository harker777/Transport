package ua.kpi.transport.db.entities;

/**
 *
 * @author harker777
 */
public class StationToTypeBean extends BaseBean{

    private Integer id;
    private Integer transportTypeId;
    private Integer stationId;

    public StationToTypeBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof StationToTypeBean)) {
            return false;
        }

        StationToTypeBean other = (StationToTypeBean) object;
        return (this.getId().equals(other.getId())&&
                this.getStationId().equals(other.getStationId())&&
                this.getTransportTypeId().equals(other.getTransportTypeId()));
    }

    @Override
    public String toString() {
        return "Entity - StationType:\n"
                + "Id - " + getId() + "\n"
                + "StationId - " + getStationId() + "\n"
                + "TransportTypeId - " + getTransportTypeId() + "\n";
    }
}
