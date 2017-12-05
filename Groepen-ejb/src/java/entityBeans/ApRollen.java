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
    , @NamedQuery(name = "ApRollen.findByUnr", query = "SELECT a FROM ApRollen a WHERE a.unr = :unr")})
public class ApRollen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "rol")
    private String rol;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "unr")
    private Integer unr;

    public ApRollen() {
    }

    public ApRollen(Integer unr) {
        this.unr = unr;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getUnr() {
        return unr;
    }

    public void setUnr(Integer unr) {
        this.unr = unr;
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
        if (!(object instanceof ApRollen)) {
            return false;
        }
        ApRollen other = (ApRollen) object;
        if ((this.unr == null && other.unr != null) || (this.unr != null && !this.unr.equals(other.unr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApRollen[ unr=" + unr + " ]";
    }
    
}
