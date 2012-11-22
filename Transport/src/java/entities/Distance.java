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
@Table(name = "distance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distance.findAll", query = "SELECT d FROM Distance d"),
    @NamedQuery(name = "Distance.findById", query = "SELECT d FROM Distance d WHERE d.id = :id"),
    @NamedQuery(name = "Distance.findByDistance", query = "SELECT d FROM Distance d WHERE d.distance = :distance")})
public class Distance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Distance")
    private Integer distance;
    @JoinColumn(name = "Station2", referencedColumnName = "Id")
    @ManyToOne
    private Station station2;
    @JoinColumn(name = "Station1", referencedColumnName = "Id")
    @ManyToOne
    private Station station1;

    public Distance() {
    }

    public Distance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Station getStation2() {
        return station2;
    }

    public void setStation2(Station station2) {
        this.station2 = station2;
    }

    public Station getStation1() {
        return station1;
    }

    public void setStation1(Station station1) {
        this.station1 = station1;
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
        if (!(object instanceof Distance)) {
            return false;
        }
        Distance other = (Distance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Distance[ id=" + id + " ]";
    }
    
}
