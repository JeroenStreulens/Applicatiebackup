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
@Table(name = "ap_rollen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApRollen.findAll", query = "SELECT a FROM ApRollen a")
    , @NamedQuery(name = "ApRollen.findByRol", query = "SELECT a FROM ApRollen a WHERE a.rol = :rol")
    , @NamedQuery(name = "ApRollen.findByRnr", query = "SELECT a FROM ApRollen a WHERE a.rnr = :rnr")})
public class ApRollen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "rol")
    private String rol;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rnr")
    private Integer rnr;

    public ApRollen() {
    }

    public ApRollen(Integer rnr) {
        this.rnr = rnr;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getRnr() {
        return rnr;
    }

    public void setRnr(Integer rnr) {
        this.rnr = rnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rnr != null ? rnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApRollen)) {
            return false;
        }
        ApRollen other = (ApRollen) object;
        if ((this.rnr == null && other.rnr != null) || (this.rnr != null && !this.rnr.equals(other.rnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApRollen[ rnr=" + rnr + " ]";
    }
    
}
