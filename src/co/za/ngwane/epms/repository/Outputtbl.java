/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bheki.lubisi
 */
@Entity
@Table(name = "outputtbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outputtbl.findAll", query = "SELECT o FROM Outputtbl o"),
    @NamedQuery(name = "Outputtbl.findById", query = "SELECT o FROM Outputtbl o WHERE o.id = :id"),
    @NamedQuery(name = "Outputtbl.findByName", query = "SELECT o FROM Outputtbl o WHERE o.name = :name"),
    @NamedQuery(name = "Outputtbl.findByBudspend", query = "SELECT o FROM Outputtbl o WHERE o.budspend = :budspend"),
    @NamedQuery(name = "Outputtbl.findByTotbud", query = "SELECT o FROM Outputtbl o WHERE o.totbud = :totbud"),
    @NamedQuery(name = "Outputtbl.findByQ1", query = "SELECT o FROM Outputtbl o WHERE o.q1 = :q1"),
    @NamedQuery(name = "Outputtbl.findByQ2", query = "SELECT o FROM Outputtbl o WHERE o.q2 = :q2"),
    @NamedQuery(name = "Outputtbl.findByQ3", query = "SELECT o FROM Outputtbl o WHERE o.q3 = :q3"),
    @NamedQuery(name = "Outputtbl.findByUserepms", query = "SELECT o FROM Outputtbl o WHERE o.userid = :userid"),
    @NamedQuery(name = "Outputtbl.findByOutcome", query = "SELECT o FROM Outputtbl o WHERE o.outcometblid = :outcometblid"),
    @NamedQuery(name = "Outputtbl.findByQ4", query = "SELECT o FROM Outputtbl o WHERE o.q4 = :q4")})
public class Outputtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BUDSPEND")
    private Float budspend;
    @Column(name = "TOTBUD")
    private Float totbud;
    @Column(name = "Q1")
    private Float q1;
    @Column(name = "Q2")
    private Float q2;
    @Column(name = "Q3")
    private Float q3;
    @Column(name = "Q4")
    private Float q4;
    @Column(name = "Q1A")
    private Float q1a;
    @Column(name = "Q2A")
    private Float q2a;
    @Column(name = "Q3A")
    private Float q3a;
    @Column(name = "Q4A")
    private Float q4a;
    @Column(name = "REFNO")
    private String refno;
