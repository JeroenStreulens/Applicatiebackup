/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entityBeans.ApGroepen;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author woute
 */
@Local
public interface GroepenLocal {
    
    public Collection getUsers();
    public Collection getStudenten();
    public void maakVoorkeur(String snr, String osnr, char voorkeur);
    public Collection getVoorkeur(String snr);
    public void removeVoorkeur(String vsnr, String osnr);
    public List welkeProblemen(List<ApGroepen> studenten);
    public int nameToUnr(String naam);
    public Collection groepToNamen(List<ApGroepen> groepobjecten);
    public int getNieuwGroepNr();
    public Collection studentenZonderGroep(Collection studenten);
    public Collection studentenInGroep();
    public Integer getGroepnrvanStudent(Integer unr);
    public List getStudentenMetGnr(Integer gnr);
    public void voegGroepToe(Integer groepnr, int studentnr);
    public void verwijderUitGroep(Integer student);
    public Collection getGroepen();
    public int aantalStudenten(Collection lijst);
    public void bevestigGroepen(Integer docent);
    public boolean controlebevestigd();
}
