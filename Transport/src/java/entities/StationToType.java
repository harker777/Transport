/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harker777
 */
@Entity
@Table(name = "stationtotype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StationToType.findAll", query = "SELECT s FROM StationToType s"),
    @NamedQuery(name = "StationToType.findById", query = "SELECT s FROM StationToType s WHERE s.id = :id")})
public class StationToType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @JoinColumn(name = "TransportTypeId", referencedColumnName = "Id")
    @ManyToOne
    private TransportType transportTypeId;
    @JoinColumn(name = "StationId", referencedColumnName = "Id")
    @ManyToOne
    private Station stationId;

    public StationToType() {
    }

    public StationToType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransportType getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(TransportType transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
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
        if (!(object instanceof StationToType)) {
            return false;
        }
        StationToType other = (StationToType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StationToType[ id=" + id + " ]";
    }
    
}
