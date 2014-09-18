/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bheki.Lubisi
 */
@Entity
@Table(name = "sysmod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sysmod.findAll", query = "SELECT s FROM Sysmod s"),
    @NamedQuery(name = "Sysmod.findById", query = "SELECT s FROM Sysmod s WHERE s.id = :id"),
    @NamedQuery(name = "Sysmod.findByCode", query = "SELECT s FROM Sysmod s WHERE s.code = :code"),
    @NamedQuery(name = "Sysmod.findByDescription", query = "SELECT s FROM Sysmod s WHERE s.description = :description"),
    @NamedQuery(name = "Sysmod.findByStatus", query = "SELECT s FROM Sysmod s WHERE s.status = :status")})
public class Sysmod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "module")
    private Collection<Usermod> usermodCollection;
    
    @Transient
    private Boolean isAdded;

    public Sysmod() {
    }

    public Sysmod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Usermod> getUsermodCollection() {
        return usermodCollection;
    }

    public void setUsermodCollection(Collection<Usermod> usermodCollection) {
        this.usermodCollection = usermodCollection;
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
        if (!(object instanceof Sysmod)) {
            return false;
        }
        Sysmod other = (Sysmod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Sysmod[ id=" + id + " ]";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 @Transient
	public Boolean getIsAdded() {
		return isAdded;
	}
	 
	@Transient
	public void setIsAdded(Boolean isAdded) {
		this.isAdded = isAdded;
	}
    
}
