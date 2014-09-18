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
@Table(name = "ndpltems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ndpltems.findAll", query = "SELECT n FROM Ndpltems n"),
    @NamedQuery(name = "Ndpltems.findById", query = "SELECT n FROM Ndpltems n WHERE n.id = :id"),
    @NamedQuery(name = "Ndpltems.findByName", query = "SELECT n FROM Ndpltems n WHERE n.name = :name"),
    @NamedQuery(name = "Ndpltems.findByNdp", query = "SELECT n FROM Ndpltems n WHERE n.ndpid = :ndpid"),
    @NamedQuery(name = "Ndpltems.findByDescription", query = "SELECT n FROM Ndpltems n WHERE n.description = :description")})
public class Ndpltems implements Serializable {
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
    @JoinColumn(name = "NDPID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ndp ndpid;

    public Ndpltems() {
    }

    public Ndpltems(Integer id) {
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

    public Ndp getNdpid() {
        return ndpid;
    }

    public void setNdpid(Ndp ndpid) {
        this.ndpid = ndpid;
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
        if (!(object instanceof Ndpltems)) {
            return false;
        }
        Ndpltems other = (Ndpltems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Ndpltems[ id=" + id + " ]";
    }
    
}
