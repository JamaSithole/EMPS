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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bheki.lubisi
 */
@Entity
@Table(name = "outcometbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outcometbl.findAll", query = "SELECT o FROM Outcometbl o"),
    @NamedQuery(name = "Outcometbl.findById", query = "SELECT o FROM Outcometbl o WHERE o.id = :id"),
    @NamedQuery(name = "Outcometbl.findByName", query = "SELECT o FROM Outcometbl o WHERE o.name = :name"),
    @NamedQuery(name = "Outcometbl.findByDescription", query = "SELECT o FROM Outcometbl o WHERE o.description = :description"),
    @NamedQuery(name = "Outcometbl.findByProjtblid", query = "SELECT o FROM Outcometbl o WHERE o.projtblid = :projtblid"),
    @NamedQuery(name = "Outcometbl.findByVal", query = "SELECT o FROM Outcometbl o WHERE o.val = :val")})
public class Outcometbl implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL")
    private Float val;
    @Column(name = "ABUDGET")
    private Float abudget;
    @Column(name = "ABALANCE")
    private Float abalance;
    @Transient
    private int errorcode ;
    @Transient
    private String errorMessage;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "outcometblid")
    private Collection<Outputtbl> outputtblCollection;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne
    private Userepms owner;
    @JoinColumn(name = "PROJTBLID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Projtbl projtblid;

    public Outcometbl() {
    }

    public Outcometbl(Integer id) {
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

    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }

    public Float getAbudget() {
        return abudget;
    }

    public void setAbudget(Float abudget) {
        this.abudget = abudget;
    }

    public Float getAbalance() {
        return abalance;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }

    @XmlTransient
    public Collection<Outputtbl> getOutputtblCollection() {
        return outputtblCollection;
    }

    public void setOutputtblCollection(Collection<Outputtbl> outputtblCollection) {
        this.outputtblCollection = outputtblCollection;
    }

    public Userepms getOwner() {
        return owner;
    }

    public void setOwner(Userepms owner) {
        this.owner = owner;
    }

    public Projtbl getProjtblid() {
        return projtblid;
    }

    public void setProjtblid(Projtbl projtblid) {
        this.projtblid = projtblid;
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
        if (!(object instanceof Outcometbl)) {
            return false;
        }
        Outcometbl other = (Outcometbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Outcometbl[ id=" + id + " ]";
    }

	public int getErrorcode()
	{
		return errorcode;
	}

	public void setErrorcode(int errorcode)
	{
		this.errorcode = errorcode;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
    
}
