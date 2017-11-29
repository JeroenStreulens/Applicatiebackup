/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author woute
 */
@Embeddable
public class ApGroepenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "gnr")
    private int gnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gsnr")
    private int gsnr;

    public ApGroepenPK() {
    }

    public ApGroepenPK(int gnr, int gsnr) {
        this.gnr = gnr;
        this.gsnr = gsnr;
    }

    public int getGnr() {
        return gnr;
    }

    public void setGnr(int gnr) {
        this.gnr = gnr;
    }

    public int getGsnr() {
        return gsnr;
    }

    public void setGsnr(int gsnr) {
        this.gsnr = gsnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gnr;
        hash += (int) gsnr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApGroepenPK)) {
            return false;
        }
        ApGroepenPK other = (ApGroepenPK) object;
        if (this.gnr != other.gnr) {
            return false;
        }
        if (this.gsnr != other.gsnr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApGroepenPK[ gnr=" + gnr + ", gsnr=" + gsnr + " ]";
    }
    
}
