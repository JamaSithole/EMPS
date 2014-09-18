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
@Table(name = "roleepms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleepms.findAll", query = "SELECT r FROM Roleepms r"),
    @NamedQuery(name = "Roleepms.findById", query = "SELECT r FROM Roleepms r WHERE r.id = :id"),
    @NamedQuery(name = "Roleepms.findByName", query = "SELECT r FROM Roleepms r WHERE r.name = :name"),
    @NamedQuery(name = "Roleepms.findByDescription", query = "SELECT r FROM Roleepms r WHERE r.description = :description")})
public class Roleepms implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<Userepms> userepmsCollection;

    public Roleepms() {
    }

    public Roleepms(Integer id) {
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
    public Collection<Userepms> getUserepmsCollection() {
        return userepmsCollection;
    }

    public void setUserepmsCollection(Collection<Userepms> userepmsCollection) {
        this.userepmsCollection = userepmsCollection;
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
        if (!(object instanceof Roleepms)) {
            return false;
        }
        Roleepms other = (Roleepms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Roleepms[ id=" + id + " ]";
    }
    
}
