package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class RouteToStationBean extends BaseBean {

    private Integer id;
    private Integer stationNum;
    private Integer routeId;
    private Integer stationId;

    public RouteToStationBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStationNum() {
        return stationNum;
    }

    public void setStationNum(Integer stationNum) {
        this.stationNum = stationNum;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.stationNum != null ? this.stationNum.hashCode() : 0);
        hash = 17 * hash + (this.routeId != null ? this.routeId.hashCode() : 0);
        hash = 17 * hash + (this.stationId != null ? this.stationId.hashCode() : 0);
        return hash;
    }

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteToStationBean b1 = (RouteToStationBean) o1;
                RouteToStationBean b2 = (RouteToStationBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getStationNumComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteToStationBean b1 = (RouteToStationBean) o1;
                RouteToStationBean b2 = (RouteToStationBean) o2;
                return b1.getStationNum().compareTo(b2.getStationNum());
            }
        };
    }

    public static Comparator getRouteIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteToStationBean b1 = (RouteToStationBean) o1;
                RouteToStationBean b2 = (RouteToStationBean) o2;
                return b1.getRouteId().compareTo(b2.getRouteId());
            }
        };
    }

    public static Comparator getStationIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteToStationBean b1 = (RouteToStationBean) o1;
                RouteToStationBean b2 = (RouteToStationBean) o2;
                return b1.getStationId().compareTo(b2.getStationId());
            }
        };
    }
}
