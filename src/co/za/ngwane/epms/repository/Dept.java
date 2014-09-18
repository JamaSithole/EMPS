/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author bheki.lubisi
 */
@Entity
@Table(name = "dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d"),
    @NamedQuery(name = "Dept.findById", query = "SELECT d FROM Dept d WHERE d.id = :id"),
    @NamedQuery(name = "Dept.findByName", query = "SELECT d FROM Dept d WHERE d.name = :name"),
    @NamedQuery(name = "Dept.findByCluster", query = "SELECT d FROM Dept d WHERE d.clusterid = :clusterid"),
    @NamedQuery(name = "Dept.findByDescription", query = "SELECT d FROM Dept d WHERE d.description = :description")})
public class Dept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Cludept> cludeptCollection;
    @JoinColumn(name = "CLUSTERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clustertbl clusterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Directorate> directorateCollection;

    public Dept() {
    }

    public Dept(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Cludept> getCludeptCollection() {
        return cludeptCollection;
    }

    public void setCludeptCollection(Collection<Cludept> cludeptCollection) {
        this.cludeptCollection = cludeptCollection;
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
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Dept[ id=" + id + " ]";
    }

	public Clustertbl getClusterid() {
		return clusterid;
	}

	public void setClusterid(Clustertbl clusterid) {
		this.clusterid = clusterid;
	}

	public Collection<Directorate> getDirectorateCollection() {
		return directorateCollection;
	}

	public void setDirectorateCollection(
			Collection<Directorate> directorateCollection) {
		this.directorateCollection = directorateCollection;
	}
    
}
