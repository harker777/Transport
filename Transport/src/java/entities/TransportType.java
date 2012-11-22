/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "transporttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransportType.findAll", query = "SELECT t FROM TransportType t"),
    @NamedQuery(name = "TransportType.findByName", query = "SELECT t FROM TransportType t WHERE t.name = :name"),
    @NamedQuery(name = "TransportType.findById", query = "SELECT t FROM TransportType t WHERE t.id = :id")})
public class TransportType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Name", length = 30)
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportTypeId")
    private Collection<TransportUnit> transportUnitCollection;
    @OneToMany(mappedBy = "transportTypeId")
    private Collection<StationToType> stationToTypeCollection;

    public TransportType() {
    }

    public TransportType(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<TransportUnit> getTransportUnitCollection() {
        return transportUnitCollection;
    }

    public void setTransportUnitCollection(Collection<TransportUnit> transportUnitCollection) {
        this.transportUnitCollection = transportUnitCollection;
    }

    @XmlTransient
    public Collection<StationToType> getStationToTypeCollection() {
        return stationToTypeCollection;
    }

    public void setStationToTypeCollection(Collection<StationToType> stationToTypeCollection) {
        this.stationToTypeCollection = stationToTypeCollection;
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
        if (!(object instanceof TransportType)) {
            return false;
        }
        TransportType other = (TransportType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransportType[ id=" + id + " ]";
    }
    
}