/*    @Column(name = "OWNER")
    private Integer owner;
*/    @Column(name = "CURRQ")
    private String currq;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "INDICATOR")
    private String indicator;
    @Basic(optional = false)
    @Column(name = "QUANTITATIVE")
    private boolean quantitative;
    @Column(name = "outputComplete")
    private boolean outputComplete;
    
    @Transient
    private String q1fs;
    @Transient
    private String q2fs;
    @Transient
    private String q3fs;
    @Transient
    private String q4fs;
    
    @Transient
    private float avgScore = 0f;
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Userepms userid;
	@JoinColumn(name = "OUTCOMETBLID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Outcometbl outcometblid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "outputtblid")
    private Collection<Qoupd> qoupdCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "outputtblid")
    private Collection<Outupdate> outupdateCollection;    
    @OneToMany(mappedBy = "output")
    private Collection<Usermessages> messageCollection;
        
    @Transient
    private List<Qoupd> updates = new ArrayList<Qoupd>();
    
    @Transient
    private int requestPendingStatus = 1; //Check OutPutStatus.java for Status descriptions

    public Outputtbl() {
    }
    
    public Userepms getUserid() {
		return userid;
	}

	public void setUserid(Userepms userid) {
		this.userid = userid;
	}

    public Outputtbl(Integer id) {
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

    public Float getBudspend() {
        return budspend;
    }

    public void setBudspend(Float budspend) {
        this.budspend = budspend;
    }

    public Float getTotbud() {
        return totbud;
    }

    public void setTotbud(Float totbud) {
        this.totbud = totbud;
    }

    public Float getQ1() {
        return q1;
    }

    public void setQ1(Float q1) {
        this.q1 = q1;
    }

    public Outcometbl getOutcometblid() {
        return outcometblid;
    }

    public void setOutcometblid(Outcometbl outcometblid) {
        this.outcometblid = outcometblid;
    }

    @XmlTransient
    public Collection<Qoupd> getQoupdCollection() {
        return qoupdCollection;
    }

    public void setQoupdCollection(Collection<Qoupd> qoupdCollection) {
        this.qoupdCollection = qoupdCollection;
    }

    @XmlTransient
    public Collection<Outupdate> getOutupdateCollection() {
        return outupdateCollection;
    }

    public void setOutupdateCollection(Collection<Outupdate> outupdateCollection) {
        this.outupdateCollection = outupdateCollection;
    }
    
    @XmlTransient
    public Collection<Usermessages> getMessageCollection()
	{
		return messageCollection;
	}

	public void setMessageCollection(Collection<Usermessages> messageCollection)
	{
		this.messageCollection = messageCollection;
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
        if (!(object instanceof Outputtbl)) {
            return false;
        }
        Outputtbl other = (Outputtbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Outputtbl[ id=" + id + " ]";
    }

	public Float getQ1a() {
		return q1a;
	}

	public void setQ1a(Float q1a) {
		this.q1a = q1a;
	}

	public Float getQ2a() {
		return q2a;
	}

	public void setQ2a(Float q2a) {
		this.q2a = q2a;
	}

	public Float getQ3a() {
		return q3a;
	}

	public void setQ3a(Float q3a) {
		this.q3a = q3a;
	}

	public Float getQ4a() {
		return q4a;
	}

	public void setQ4a(Float q4a) {
		this.q4a = q4a;
	}

	public void setQ2(Float q2) {
		this.q2 = q2;
	}

	public void setQ3(Float q3) {
		this.q3 = q3;
	}

	public void setQ4(Float q4) {
		this.q4 = q4;
	}

	

	public void setRefno(String refno) {
		this.refno = refno;
	}
	 @Transient
	public String getQ1fs()
	{
		return q1fs;
	}
	 @Transient
	public void setQ1fs(String q1fs)
	{
		this.q1fs = q1fs;
	}
	 @Transient
	public String getQ2fs()
	{
		return q2fs;
	}
	 @Transient
	public void setQ2fs(String q2fs)
	{
		this.q2fs = q2fs;
	}
	 @Transient
	public String getQ3fs()
	{
		return q3fs;
	}
	 @Transient
	public void setQ3fs(String q3fs)
	{
		this.q3fs = q3fs;
	}
	 @Transient
	public String getQ4fs()
	{
		return q4fs;
	}
	 @Transient
	public void setQ4fs(String q4fs)
	{
		this.q4fs = q4fs;
	}

	public Float getQ2()
	{
		return q2;
	}

	public Float getQ3()
	{
		return q3;
	}

	public Float getQ4()
	{
		return q4;
	}

	public String getRefno()
	{
		return refno;
	}

	public String getCurrq() {
		return currq;
	}

	public void setCurrq(String currq) {
		this.currq = currq;
	}
	
	@Transient
	public List<Qoupd> getUpdates()
	{
		return updates;
	}

	@Transient
	public void setUpdates(List<Qoupd> updates)
	{
		this.updates = updates;
	}

	public float getAvgScore()
	{
		return avgScore;
	}

	public void setAvgScore(float avgScore)
	{
		this.avgScore = avgScore;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getIndicator()
	{
		return indicator;
	}

	public void setIndicator(String indicator)
	{
		this.indicator = indicator;
	}

	public boolean isQuantitative()
	{
		return quantitative;
	}

	public void setQuantitative(boolean quantitative)
	{
		this.quantitative = quantitative;
	}

	public boolean isOutputComplete()
	{
		return outputComplete;
	}

	public void setOutputComplete(boolean outputComplete)
	{
		this.outputComplete = outputComplete;
	}

	public int getRequestPendingStatus()
	{
		return requestPendingStatus;
	}

	public void setRequestPendingStatus(int requestPendingStatus)
	{
		this.requestPendingStatus = requestPendingStatus;
	}

	
    
}
