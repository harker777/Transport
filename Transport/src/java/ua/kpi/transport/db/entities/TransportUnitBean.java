package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class TransportUnitBean extends BaseBean {

    private Integer id;
    private String regNumber;
    private Integer transportTypeId;
    private Integer routeId;

    public TransportUnitBean(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.regNumber != null ? this.regNumber.hashCode() : 0);
        hash = 37 * hash + (this.transportTypeId != null ? this.transportTypeId.hashCode() : 0);
        hash = 37 * hash + (this.routeId != null ? this.routeId.hashCode() : 0);
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportUnitBean b1 = (TransportUnitBean) o1;
                TransportUnitBean b2 = (TransportUnitBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getRegNumberComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportUnitBean b1 = (TransportUnitBean) o1;
                TransportUnitBean b2 = (TransportUnitBean) o2;
                return b1.getRegNumber().compareTo(b2.getRegNumber());
            }
        };
    }

    public static Comparator getTransportTypeIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportUnitBean b1 = (TransportUnitBean) o1;
                TransportUnitBean b2 = (TransportUnitBean) o2;
                return b1.getTransportTypeId().compareTo(b2.getTransportTypeId());
            }
        };
    }

    public static Comparator getRouteIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportUnitBean b1 = (TransportUnitBean) o1;
                TransportUnitBean b2 = (TransportUnitBean) o2;
                return b1.getRouteId().compareTo(b2.getRouteId());
            }
        };
    }
}
