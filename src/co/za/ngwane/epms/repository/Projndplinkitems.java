/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bheki.Lubisi
 */
@Entity
@Table(name = "projndplinkitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projndplinkitems.findAll", query = "SELECT p FROM Projndplinkitems p"),
    @NamedQuery(name = "Projndplinkitems.findById", query = "SELECT p FROM Projndplinkitems p WHERE p.id = :id"),
	@NamedQuery(name = "Projndplinkitems.findByProject", query = "SELECT p FROM Projndplinkitems p WHERE p.projtblid = :projtblid")})
public class Projndplinkitems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "PROJTBLID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Projtbl projtblid;
    @JoinColumn(name = "NDPLTEMSID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ndpltems ndpltemsid;

    public Projndplinkitems() {
    }

    public Projndplinkitems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Projtbl getProjtblid() {
        return projtblid;
    }

    public void setProjtblid(Projtbl projtblid) {
        this.projtblid = projtblid;
    }

    public Ndpltems getNdpltemsid() {
        return ndpltemsid;
    }

    public void setNdpltemsid(Ndpltems ndpltemsid) {
        this.ndpltemsid = ndpltemsid;
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
        if (!(object instanceof Projndplinkitems)) {
            return false;
        }
        Projndplinkitems other = (Projndplinkitems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Projndplinkitems[ id=" + id + " ]";
    }
    
}
