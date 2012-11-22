/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author harker777
 */
@Entity
@Table(name = "routetostation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteToStation.findAll", query = "SELECT r FROM RouteToStation r"),
    @NamedQuery(name = "RouteToStation.findById", query = "SELECT r FROM RouteToStation r WHERE r.id = :id"),
    @NamedQuery(name = "RouteToStation.findByStationNum", query = "SELECT r FROM RouteToStation r WHERE r.stationNum = :stationNum")})
public class RouteToStation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "StationNum")
    private Integer stationNum;
    @JoinColumn(name = "RouteId", referencedColumnName = "Id")
    @ManyToOne
    private Route routeId;
    @JoinColumn(name = "StationId", referencedColumnName = "Id")
    @ManyToOne
    private Station stationId;
    @OneToMany(mappedBy = "routeToStationId")
    private Collection<TransportStop> transportStopCollection;

    public RouteToStation() {
    }

    public RouteToStation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationNum() {
        return stationNum;
    }

    public void setStationNum(Integer stationNum) {
        this.stationNum = stationNum;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
    }

    @XmlTransient
    public Collection<TransportStop> getTransportStopCollection() {
        return transportStopCollection;
    }

    public void setTransportStopCollection(Collection<TransportStop> transportStopCollection) {
        this.transportStopCollection = transportStopCollection;
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
        if (!(object instanceof RouteToStation)) {
            return false;
        }
        RouteToStation other = (RouteToStation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RouteToStation[ id=" + id + " ]";
    }
    
}
