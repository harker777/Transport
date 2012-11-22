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
@Table(name = "transportunit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransportUnit.findAll", query = "SELECT t FROM TransportUnit t"),
    @NamedQuery(name = "TransportUnit.findById", query = "SELECT t FROM TransportUnit t WHERE t.id = :id"),
    @NamedQuery(name = "TransportUnit.findByRegNumber", query = "SELECT t FROM TransportUnit t WHERE t.regNumber = :regNumber")})
public class TransportUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "RegNumber", length = 10)
    private String regNumber;
    @JoinColumn(name = "TransportTypeId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TransportType transportTypeId;
    @JoinColumn(name = "RouteId", referencedColumnName = "Id")
    @ManyToOne
    private Route routeId;
    @OneToMany(mappedBy = "transportUnitId")
    private Collection<TransportStop> transportStopCollection;

    public TransportUnit() {
    }

    public TransportUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public TransportType getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(TransportType transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
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
        if (!(object instanceof TransportUnit)) {
            return false;
        }
        TransportUnit other = (TransportUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransportUnit[ id=" + id + " ]";
    }
    
}
