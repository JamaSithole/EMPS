/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "userepms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userepms.findAll", query = "SELECT u FROM Userepms u"),
    @NamedQuery(name = "Userepms.findById", query = "SELECT u FROM Userepms u WHERE u.id = :id"),
    @NamedQuery(name = "Userepms.findByName", query = "SELECT u FROM Userepms u WHERE u.name = :name"),
    @NamedQuery(name = "Userepms.findByMiddlename", query = "SELECT u FROM Userepms u WHERE u.middlename = :middlename"),
    @NamedQuery(name = "Userepms.findBySurname", query = "SELECT u FROM Userepms u WHERE u.surname = :surname"),
    @NamedQuery(name = "Userepms.findByDob", query = "SELECT u FROM Userepms u WHERE u.dob = :dob"),
    @NamedQuery(name = "Userepms.findByIdtype", query = "SELECT u FROM Userepms u WHERE u.idtype = :idtype"),
    @NamedQuery(name = "Userepms.findByIdnumber", query = "SELECT u FROM Userepms u WHERE u.idnumber = :idnumber"),
    @NamedQuery(name = "Userepms.findByUsername", query = "SELECT u FROM Userepms u WHERE u.username = :username"),
    @NamedQuery(name = "Userepms.userLogin", query = "SELECT u FROM Userepms u WHERE u.username = :username AND u.password = :password"),
    @NamedQuery(name = "Userepms.findByPassword", query = "SELECT u FROM Userepms u WHERE u.password = :password")})
public class Userepms implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "IDTYPE")
    private Short idtype;
    @Column(name = "IDNUMBER")
    private String idnumber;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ENV")
    private String env;
    @Column(name = "CONTACTEMAIL")
    private String contactemail;
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
 	@Transient
    private boolean auditor;

    @JoinColumn(name = "ROLEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Roleepms roleid;
    @JoinColumn(name = "SUBLEVELID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sublevel sublevelid;
    @OneToMany(mappedBy = "user")
    private Collection<Usermod> usermodCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Outputtbl> outputtblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Collection<Progtbl> progtblCollection;
    @OneToMany(mappedBy = "owner")
    private Collection<Projtbl> projtblCollection;
    @OneToMany(mappedBy = "owner")
    private Collection<Outcometbl> outcometblCollection;

    public Userepms() {
    }

    public Userepms(Integer id) {
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

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Short getIdtype() {
        return idtype;
    }

    public void setIdtype(Short idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public Roleepms getRoleid() {
        return roleid;
    }

    public void setRoleid(Roleepms roleid) {
        this.roleid = roleid;
    }

    public Sublevel getSublevelid() {
        return sublevelid;
    }

    public void setSublevelid(Sublevel sublevelid) {
        this.sublevelid = sublevelid;
    }
	public boolean isAuditor()
	{
		return auditor;
	}

	public void setAuditor(boolean auditor)
	{
		this.auditor = auditor;
	}

    @XmlTransient
    public Collection<Usermod> getUsermodCollection() {
        return usermodCollection;
    }

    public void setUsermodCollection(Collection<Usermod> usermodCollection) {
        this.usermodCollection = usermodCollection;
    }

    @XmlTransient
    public Collection<Outputtbl> getOutputtblCollection() {
        return outputtblCollection;
    }

    public void setOutputtblCollection(Collection<Outputtbl> outputtblCollection) {
        this.outputtblCollection = outputtblCollection;
    }

    @XmlTransient
    public Collection<Progtbl> getProgtblCollection() {
        return progtblCollection;
    }

    public void setProgtblCollection(Collection<Progtbl> progtblCollection) {
        this.progtblCollection = progtblCollection;
    }

    @XmlTransient
    public Collection<Projtbl> getProjtblCollection() {
        return projtblCollection;
    }

    public void setProjtblCollection(Collection<Projtbl> projtblCollection) {
        this.projtblCollection = projtblCollection;
    }

    @XmlTransient
    public Collection<Outcometbl> getOutcometblCollection() {
        return outcometblCollection;
    }

    public void setOutcometblCollection(Collection<Outcometbl> outcometblCollection) {
        this.outcometblCollection = outcometblCollection;
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
        if (!(object instanceof Userepms)) {
            return false;
        }
        Userepms other = (Userepms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Userepms[ id=" + id + " ]";
    }
    
}
