/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.*;
import javax.ejb.Remote;

/**
 *
 * @author woute
 */
@Remote
public interface GroepenRemote {
    
    public Collection getStudenten();
    public void maakVoorkeur(String snr, String osnr, char voorkeur);
    public Collection getVoorkeur(String snr);
    public void removeVoorkeur(String vsnr, String osnr);
    public boolean getBevestigd(String unr);
    public void setBevestig(String unr);
    public int getNieuwGroepNr();
    public Collection studentenZonderGroep(Collection studenten);
    public Collection studentenInGroep();
    public List getStudentenMetGnr(Integer gnr);
    public void voegGroepToe(Integer groepnr, int studentnr);
    public Collection getGroepen();
    public ArrayList<String> getStudentNamen(Integer gnr);
    public String getStudentNaam(Integer unr);         
    
}
