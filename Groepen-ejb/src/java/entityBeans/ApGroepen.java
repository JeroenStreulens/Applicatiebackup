/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woute
 */
@Entity
@Table(name = "ap_groepen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApGroepen.findAll", query = "SELECT a FROM ApGroepen a")
    , @NamedQuery(name = "ApGroepen.findGnr", query = "SELECT distinct(a.apGroepenPK.gnr) FROM ApGroepen a ")
    , @NamedQuery(name = "ApGroepen.findallstudents", query = "SELECT distinct(a.apGroepenPK.gsnr) FROM ApGroepen a ")
    , @NamedQuery(name = "ApGroepen.findByGnr", query = "SELECT a FROM ApGroepen a WHERE a.apGroepenPK.gnr = :gnr")
    , @NamedQuery(name = "ApGroepen.findMaxgrp", query = "Select max(a.apGroepenPK.gnr) from ApGroepen a")
    , @NamedQuery(name = "ApGroepen.findByGsnr", query = "SELECT a FROM ApGroepen a WHERE a.apGroepenPK.gsnr = :gsnr")})
public class ApGroepen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApGroepenPK apGroepenPK;

    public ApGroepen() {
    }

    public ApGroepen(ApGroepenPK apGroepenPK) {
        this.apGroepenPK = apGroepenPK;
    }

    public ApGroepen(int gnr, int gsnr) {
        this.apGroepenPK = new ApGroepenPK(gnr, gsnr);
    }

    public ApGroepenPK getApGroepenPK() {
        return this.apGroepenPK;
    }

    public void setApGroepenPK(ApGroepenPK apGroepenPK) {
        this.apGroepenPK = apGroepenPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apGroepenPK != null ? apGroepenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApGroepen)) {
            return false;
        }
        ApGroepen other = (ApGroepen) object;
        if ((this.apGroepenPK == null && other.apGroepenPK != null) || (this.apGroepenPK != null && !this.apGroepenPK.equals(other.apGroepenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApGroepen[ apGroepenPK=" + apGroepenPK + " ]";
    }
    
}
