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
        Query q = em.createNamedQuery("ApUsers.findByUnr");
        q.setParameter("unr", Integer.parseInt(snr));
        ApVoorkeur maak = new ApVoorkeur(Integer.parseInt(snr), Integer.parseInt(osnr));
        maak.setVoorkeur(voorkeur);
        em.persist(maak);
    }
    
    public Collection getVoorkeur(String snr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnr");
        q.setParameter("vsnr", Integer.parseInt(snr));
        return q.getResultList();
    }
    
    public void removeVoorkeur(String vsnr, String osnr){
        Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        q.setParameter("vsnr", Integer.parseInt(vsnr));
        q.setParameter("osnr", Integer.parseInt(osnr));
        em.remove(q.getSingleResult());
    }
    
    public int getGroepNr(){
    int groepnr;
    groepnr=(int)em.createNamedQuery("ApGroepen.findMaxgrp").getSingleResult();
    groepnr+=1;
    return groepnr;
    }
    
    public Collection studentenZonderGroep(Collection studenten){
        Collection col=em.createNamedQuery("ApGroepen.findallstudents").getResultList();
        Iterator<>it=col.iterator();
        while (it.hasNext()){
            col.removeAll(col(it.next()));
        }
    }
    
    //public void getGroepNr(){
     //   Query q = em.createNamedQuery("ApVoorkeur.findByVsnrOsnr");
        //q.setParameter("vsnr", Integer.parseInt(vsnr));
        //q.setParameter("osnr", Integer.parseInt(osnr));
    //}
}
