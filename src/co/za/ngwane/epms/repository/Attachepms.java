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
import javax.persistence.Lob;
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
@Table(name = "attachepms")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Attachepms.findAll", query = "SELECT a FROM Attachepms a"),
		@NamedQuery(name = "Attachepms.findById", query = "SELECT a FROM Attachepms a WHERE a.id = :id"),
		@NamedQuery(name = "Attachepms.findByRef", query = "SELECT a FROM Attachepms a WHERE a.ref = :ref"),
		@NamedQuery(name = "Attachepms.findByName", query = "SELECT a FROM Attachepms a WHERE a.name = :name"),
		
		@NamedQuery(name = "Attachepms.findByQoupd", query = "SELECT a FROM Attachepms a WHERE a.qoupdid = :qoupdid"),
		
		@NamedQuery(name = "Attachepms.findBySizefile", query = "SELECT a FROM Attachepms a WHERE a.sizefile = :sizefile") })
public class Attachepms implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "REF")
	private String ref;
	@Lob
	@Column(name = "ATTACHMENT")
	private byte[] attachment;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SIZEFILE")
	private String sizefile;
	@JoinColumn(name = "QOUPDID", referencedColumnName = "ID")
	@ManyToOne
	private Qoupd qoupdid;

	public Attachepms() {
	}

	public Attachepms(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSizefile() {
		return sizefile;
	}

	public void setSizefile(String sizefile) {
		this.sizefile = sizefile;
	}

	public Qoupd getQoupdid() {
		return qoupdid;
	}

	public void setQoupdid(Qoupd qoupdid) {
		this.qoupdid = qoupdid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Attachepms)) {
			return false;
		}
		Attachepms other = (Attachepms) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "co.za.ngwane.epms.repository.Attachepms[ id=" + id + " ]";
	}

}
