/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import java.util.*;
import javax.persistence.*;
import entityBeans.*;

/**
 *
 * @author woute
 */
@Stateless
public class Groepen implements GroepenLocal {

    @PersistenceContext
    private EntityManager em;
    
    public Collection getUsers(){
        /*Collection users = null;
        Query q1 = em.createNamedQuery("ApRollen.findByRol");
        q1.setParameter("rol", "student");
        ArrayList<ApRollen> studenten = new ArrayList<ApRollen>(q1.getResultList());
        Query q2 = em.createNamedQuery("ApUsers.findByUnr");
        for(int i = 0; i < studenten.size(); i++){
            q2.setParameter("unr", studenten.get(i).getUnr());
            users.add(q2.getSingleResult());
        }
        return users;*/
        return em.createNamedQuery("ApUsers.findAll").getResultList();
    }
    
    public Collection getStudenten(){
        List users = new ArrayList();
        Query q1 = em.createNamedQuery("ApRollen.findByRol");
        q1.setParameter("rol", "student");
        ArrayList<ApRollen> studenten = new ArrayList<ApRollen>();
        List lijst = q1.getResultList();
        for (Iterator<ApRollen> iter = lijst.iterator(); iter.hasNext(); ) {
            studenten.add(iter.next());
        }

        for(int i = 0; i < studenten.size(); i++){
            Query q2 = em.createNamedQuery("ApUsers.findByUnr");
            q2.setParameter("unr", studenten.get(i).getUnr());
            users.add(q2.getSingleResult());
        }
        return users;
        
    }
    
    public Collection getDocenten(Collection studenten){
        List docenten=em.createNamedQuery("ApUsers.findAll").getResultList();
        docenten.removeAll(studenten);
        return docenten;        
    }
    
    public void maakVoorkeur(String snr, String osnr, char voorkeur){
        ApVoorkeur maak = new ApVoorkeur(Integer.parseInt(snr), Integer.parseInt(osnr));
        maak.setVoorkeur(voorkeur);
        em.persist(maak);
    }
    
    public Collection getVoorkeur(String snr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnr");
        q.setParameter("vsnr", Integer.parseInt(snr));
        for(int i = 0; i < q.getResultList().size(); i++){
            System.out.println(q.getResultList().get(i).toString());
        }
        return q.getResultList();
    }
    
    public void removeVoorkeur(String vsnr, String osnr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        q.setParameter("vsnr", Integer.parseInt(vsnr));
        q.setParameter("osnr", Integer.parseInt(osnr));
        System.out.println(q.getSingleResult().toString());
        em.remove(q.getSingleResult());
    }
    
