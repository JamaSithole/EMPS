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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bheki.lubisi
 */
@Entity
@Table(name = "qoupd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qoupd.findAll", query = "SELECT q FROM Qoupd q"),
    @NamedQuery(name = "Qoupd.findById", query = "SELECT q FROM Qoupd q WHERE q.id = :id"),
    @NamedQuery(name = "Qoupd.findByQuo", query = "SELECT q FROM Qoupd q WHERE q.quo = :quo"),
   // @NamedQuery(name = "Qoupd.findByQscore", query = "SELECT q FROM Qoupd q WHERE q.qscore = :qscore"),
    @NamedQuery(name = "Qoupd.findByComment", query = "SELECT q FROM Qoupd q WHERE q.comment = :comment"),
    @NamedQuery(name = "Qoupd.findByPaction", query = "SELECT q FROM Qoupd q WHERE q.paction = :paction"),
    @NamedQuery(name = "Qoupd.findByPastartd", query = "SELECT q FROM Qoupd q WHERE q.pastartd = :pastartd"),
    @NamedQuery(name = "Qoupd.findByPaendd", query = "SELECT q FROM Qoupd q WHERE q.paendd = :paendd"),
    @NamedQuery(name = "Qoupd.findByOutputtblid", query = "SELECT q FROM Qoupd q WHERE q.outputtblid = :outputtblid"),
   
    @NamedQuery(name = "Qoupd.findRejected", query = "SELECT q FROM Qoupd q where q.stat=3 and q.id in ( SELECT max(qo.id) FROM Qoupd qo  where qo.outputtblid = :outputtblid GROUP BY qo.quo)"),

    @NamedQuery(name = "Qoupd.findPending", query = "SELECT q FROM Qoupd q where q.stat=1 and q.id in ( SELECT max(qo.id) FROM Qoupd qo  where qo.outputtblid = :outputtblid GROUP BY qo.quo)"),
    
    @NamedQuery(name = "Qoupd.findByAuditstatus", query = "SELECT q FROM Qoupd q WHERE q.auditstatus = :auditstatus")})
public class Qoupd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUO")
    private String quo;
    @Column(name = "QSCORE")
    private Float qscore;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "PACTION")
    private String paction;
    @Column(name = "PASTARTD")
    @Temporal(TemporalType.DATE)
    private Date pastartd;
    @Column(name = "PAENDD")
    @Temporal(TemporalType.DATE)
    private Date paendd;
    @Column(name = "AUDITSTATUS")
    private String auditstatus;
    @JoinColumn(name = "OUTPUTTBLID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Outputtbl outputtblid;
    
    @Column(name = "BUDSPEND")
    private Float budspend;

    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createD;
    
    @Column(name = "STATUPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statUpdateD;

    @Column(name = "STAT")
    private Integer stat;
    @Basic(optional = false)
    @Column(name = "TMET")
    private boolean tmet;
    
    @OneToMany(mappedBy = "qoupdid")
    private Collection<Attachepms> attachepmsCollection;
    
    @Transient
    private String currentqTarget = "";

    @Transient
    private String statusDescription;

    public Qoupd() {
    }

    public Qoupd(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuo() {
        return quo;
    }

    public void setQuo(String quo) {
        this.quo = quo;
    }

    public Float getQscore() {
        return qscore;
    }

    public void setQscore(Float qarc) {
        this.qscore = qarc;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPaction() {
        return paction;
    }

    public void setPaction(String paction) {
        this.paction = paction;
    }

    public Date getPastartd() {
        return pastartd;
    }

    public void setPastartd(Date pastartd) {
        this.pastartd = pastartd;
    }

    public Date getPaendd() {
        return paendd;
    }

    public void setPaendd(Date paendd) {
        this.paendd = paendd;
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus;
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
        if (!(object instanceof Qoupd)) {
            return false;
        }
        Qoupd other = (Qoupd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Qoupd[ id=" + id + " ]";
    }

	public Date getCreateD() {
		return createD;
	}

	public void setCreateD(Date createD) {
		this.createD = createD;
	}

	public Date getStatUpdateD() {
		return statUpdateD;
	}

	public void setStatUpdateD(Date statUpdateD) {
		this.statUpdateD = statUpdateD;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public String getCurrentqTarget() {
		return currentqTarget;
	}

	public void setCurrentqTarget(String currentqTarget) {
		this.currentqTarget = currentqTarget;
	}

public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public boolean isTmet()
	{
		return tmet;
	}

	public void setTmet(boolean tmet)
	{
		this.tmet = tmet;
	}

	public Float getBudspend()
	{
		return budspend;
	}

	public void setBudspend(Float budspend)
	{
		this.budspend = budspend;
	}
	
	@XmlTransient
    public Collection<Attachepms> getAttachepmsCollection() {
        return attachepmsCollection;
    }

    public void setAttachepmsCollection(Collection<Attachepms> attachepmsCollection) {
        this.attachepmsCollection = attachepmsCollection;
    }
    
}
