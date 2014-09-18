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
@Table(name = "progndplink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progndplink.findAll", query = "SELECT p FROM Progndplink p"),
    @NamedQuery(name = "Progndplink.findByProgram", query = "SELECT p FROM Progndplink p WHERE p.progid = :progid"),
    @NamedQuery(name = "Progndplink.findById", query = "SELECT p FROM Progndplink p WHERE p.id = :id")})
public class Progndplink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "PROGID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Progtbl progid;
    @JoinColumn(name = "NDPID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ndp ndpid;

    public Progndplink() {
    }

    public Progndplink(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Progtbl getProgid() {
        return progid;
    }

    public void setProgid(Progtbl progid) {
        this.progid = progid;
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
        if (!(object instanceof Progndplink)) {
            return false;
        }
        Progndplink other = (Progndplink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Progndplink[ id=" + id + " ]";
    }
    
}
