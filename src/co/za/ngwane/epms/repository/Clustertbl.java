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
@Table(name = "clustertbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clustertbl.findAll", query = "SELECT c FROM Clustertbl c"),
    @NamedQuery(name = "Clustertbl.findById", query = "SELECT c FROM Clustertbl c WHERE c.id = :id"),
    @NamedQuery(name = "Clustertbl.findByName", query = "SELECT c FROM Clustertbl c WHERE c.name = :name"),
    @NamedQuery(name = "Clustertbl.findByDescription", query = "SELECT c FROM Clustertbl c WHERE c.description = :description")})
public class Clustertbl implements Serializable {
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
    @JoinColumn(name = "MUNICIPALID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Municipal municipalid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clusterid")
    private Collection<Cludept> cludeptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clusterid")
    private Collection<Dept> deptCollection;
    /*
    @JoinColumn(name = "PLANID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Plantbl planid;
    */


    public Clustertbl() {
    }

    public Clustertbl(Integer id) {
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

    public Municipal getMunicipalid() {
        return municipalid;
    }

    public void setMunicipalid(Municipal municipalid) {
        this.municipalid = municipalid;
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
        if (!(object instanceof Clustertbl)) {
            return false;
        }
        Clustertbl other = (Clustertbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Clustertbl[ id=" + id + " ]";
    }

	public Collection<Dept> getDeptCollection() {
		return deptCollection;
	}

	public void setDeptCollection(Collection<Dept> deptCollection) {
		this.deptCollection = deptCollection;
	}

	/*
	public Plantbl getPlanid() {
		return planid;
	}

	public void setPlanid(Plantbl planid) {
		this.planid = planid;
	}
    */
}
