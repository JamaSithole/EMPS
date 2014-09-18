/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.ngwane.epms.repository;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "messagestbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messagestbl.findAll", query = "SELECT m FROM Messagestbl m"),
    @NamedQuery(name = "Messagestbl.findByCode", query = "SELECT m FROM Messagestbl m WHERE m.code = :code"),
    @NamedQuery(name = "Messagestbl.findByMsgsubject", query = "SELECT m FROM Messagestbl m WHERE m.msgsubject = :msgsubject"),
    @NamedQuery(name = "Messagestbl.findByMsgbody", query = "SELECT m FROM Messagestbl m WHERE m.msgbody = :msgbody")})
public class Messagestbl implements Serializable {    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Column(name = "msgsubject")
    private String msgsubject;
    @Column(name = "msgbody")
    private String msgbody;
    @OneToMany(mappedBy = "code")
    private Collection<Usermessages> usermessagesCollection;

    public Messagestbl() {
    }

    public Messagestbl(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsgsubject() {
        return msgsubject;
    }

    public void setMsgsubject(String msgsubject) {
        this.msgsubject = msgsubject;
    }

    public String getMsgbody() {
        return msgbody;
    }

    public void setMsgbody(String msgbody) {
        this.msgbody = msgbody;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messagestbl)) {
            return false;
        }
        Messagestbl other = (Messagestbl) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.za.ngwane.epms.repository.Messagestbl[ code=" + code + " ]";
    }

    @XmlTransient
    public Collection<Usermessages> getUsermessagesCollection() {
        return usermessagesCollection;
    }

    public void setUsermessagesCollection(Collection<Usermessages> usermessagesCollection) {
        this.usermessagesCollection = usermessagesCollection;
    }
    
}
