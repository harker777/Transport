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
@Table(name = "station")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s"),
    @NamedQuery(name = "Station.findById", query = "SELECT s FROM Station s WHERE s.id = :id"),
    @NamedQuery(name = "Station.findByName", query = "SELECT s FROM Station s WHERE s.name = :name"),
    @NamedQuery(name = "Station.findByLongitude", query = "SELECT s FROM Station s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Station.findByLattitude", query = "SELECT s FROM Station s WHERE s.lattitude = :lattitude")})
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Name", length = 50)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Longitude", precision = 12)
    private Float longitude;
    @Column(name = "Lattitude", precision = 12)
    private Float lattitude;
    @OneToMany(mappedBy = "stationId")
    private Collection<StationToType> stationToTypeCollection;
    @OneToMany(mappedBy = "station2")
    private Collection<Distance> distanceCollection;
    @OneToMany(mappedBy = "station1")
    private Collection<Distance> distanceCollection1;
    @OneToMany(mappedBy = "stationId")
    private Collection<RouteToStation> routeToStationCollection;

    public Station() {
    }

    public Station(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLattitude() {
        return lattitude;
    }

    public void setLattitude(Float lattitude) {
        this.lattitude = lattitude;
    }

    @XmlTransient
    public Collection<StationToType> getStationToTypeCollection() {
        return stationToTypeCollection;
    }

    public void setStationToTypeCollection(Collection<StationToType> stationToTypeCollection) {
        this.stationToTypeCollection = stationToTypeCollection;
    }

    @XmlTransient
    public Collection<Distance> getDistanceCollection() {
        return distanceCollection;
    }

    public void setDistanceCollection(Collection<Distance> distanceCollection) {
        this.distanceCollection = distanceCollection;
    }

    @XmlTransient
    public Collection<Distance> getDistanceCollection1() {
        return distanceCollection1;
    }

    public void setDistanceCollection1(Collection<Distance> distanceCollection1) {
        this.distanceCollection1 = distanceCollection1;
    }

    @XmlTransient
    public Collection<RouteToStation> getRouteToStationCollection() {
        return routeToStationCollection;
    }

    public void setRouteToStationCollection(Collection<RouteToStation> routeToStationCollection) {
        this.routeToStationCollection = routeToStationCollection;
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
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Station[ id=" + id + " ]";
    }
    
}
