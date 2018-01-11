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

    public List welkeProblemen(List studenten);
    public int nameToUnr(String naam);
    public Collection groepToNamen(List groepobjecten);

    public int getNieuwGroepNr();
    public Collection studentenZonderGroep(Collection studenten);
    public Collection studentenInGroep();
    public Integer getGroepnrvanStudent(Integer unr);
    public List getStudentenMetGnr(Integer gnr);
    public void voegGroepToe(Integer groepnr, int studentnr);
    public void verwijderUitGroep(Integer student);
    public Map<Integer,Integer> getGroepen();
    public int aantalStudenten(Collection lijst);
    public void bevestigGroepen(Integer docent);
    public boolean controlebevestigd();
    public ArrayList<String> getStudentNamen(Integer gnr);
    public String getStudentNaam(Integer unr);         
    }
