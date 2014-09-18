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
 * @author bheki.lubisi
 */
@Entity
@Table(name = "cludept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cludept.findAll", query = "SELECT c FROM Cludept c"),
    @NamedQuery(name = "Cludept.findById", query = "SELECT c FROM Cludept c WHERE c.id = :id")})
public class Cludept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "DEPTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Dept deptid;
    @JoinColumn(name = "CLUSTERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clustertbl clusterid;

    public Cludept() {
    }

    public Cludept(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dept getDeptid() {
        return deptid;
    }

    public void setDeptid(Dept deptid) {
        this.deptid = deptid;
    }

    public Clustertbl getClusterid() {
        return clusterid;
    }

    public void setClusterid(Clustertbl clusterid) {
        this.clusterid = clusterid;
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
        if (!(object instanceof Cludept)) {
            return false;
        }
        Cludept other = (Cludept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Cludept[ id=" + id + " ]";
    }
    
}
