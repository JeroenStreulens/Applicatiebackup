/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import Other.Voorkeur;
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
    
    public void maakVoorkeur(String snr, String osnr, char voorkeur){
        ApVoorkeur maak = new ApVoorkeur(Integer.parseInt(snr), Integer.parseInt(osnr));
        maak.setVoorkeur(voorkeur);
        em.persist(maak);
    }
    
    public Collection getVoorkeur(String snr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnr");
        q.setParameter("vsnr", Integer.parseInt(snr));
        Query naam = em.createNamedQuery("ApUsers.findByUnr");
        Collection voorkeuren = q.getResultList();
        ArrayList<Object> vk = new ArrayList<>();
        vk.addAll(voorkeuren);
        ArrayList<Voorkeur> voorkeur = new ArrayList<>();
        System.out.println("EJB");
        for(int i = 0; i < vk.size(); i++){
            ApVoorkeur ap = (ApVoorkeur) vk.get(i);
            Voorkeur v = new Voorkeur(Integer.parseInt(snr), ap.getApVoorkeurPK().getOsnr(), (char)ap.getVoorkeur());
            naam.setParameter("unr", ap.getApVoorkeurPK().getOsnr());
            v.setNaam(((ApUsers)naam.getSingleResult()).getUnaam());
            System.out.println(v);
            voorkeur.add(v);
        }
        return voorkeur;
    }
    
    public void removeVoorkeur(String vsnr, String osnr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        q.setParameter("vsnr", Integer.parseInt(vsnr));
        q.setParameter("osnr", Integer.parseInt(osnr));
        System.out.println(q.getSingleResult().toString());
        em.remove(q.getSingleResult());
    }
   
    public boolean getBevestigd(String unr){
        Query q = em.createNamedQuery("ApUsers.findByUnr");
        q.setParameter("unr", Integer.parseInt(unr));
        ApUsers gebruiker = ((ApUsers) q.getSingleResult());
        if(gebruiker.getBevestigd().equals(new Character('j'))){
            return true;
        }
        else{
            return false;
        } 
    }
    public void setBevestig(String unr){
         Query q = em.createNamedQuery("ApUsers.findByUnr");
         q.setParameter("unr", Integer.parseInt(unr));
         ApUsers gebruiker = ((ApUsers) q.getSingleResult());
         gebruiker.setBevestigd(new Character('j'));
         em.persist(gebruiker);
    }

    public int getNieuwGroepNr(){
    int groepnr;
    groepnr=(int)em.createNamedQuery("ApGroepen.findMaxgrp").getSingleResult();
    groepnr+=1;
    return groepnr;
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
    
    public Collection getStudentenMetGnr(Integer gnr){
        Query q = em.createNamedQuery("ApGroepen.findByGnr");
        q.setParameter("gnr", gnr);
        return q.getResultList();
    }
}
    
    //public void getGroepNr(){
     //   Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        //q.setParameter("vsnr", Integer.parseInt(vsnr));
        //q.setParameter("osnr", Integer.parseInt(osnr));
    //}
