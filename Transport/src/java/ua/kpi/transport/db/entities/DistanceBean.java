package ua.kpi.transport.db.entities;

/**
 *
 * @author harker777
 */
public class DistanceBean extends BaseBean{
    
    private Integer id;
    private Integer distance;
    private Integer stationFromId;
    private Integer stationToId;

    public DistanceBean(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.distance != null ? this.distance.hashCode() : 0);
        hash = 97 * hash + (this.stationFromId != null ? this.stationFromId.hashCode() : 0);
        hash = 97 * hash + (this.stationToId != null ? this.stationToId.hashCode() : 0);
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getStationFromId() {
        return stationFromId;
    }

    public void setStationFromId(Integer stationFromId) {
        this.stationFromId = stationFromId;
    }

    public Integer getStationToId() {
        return stationToId;
    }

    public void setStationToId(Integer stationToId) {
        this.stationToId = stationToId;
    }
}
