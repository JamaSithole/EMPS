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
@Table(name = "outupdate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outupdate.findAll", query = "SELECT o FROM Outupdate o"),
    @NamedQuery(name = "Outupdate.findById", query = "SELECT o FROM Outupdate o WHERE o.id = :id"),
    @NamedQuery(name = "Outupdate.findByQ1", query = "SELECT o FROM Outupdate o WHERE o.q1 = :q1"),
    @NamedQuery(name = "Outupdate.findByQ2", query = "SELECT o FROM Outupdate o WHERE o.q2 = :q2"),
    @NamedQuery(name = "Outupdate.findByQ3", query = "SELECT o FROM Outupdate o WHERE o.q3 = :q3"),
    @NamedQuery(name = "Outupdate.findByQ4", query = "SELECT o FROM Outupdate o WHERE o.q4 = :q4")})
public class Outupdate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Q1")
    private Float q1;
    @Column(name = "Q2")
    private Float q2;
    @Column(name = "Q3")
    private Float q3;
    @Column(name = "Q4")
    private Float q4;
    @JoinColumn(name = "OUTPUTTBLID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Outputtbl outputtblid;

    public Outupdate() {
    }

    public Outupdate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQ1() {
        return q1;
    }

    public void setQ1(Float q1) {
        this.q1 = q1;
    }

    public Float getQ2() {
        return q2;
    }

    public void setQ2(Float q2) {
        this.q2 = q2;
    }

    public Float getQ3() {
        return q3;
    }

    public void setQ3(Float q3) {
        this.q3 = q3;
    }

    public Float getQ4() {
        return q4;
    }

    public void setQ4(Float q4) {
        this.q4 = q4;
    }

    public Outputtbl getOutputtblid() {
        return outputtblid;
    }

    public void setOutputtblid(Outputtbl outputtblid) {
        this.outputtblid = outputtblid;
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
        if (!(object instanceof Outupdate)) {
            return false;
        }
        Outupdate other = (Outupdate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Outupdate[ id=" + id + " ]";
    }
    
}
