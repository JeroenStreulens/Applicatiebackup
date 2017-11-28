/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woute
 */
@Entity
@Table(name = "ap_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApUsers.findAll", query = "SELECT a FROM ApUsers a")
    , @NamedQuery(name = "ApUsers.findByUnr", query = "SELECT a FROM ApUsers a WHERE a.unr = :unr")
    , @NamedQuery(name = "ApUsers.findByUnaam", query = "SELECT a FROM ApUsers a WHERE a.unaam = :unaam")
    , @NamedQuery(name = "ApUsers.findByUpwoord", query = "SELECT a FROM ApUsers a WHERE a.upwoord = :upwoord")
    , @NamedQuery(name = "ApUsers.findByBevestigd", query = "SELECT a FROM ApUsers a WHERE a.bevestigd = :bevestigd")})
public class ApUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "unr")
    private Integer unr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "unaam")
    private String unaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "upwoord")
    private String upwoord;
    @Column(name = "bevestigd")
    private Character bevestigd;

    public ApUsers() {
    }

    public ApUsers(Integer unr) {
        this.unr = unr;
    }

    public ApUsers(Integer unr, String unaam, String upwoord) {
        this.unr = unr;
        this.unaam = unaam;
        this.upwoord = upwoord;
    }

    public Integer getUnr() {
        return unr;
    }

    public void setUnr(Integer unr) {
        this.unr = unr;
    }

    public String getUnaam() {
        return unaam;
    }

    public void setUnaam(String unaam) {
        this.unaam = unaam;
    }

    public String getUpwoord() {
        return upwoord;
    }

    public void setUpwoord(String upwoord) {
        this.upwoord = upwoord;
    }

    public Character getBevestigd() {
        return bevestigd;
    }

    public void setBevestigd(Character bevestigd) {
        this.bevestigd = bevestigd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unr != null ? unr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApUsers)) {
            return false;
        }
        ApUsers other = (ApUsers) object;
        if ((this.unr == null && other.unr != null) || (this.unr != null && !this.unr.equals(other.unr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApUsers[ unr=" + unr + " ]";
    }
    
}