    /**public List welkeProblemen(List<ApGroepen> studenten){
        if(studenten.size()==0){
            return new ArrayList<ApVoorkeur>();
        }
        List problemen = new ArrayList<ApVoorkeur>();
        
        for(int i=0;i<studenten.size();i++){
            List tijdelijkelijst = new ArrayList<ApVoorkeur>();
            Query q = em.createNamedQuery("ApVoorkeur.findByVsnr");
            q.setParameter("vsnr", studenten.get(i).getApGroepenPK().getGsnr());
            tijdelijkelijst.addAll(q.getResultList());
            for(int j=0;j<tijdelijkelijst.size();j++){
                ApVoorkeur tijdelijkevk = (ApVoorkeur)tijdelijkelijst.get(j);
                int ontvanger = tijdelijkevk.getApVoorkeurPK().getOsnr();
                for(int k=0; k<studenten.size();k++){
                    if(tijdelijkevk.getVoorkeur()=='N'){
                        if(ontvanger==studenten.get(k).getApGroepenPK().getGsnr()){
                            problemen.add(tijdelijkevk);
                            break;
                        }
                    }
                }
                
            }
        }
        for(int i=0;i<studenten.size();i++){
            List tijdelijkelijst = new ArrayList<ApVoorkeur>();
            Query q = em.createNamedQuery("ApVoorkeur.findByOsnr");
            q.setParameter("osnr", studenten.get(i).getApGroepenPK().getGsnr());
            tijdelijkelijst.addAll(q.getResultList()); //bevat een lijst van studenten die al dan niet met student(i) in de groep willen zitten
           
            for(int j=0;j<tijdelijkelijst.size();j++){//loop over de voorkeuren van 1 student
                boolean ingroep=false;
                ApVoorkeur tijdelijkevk = (ApVoorkeur)tijdelijkelijst.get(j);
                int vrager = tijdelijkevk.getApVoorkeurPK().getVsnr();
                if(tijdelijkevk.getVoorkeur()=='J'){ //Is er een persoon die met de student in de groep wil zitten, zo ja...
                    for(int k=0; k<studenten.size();k++){//Kijken of de student die met hem in de groep wil zitten, in de groep zit
                        if(vrager==studenten.get(k).getApGroepenPK().getGsnr()){
                            ingroep=true;
                            break;
                        }
                    }
                    if(!ingroep){
                        problemen.add(tijdelijkevk);
                    }
                }
            }
        }
        
    return problemen;
    }
    **/
        public List welkeProblemen(List<ApGroepen> studenten){
        if(studenten.size()==0){
            return new ArrayList<String>();
        }
        List problemen = new ArrayList<String>();
        
        for(int i=0;i<studenten.size();i++){
            List tijdelijkelijst = new ArrayList<ApVoorkeur>();
            Query q = em.createNamedQuery("ApVoorkeur.findByVsnr");
            int vrager=studenten.get(i).getApGroepenPK().getGsnr();
            q.setParameter("vsnr", vrager);
            tijdelijkelijst.addAll(q.getResultList());
            for(int j=0;j<tijdelijkelijst.size();j++){
                ApVoorkeur tijdelijkevk = (ApVoorkeur)tijdelijkelijst.get(j);
                int ontvanger = tijdelijkevk.getApVoorkeurPK().getOsnr();
 
                for(int k=0; k<studenten.size();k++){
                    if(tijdelijkevk.getVoorkeur()=='N'){
                        if(ontvanger==studenten.get(k).getApGroepenPK().getGsnr()){ 
                            String s = this.unrToName(vrager)+" wil niet in de groep zitten met "+this.unrToName(ontvanger);
                            problemen.add(s);
                            break;
                        }
                    }
                }
                
            }
        }
        for(int i=0;i<studenten.size();i++){
            List tijdelijkelijst = new ArrayList<ApVoorkeur>();
            Query q = em.createNamedQuery("ApVoorkeur.findByOsnr");
            int ontvanger = studenten.get(i).getApGroepenPK().getGsnr();
            q.setParameter("osnr",ontvanger);
            tijdelijkelijst.addAll(q.getResultList()); //bevat een lijst van studenten die al dan niet met student(i) in de groep willen zitten
           
            for(int j=0;j<tijdelijkelijst.size();j++){//loop over de voorkeuren van 1 student
                boolean ingroep=false;
                ApVoorkeur tijdelijkevk = (ApVoorkeur)tijdelijkelijst.get(j);
                int vrager = tijdelijkevk.getApVoorkeurPK().getVsnr();
                if(tijdelijkevk.getVoorkeur()=='J'){ //Is er een persoon die met de student in de groep wil zitten, zo ja...
                    for(int k=0; k<studenten.size();k++){//Kijken of de student die met hem in de groep wil zitten, in de groep zit
                        if(vrager==studenten.get(k).getApGroepenPK().getGsnr()){
                            ingroep=true;
                            break;
                        }
                    }
                    if(!ingroep){
                        String s = this.unrToName(vrager)+" wil in de groep zitten met "+this.unrToName(ontvanger);
                        problemen.add(s);
                    }
                }
            }
        }
        
    return problemen;
    }
    
    public String unrToName(int unr){
        Query q = em.createNamedQuery("ApUsers.findByUnr");
        q.setParameter("unr", unr);
        ApUsers student = (ApUsers)q.getSingleResult();
        return student.getUnaam();
    }
    
    public int nameToUnr(String naam){
        Query q = em.createNamedQuery("ApUsers.findByUnaam");
        q.setParameter("unaam", naam);
        ApUsers student = (ApUsers)q.getSingleResult();
        return student.getUnr();
    }
    
