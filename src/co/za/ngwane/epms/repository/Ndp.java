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
@Table(name = "ndp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ndp.findAll", query = "SELECT n FROM Ndp n"),
    @NamedQuery(name = "Ndp.findById", query = "SELECT n FROM Ndp n WHERE n.id = :id"),
    @NamedQuery(name = "Ndp.findByName", query = "SELECT n FROM Ndp n WHERE n.name = :name"),
    @NamedQuery(name = "Ndp.findByDescription", query = "SELECT n FROM Ndp n WHERE n.description = :description")})
public class Ndp implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ndpid")
    private Collection<Ndpltems> ndpltemsCollection;

    public Ndp() {
    }

    public Ndp(Integer id) {
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
    public Collection<Ndpltems> getNdpltemsCollection() {
        return ndpltemsCollection;
    }

    public void setNdpltemsCollection(Collection<Ndpltems> ndpltemsCollection) {
        this.ndpltemsCollection = ndpltemsCollection;
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
        if (!(object instanceof Ndp)) {
            return false;
        }
        Ndp other = (Ndp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Ndp[ id=" + id + " ]";
    }
    
}
