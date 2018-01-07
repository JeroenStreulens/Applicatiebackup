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
