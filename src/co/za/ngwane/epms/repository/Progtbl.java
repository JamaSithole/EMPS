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
@Table(name = "progtbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progtbl.findAll", query = "SELECT p FROM Progtbl p"),
    @NamedQuery(name = "Progtbl.findById", query = "SELECT p FROM Progtbl p WHERE p.id = :id"),
    @NamedQuery(name = "Progtbl.findByName", query = "SELECT p FROM Progtbl p WHERE p.name = :name")})
public class Progtbl implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AVBALANCE")
    private Float avbalance;
    @Column(name = "TOTALBUDGET")
    private Float totalbudget;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "BUDSPEND")
    private Float budspend;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "progid")
    private Collection<Progndplink> progndplinkCollection;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Userepms owner;
    @JoinColumn(name = "SECTIONID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sectiontbl sectionid;
    @JoinColumn(name = "PLANID", referencedColumnName = "ID")
    @ManyToOne
    private Plantbl planid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "progtblid")
    private Collection<Projtbl> projtblCollection;

    public Progtbl() {
    }

    public Progtbl(Integer id) {
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

    public Float getAvbalance() {
        return avbalance;
    }

    public void setAvbalance(Float avbalance) {
        this.avbalance = avbalance;
    }

    public Float getTotalbudget() {
        return totalbudget;
    }

    public void setTotalbudget(Float totalbudget) {
        this.totalbudget = totalbudget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getBudspend() {
        return budspend;
    }

    public void setBudspend(Float budspend) {
        this.budspend = budspend;
    }

    @XmlTransient
    public Collection<Progndplink> getProgndplinkCollection() {
        return progndplinkCollection;
    }

    public void setProgndplinkCollection(Collection<Progndplink> progndplinkCollection) {
        this.progndplinkCollection = progndplinkCollection;
    }

    public Userepms getOwner() {
        return owner;
    }

    public void setOwner(Userepms owner) {
        this.owner = owner;
    }

    public Sectiontbl getSectionid() {
        return sectionid;
    }

    public void setSectionid(Sectiontbl sectionid) {
        this.sectionid = sectionid;
    }

    public Plantbl getPlanid() {
        return planid;
    }

    public void setPlanid(Plantbl planid) {
        this.planid = planid;
    }

    @XmlTransient
    public Collection<Projtbl> getProjtblCollection() {
        return projtblCollection;
    }

    public void setProjtblCollection(Collection<Projtbl> projtblCollection) {
        this.projtblCollection = projtblCollection;
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
        if (!(object instanceof Progtbl)) {
            return false;
        }
        Progtbl other = (Progtbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Progtbl[ id=" + id + " ]";
    }
    
}
