package ua.kpi.transport.db.entities;

import java.util.Date;

/**
 *
 * @author harker777
 */
public class TransportStopBean extends BaseBean {

    private Integer id;
    private Integer number;
    private Date stopTime;
    private Integer transportUnitId;
    private Integer routeToStationId;

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
        hash = 79 * hash + (this.routeToStationId != null ? this.routeToStationId.hashCode() : 0);
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

    public Integer getRouteToStationId() {
        return routeToStationId;
    }

    public void setRouteToStationId(Integer routeToStationId) {
        this.routeToStationId = routeToStationId;
    }
    
}
