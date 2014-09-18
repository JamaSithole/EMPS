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

/**
 *
 * @author bheki.lubisi
 */
@Entity
@Table(name = "directorate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directorate.findAll", query = "SELECT d FROM Directorate d"),
    @NamedQuery(name = "Directorate.findById", query = "SELECT d FROM Directorate d WHERE d.id = :id"),
    @NamedQuery(name = "Directorate.findByName", query = "SELECT d FROM Directorate d WHERE d.name = :name"),
    @NamedQuery(name = "Directorate.findByDept", query = "SELECT d FROM Directorate d WHERE d.deptid = :deptid"),
    @NamedQuery(name = "Directorate.findByDescription", query = "SELECT d FROM Directorate d WHERE d.description = :description")})
public class Directorate implements Serializable {
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
    @JoinColumn(name = "DEPTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Dept deptid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "directorateid")
    private Collection<Sectiontbl> sectiontblCollection;

    public Directorate() {
    }

    public Directorate(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directorate)) {
            return false;
        }
        Directorate other = (Directorate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Directorate[ id=" + id + " ]";
    }

	public Collection<Sectiontbl> getSectiontblCollection() {
		return sectiontblCollection;
	}

	public void setSectiontblCollection(Collection<Sectiontbl> sectiontblCollection) {
		this.sectiontblCollection = sectiontblCollection;
	}

	public Dept getDeptid() {
		return deptid;
	}

	public void setDeptid(Dept deptid) {
		this.deptid = deptid;
	}
    
}
