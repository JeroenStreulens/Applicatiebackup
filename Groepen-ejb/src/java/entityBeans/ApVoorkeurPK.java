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
public class ApVoorkeurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "vsnr")
    private int vsnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "osnr")
    private int osnr;

    public ApVoorkeurPK() {
    }

    public ApVoorkeurPK(int vsnr, int osnr) {
        this.vsnr = vsnr;
        this.osnr = osnr;
    }

    public int getVsnr() {
        return vsnr;
    }

    public void setVsnr(int vsnr) {
        this.vsnr = vsnr;
    }

    public int getOsnr() {
        return osnr;
    }

    public void setOsnr(int osnr) {
        this.osnr = osnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vsnr;
        hash += (int) osnr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApVoorkeurPK)) {
            return false;
        }
        ApVoorkeurPK other = (ApVoorkeurPK) object;
        if (this.vsnr != other.vsnr) {
            return false;
        }
        if (this.osnr != other.osnr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApVoorkeurPK[ vsnr=" + vsnr + ", osnr=" + osnr + " ]";
    }
    
}
