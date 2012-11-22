/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harker777
 */
@Entity
@Table(name = "transportstop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransportStop.findAll", query = "SELECT t FROM TransportStop t"),
    @NamedQuery(name = "TransportStop.findById", query = "SELECT t FROM TransportStop t WHERE t.id = :id"),
    @NamedQuery(name = "TransportStop.findByNumber", query = "SELECT t FROM TransportStop t WHERE t.number = :number"),
    @NamedQuery(name = "TransportStop.findByTime", query = "SELECT t FROM TransportStop t WHERE t.time = :time")})
public class TransportStop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Number")
    private Integer number;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "TransportUnitId", referencedColumnName = "Id")
    @ManyToOne
    private TransportUnit transportUnitId;
    @JoinColumn(name = "RouteToStationId", referencedColumnName = "Id")
    @ManyToOne
    private RouteToStation routeToStationId;

    public TransportStop() {
    }

    public TransportStop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public TransportUnit getTransportUnitId() {
        return transportUnitId;
    }

    public void setTransportUnitId(TransportUnit transportUnitId) {
        this.transportUnitId = transportUnitId;
    }

    public RouteToStation getRouteToStationId() {
        return routeToStationId;
    }

    public void setRouteToStationId(RouteToStation routeToStationId) {
        this.routeToStationId = routeToStationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportStop)) {
            return false;
        }
        TransportStop other = (TransportStop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransportStop[ id=" + id + " ]";
    }
    
}
