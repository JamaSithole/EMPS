/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bheki.Lubisi
 */
@Entity
@Table(name = "plantbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantbl.findAll", query = "SELECT p FROM Plantbl p"),
    @NamedQuery(name = "Plantbl.findById", query = "SELECT p FROM Plantbl p WHERE p.id = :id"),
    @NamedQuery(name = "Plantbl.findByName", query = "SELECT p FROM Plantbl p WHERE p.name = :name"),
    @NamedQuery(name = "Plantbl.findByDescription", query = "SELECT p FROM Plantbl p WHERE p.description = :description"),
    @NamedQuery(name = "Plantbl.findByStartd", query = "SELECT p FROM Plantbl p WHERE p.startd = :startd"),
    @NamedQuery(name = "Plantbl.findByEndd", query = "SELECT p FROM Plantbl p WHERE p.endd = :endd"),
    @NamedQuery(name = "Plantbl.findByQ1startd", query = "SELECT p FROM Plantbl p WHERE p.q1startd = :q1startd"),
    @NamedQuery(name = "Plantbl.findByQ1endd", query = "SELECT p FROM Plantbl p WHERE p.q1endd = :q1endd"),
    @NamedQuery(name = "Plantbl.findByQ2startd", query = "SELECT p FROM Plantbl p WHERE p.q2startd = :q2startd"),
    @NamedQuery(name = "Plantbl.findByQ2endd", query = "SELECT p FROM Plantbl p WHERE p.q2endd = :q2endd"),
    @NamedQuery(name = "Plantbl.findByQ3startd", query = "SELECT p FROM Plantbl p WHERE p.q3startd = :q3startd"),
    @NamedQuery(name = "Plantbl.findByQ3endd", query = "SELECT p FROM Plantbl p WHERE p.q3endd = :q3endd"),
    @NamedQuery(name = "Plantbl.findByQ4startd", query = "SELECT p FROM Plantbl p WHERE p.q4startd = :q4startd"),
    @NamedQuery(name = "Plantbl.findByQ4endd", query = "SELECT p FROM Plantbl p WHERE p.q4endd = :q4endd"),
    @NamedQuery(name = "Plantbl.findByCurrp", query = "SELECT p FROM Plantbl p WHERE p.currp = :currp")})
public class Plantbl implements Serializable {
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
    @Column(name = "STARTD")
    @Temporal(TemporalType.DATE)
    private Date startd;
    @Column(name = "ENDD")
    @Temporal(TemporalType.DATE)
    private Date endd;
    @Column(name = "Q1STARTD")
    @Temporal(TemporalType.DATE)
    private Date q1startd;
    @Column(name = "Q1ENDD")
    @Temporal(TemporalType.DATE)
    private Date q1endd;
    @Column(name = "Q2STARTD")
    @Temporal(TemporalType.DATE)
    private Date q2startd;
    @Column(name = "Q2ENDD")
    @Temporal(TemporalType.DATE)
    private Date q2endd;
    @Column(name = "Q3STARTD")
    @Temporal(TemporalType.DATE)
    private Date q3startd;
    @Column(name = "Q3ENDD")
    @Temporal(TemporalType.DATE)
    private Date q3endd;
    @Column(name = "Q4STARTD")
    @Temporal(TemporalType.DATE)
    private Date q4startd;
    @Column(name = "Q4ENDD")
    @Temporal(TemporalType.DATE)
    private Date q4endd;
    @Column(name = "CURRP")
    private Boolean currp;
    
    @Column(name = "BUDGET")
    private Float budget;
    
    @Column(name = "BUDSPEND")
    private Float budspend;
    
    @OneToMany(mappedBy = "planid")
    private Collection<Progtbl> progtblCollection;

    public Plantbl() {
    }

    public Plantbl(Integer id) {
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

    public Date getStartd() {
        return startd;
    }

    public void setStartd(Date startd) {
        this.startd = startd;
    }

    public Date getEndd() {
        return endd;
    }

    public void setEndd(Date endd) {
        this.endd = endd;
    }

    public Date getQ1startd() {
        return q1startd;
    }

    public void setQ1startd(Date q1startd) {
        this.q1startd = q1startd;
    }

    public Date getQ1endd() {
        return q1endd;
    }

    public void setQ1endd(Date q1endd) {
        this.q1endd = q1endd;
    }

    public Date getQ2startd() {
        return q2startd;
    }

    public void setQ2startd(Date q2startd) {
        this.q2startd = q2startd;
    }

    public Date getQ2endd() {
        return q2endd;
    }

    public void setQ2endd(Date q2endd) {
        this.q2endd = q2endd;
    }

    public Date getQ3startd() {
        return q3startd;
    }

    public void setQ3startd(Date q3startd) {
        this.q3startd = q3startd;
    }

    public Date getQ3endd() {
        return q3endd;
    }

    public void setQ3endd(Date q3endd) {
        this.q3endd = q3endd;
    }

    public Date getQ4startd() {
        return q4startd;
    }

    public void setQ4startd(Date q4startd) {
        this.q4startd = q4startd;
    }

    public Date getQ4endd() {
        return q4endd;
    }

    public void setQ4endd(Date q4endd) {
        this.q4endd = q4endd;
    }

    public Boolean getCurrp() {
        return currp;
    }

    public void setCurrp(Boolean currp) {
        this.currp = currp;
    }

    @XmlTransient
    public Collection<Progtbl> getProgtblCollection() {
        return progtblCollection;
    }

    public void setProgtblCollection(Collection<Progtbl> progtblCollection) {
        this.progtblCollection = progtblCollection;
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
        if (!(object instanceof Plantbl)) {
            return false;
        }
        Plantbl other = (Plantbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Plantbl[ id=" + id + " ]";
    }

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	public Float getBudspend() {
		return budspend;
	}

	public void setBudspend(Float budspend) {
		this.budspend = budspend;
	}
    
}
