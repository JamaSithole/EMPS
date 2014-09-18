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
@Table(name = "usermod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usermod.findAll", query = "SELECT u FROM Usermod u"),
    @NamedQuery(name = "Usermod.findByUser", query = "SELECT u FROM Usermod u WHERE u.user = :user"),
    @NamedQuery(name = "Usermod.findById", query = "SELECT u FROM Usermod u WHERE u.id = :id")})
public class Usermod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "MODULE", referencedColumnName = "ID")
    @ManyToOne
    private Sysmod module;
    @JoinColumn(name = "user", referencedColumnName = "ID")
    @ManyToOne
    private Userepms user;

    public Usermod() {
    }

    public Usermod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sysmod getModule() {
        return module;
    }

    public void setModule(Sysmod module) {
        this.module = module;
    }

    public Userepms getUser() {
        return user;
    }

    public void setUser(Userepms user) {
        this.user = user;
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
        if (!(object instanceof Usermod)) {
            return false;
        }
        Usermod other = (Usermod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Usermod[ id=" + id + " ]";
    }
    
}
