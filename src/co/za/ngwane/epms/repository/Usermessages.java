/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "usermessages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usermessages.findAll", query = "SELECT u FROM Usermessages u"),
    @NamedQuery(name = "Usermessages.findByReference", query = "SELECT u FROM Usermessages u WHERE u.reference = :reference"),
    @NamedQuery(name = "Usermessages.findByContactEmail", query = "SELECT u FROM Usermessages u WHERE u.contactEmail = :contactEmail"),
    @NamedQuery(name = "Usermessages.findByContactCell", query = "SELECT u FROM Usermessages u WHERE u.contactCell = :contactCell"),
    @NamedQuery(name = "Usermessages.findByType", query = "SELECT u FROM Usermessages u WHERE u.type = :type"),
    @NamedQuery(name = "Usermessages.findByDate", query = "SELECT u FROM Usermessages u WHERE u.date = :date"),
    @NamedQuery(name = "Usermessages.findMessagesToProcess", query = "SELECT u FROM Usermessages u WHERE u.date = :date and u.status = :status"),
    @NamedQuery(name = "Usermessages.findByStatus", query = "SELECT u FROM Usermessages u WHERE u.status = :status")})
public class Usermessages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "contactEmail")
    private String contactEmail;
    @Column(name = "contactCell")
    private String contactCell;
    @Column(name = "type")
    private Integer type;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne
    private Messagestbl code;
    @JoinColumn(name = "output", referencedColumnName = "ID")
    @ManyToOne
    private Outputtbl output;

    public Usermessages() {
    }

    public Usermessages(Integer reference) {
        this.reference = reference;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactCell() {
        return contactCell;
    }

    public void setContactCell(String contactCell) {
        this.contactCell = contactCell;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Messagestbl getCode() {
        return code;
    }

    public void setCode(Messagestbl code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermessages)) {
            return false;
        }
        Usermessages other = (Usermessages) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Usermessages[ reference=" + reference + " ]";
    }

	public Outputtbl getOutput()
	{
		return output;
	}

	public void setOutput(Outputtbl output)
	{
		this.output = output;
	}
    
}
