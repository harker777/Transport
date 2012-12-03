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
        int hash = 5;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 11 * hash + (this.transportTypeId != null ? this.transportTypeId.hashCode() : 0);
        hash = 11 * hash + (this.stationId != null ? this.stationId.hashCode() : 0);
        return hash;
    }

}