    public Collection groepToNamen(List<ApGroepen> groepobjecten){
        List namen=new ArrayList();
        for(int i = 0; i < groepobjecten.size(); i++){
            Query q = em.createNamedQuery("ApUsers.findByUnr");
            q.setParameter("unr", groepobjecten.get(i).getApGroepenPK().getGsnr());
            namen.add(q.getSingleResult());
        }
        return namen;
    }
    
    public Integer getGroepnrvanStudent(Integer unr){
        Query q = em.createNamedQuery("ApGroepen.findByGsnr");
        q.setParameter("gsnr", unr);
        ApGroepen groep = (ApGroepen)q.getSingleResult();
        int groepnr = groep.getApGroepenPK().getGnr();
        return groepnr;
    }
    
    public List getStudentenMetGnr(Integer gnr){
        Query q = em.createNamedQuery("ApGroepen.findByGnr");
        q.setParameter("gnr", gnr);
        List studenten = new ArrayList<ApGroepen>();
        studenten.addAll(q.getResultList());
        return studenten;
    }
    
    public int getNieuwGroepNr(){
    int groepnr;
    groepnr=(int)em.createNamedQuery("ApGroepen.findMaxgrp").getSingleResult();
    groepnr+=1;
    int nieuwgroepnr=0;
    for(int i=1; i<=groepnr; i++){
        Query q = em.createNamedQuery("ApGroepen.findByGnr");
        q.setParameter("gnr", i);
        List resultaat = q.getResultList();
        if(resultaat.isEmpty()){
            nieuwgroepnr=i;
            break;
        }
        else{
            continue;
        }
    }
    return nieuwgroepnr;
    }
    
    public Collection getGroepen(){
        return em.createNamedQuery("ApGroepen.findGnr").getResultList();
    }
    
    public Collection studentenZonderGroep(Collection studenten){
        List lijst=em.createNamedQuery("ApGroepen.findallstudents").getResultList();
        List toRemove=new ArrayList();
        for (Iterator<Integer> iter = lijst.iterator(); iter.hasNext(); ) {
            ApUsers nieuw = new ApUsers(iter.next());
            toRemove.add(nieuw);
        }
        studenten.removeAll(toRemove);
        return studenten;
        }
    
    public Collection studentenInGroep(){
         return em.createNamedQuery("ApGroepen.findallstudents").getResultList();
    }
    
    public void voegGroepToe(Integer groepnr, int studentnr){
        ApGroepen nieuw = new ApGroepen(groepnr, studentnr);
        em.persist(nieuw);
    }
    
    public void verwijderUitGroep(Integer student){
        Query q = em.createNamedQuery("ApGroepen.findByGsnr");
        q.setParameter("gsnr", student);
        em.remove(q.getSingleResult());        
    }
    
    public int aantalStudenten(Collection lijst){
        int aantal=lijst.size();
        return aantal;
    }
    
    public void bevestigGroepen(Integer docent){
        Query q = em.createNamedQuery("ApUsers.findByUnr");
        q.setParameter("unr", docent);
        ApUsers docentobject = (ApUsers)q.getSingleResult();
        docentobject.setBevestigd('j');
        em.persist(docentobject);
    }
    
    public boolean controlebevestigd(){
        boolean bevestigd = false;
        Query q = em.createNamedQuery("ApRollen.findByRol");
        q.setParameter("rol", "docent");
        ArrayList<ApRollen> docentnr = new ArrayList<ApRollen>();
        docentnr.addAll(q.getResultList());
        for(int i=0;i<docentnr.size();i++){
            int unr=docentnr.get(i).getUnr();
            Query q2 = em.createNamedQuery("ApUsers.findByUnr");
            q2.setParameter("unr", unr);
            ApUsers docent = (ApUsers)q2.getSingleResult();
            if(docent.getBevestigd()=='j'){
                bevestigd=true;
                break;
            }
        }
        return bevestigd;
    }
}
    
    //public void getGroepNr(){
     //   Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        //q.setParameter("vsnr", Integer.parseInt(vsnr));
        //q.setParameter("osnr", Integer.parseInt(osnr));
    //}
