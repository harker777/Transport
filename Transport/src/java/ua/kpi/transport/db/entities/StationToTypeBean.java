package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class StationToTypeBean extends BaseBean {

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

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                StationToTypeBean b1 = (StationToTypeBean) o1;
                StationToTypeBean b2 = (StationToTypeBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getTransportTypeIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                StationToTypeBean b1 = (StationToTypeBean) o1;
                StationToTypeBean b2 = (StationToTypeBean) o2;
                return b1.getTransportTypeId().compareTo(b2.getTransportTypeId());
            }
        };
    }

    public static Comparator getStationIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                StationToTypeBean b1 = (StationToTypeBean) o1;
                StationToTypeBean b2 = (StationToTypeBean) o2;
                return b1.getStationId().compareTo(b2.getStationId());
            }
        };
    }
}
