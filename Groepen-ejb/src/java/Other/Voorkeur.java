/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

/**
 *
 * @author woute
 */
public class Voorkeur {
    
    private int vsnr;
    private int osnr;
    private char voorkeur;
    private String naam;
    
    public Voorkeur(int vnr, int onr, char v, String n){
        vsnr = vnr;
        osnr = onr;
        voorkeur = v;
        naam = n;
    }

    public Voorkeur(int vnr, int onr, char c) {
        vsnr = vnr;
        osnr = onr;
        voorkeur = c;
        naam = null;
    }

    public int getVsnr() {
        return vsnr;
    }

    public int getOsnr() {
        return osnr;
    }

    public char getVoorkeur() {
        return voorkeur;
    }

    public String getNaam() {
        return naam;
    }
    
    public void setNaam(String s){
        naam = s;
    }
    
    
}
