/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient;

import javax.ejb.EJB;
import sessionBeans.GroepenRemote;
import java.io.*;
import java.util.*;

/**
 *
 * @author jeroe
 */
public class Main {
    
    @EJB
    private static GroepenRemote groepen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        printGroepen(groepen);
    }
    
    public static void printGroepen(GroepenRemote groepen){
        int maxGroepnr = groepen.getNieuwGroepNr();
        ArrayList<String> namen = new ArrayList<>();
        try {
            PrintWriter w = new PrintWriter(new FileWriter("groepen.txt"));
            w.println("Groepsindeling");
            for(int i = 0; i < maxGroepnr; i++){
                namen = groepen.getStudentNamen(i);
                for(int j = 0; j < namen.size(); j++){
                    w.println(" -" + namen.get(j));
                }
            }
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
}
