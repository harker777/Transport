package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class DistanceBean extends BaseBean {

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

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                DistanceBean b1 = (DistanceBean) o1;
                DistanceBean b2 = (DistanceBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getDistanceComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                DistanceBean b1 = (DistanceBean) o1;
                DistanceBean b2 = (DistanceBean) o2;
                return b1.getDistance().compareTo(b2.getDistance());
            }
        };
    }

    public static Comparator getStationFromIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                DistanceBean b1 = (DistanceBean) o1;
                DistanceBean b2 = (DistanceBean) o2;
                return b1.getStationFromId().compareTo(b2.getStationFromId());
            }
        };
    }

    public static Comparator getStationToIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                DistanceBean b1 = (DistanceBean) o1;
                DistanceBean b2 = (DistanceBean) o2;
                return b1.getStationToId().compareTo(b2.getStationToId());
            }
        };
    }
}
