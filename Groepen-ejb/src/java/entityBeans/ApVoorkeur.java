/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "ap_voorkeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApVoorkeur.findAll", query = "SELECT a FROM ApVoorkeur a")
    , @NamedQuery(name = "ApVoorkeur.findByVsnr", query = "SELECT a FROM ApVoorkeur a WHERE a.apVoorkeurPK.vsnr = :vsnr")
    , @NamedQuery(name = "ApVoorkeur.findByOsnr", query = "SELECT a FROM ApVoorkeur a WHERE a.apVoorkeurPK.osnr = :osnr")
    , @NamedQuery(name = "ApVoorkeur.findByVoorkeur", query = "SELECT a FROM ApVoorkeur a WHERE a.voorkeur = :voorkeur")})
public class ApVoorkeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApVoorkeurPK apVoorkeurPK;
    @Column(name = "voorkeur")
    private Character voorkeur;

    public ApVoorkeur() {
    }

    public ApVoorkeur(ApVoorkeurPK apVoorkeurPK) {
        this.apVoorkeurPK = apVoorkeurPK;
    }

    public ApVoorkeur(int vsnr, int osnr) {
        this.apVoorkeurPK = new ApVoorkeurPK(vsnr, osnr);
    }

    public ApVoorkeurPK getApVoorkeurPK() {
        return apVoorkeurPK;
    }

    public void setApVoorkeurPK(ApVoorkeurPK apVoorkeurPK) {
        this.apVoorkeurPK = apVoorkeurPK;
    }

    public Character getVoorkeur() {
        return voorkeur;
    }

    public void setVoorkeur(Character voorkeur) {
        this.voorkeur = voorkeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apVoorkeurPK != null ? apVoorkeurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApVoorkeur)) {
            return false;
        }
        ApVoorkeur other = (ApVoorkeur) object;
        if ((this.apVoorkeurPK == null && other.apVoorkeurPK != null) || (this.apVoorkeurPK != null && !this.apVoorkeurPK.equals(other.apVoorkeurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.ApVoorkeur[ apVoorkeurPK=" + apVoorkeurPK + " ]";
    }
    
}
