package ua.kpi.transport.db.entities;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author harker777
 */
public class TransportStopBean extends BaseBean {

    private Integer id;
    private Integer number;
    private Integer raceNumber;
    private Date stopTime;
    private Integer transportUnitId;
    private Integer stationId;

    public TransportStopBean(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.number != null ? this.number.hashCode() : 0);
        hash = 79 * hash + (this.stopTime != null ? this.stopTime.hashCode() : 0);
        hash = 79 * hash + (this.transportUnitId != null ? this.transportUnitId.hashCode() : 0);
        hash = 79 * hash + (this.stationId != null ? this.stationId.hashCode() : 0);
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getTransportUnitId() {
        return transportUnitId;
    }

    public void setTransportUnitId(Integer transportUnitId) {
        this.transportUnitId = transportUnitId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getNumberComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getNumber().compareTo(b2.getNumber());
            }
        };
    }

    public static Comparator getRaceNumberComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getRaceNumber().compareTo(b2.getRaceNumber());
            }
        };
    }

    public static Comparator getStopTimeComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getStopTime().compareTo(b2.getStopTime());
            }
        };
    }

    public static Comparator getTransportUnitIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getTransportUnitId().compareTo(b2.getTransportUnitId());
            }
        };
    }

    public static Comparator getStationIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportStopBean b1 = (TransportStopBean) o1;
                TransportStopBean b2 = (TransportStopBean) o2;
                return b1.getStationId().compareTo(b2.getStationId());
            }
        };
    }
}
