/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Other.Voorkeur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionBeans.GroepenRemote;

/**
 *
 * @author student
 */
public class Controller extends HttpServlet {

    @EJB
    private GroepenRemote groepen;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessie = request.getSession();
        Collection studenten = groepen.getStudenten();
        Collection studenteningroep = groepen.studentenInGroep();
        sessie.setAttribute("studenten", studenten);
        sessie.setAttribute("studenteningroep",studenteningroep);
        
        if(request.getParameter("komvan") == null){
            sessie = request.getSession();
            studenten = groepen.getStudenten();
            sessie.setAttribute("studenten", studenten);
            System.out.println("Aanmelden");
            if(request.isUserInRole("student")){
                sessie.setAttribute("unr", request.getUserPrincipal().getName());
                Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
                sessie.setAttribute("voorkeuren", voorkeuren);
                System.out.println("Voorkeuren");
                for(Iterator it = voorkeuren.iterator(); it.hasNext();){
                    System.out.println(it.next());
                }
                if(groepen.getBevestigd(sessie.getAttribute("unr").toString()) == true){
                    goToPage("bevestiging.jsp", request, response);
                }
                else{
                    goToPage("student.jsp", request, response);
                }
            }
            else if(request.isUserInRole("docent")){
                sessie.setAttribute("unr", request.getUserPrincipal().getName());
                sessie.setAttribute("groepnrsverzameling",groepen.getGroepen());
                sessie.setAttribute("studentenzgroep",groepen.studentenZonderGroep(studenten));
                goToPage("docent.jsp", request, response);
            }
        }
        
        else{
            switch (request.getParameter("komvan")){
                case "index":
                    {
                        goToPage("aanloggen.jsp", request, response);
                        break;
                    }
                case "student":
                    {                    
                        goToPage("studoverzicht.jsp", request, response);
                        System.out.println("De student wil bevestigen");
                        break;
                    }
                case "studoverzicht":
                    {
                        goToPage("bevestiging.jsp", request, response);
                        System.out.println("De student heeft bevestigd");
                        groepen.setBevestig(sessie.getAttribute("unr").toString());
                        break;
                    }
                case "docenttonieuw":
                    {
                        sessie.setAttribute("groepnr", groepen.getNieuwGroepNr());
                        sessie.setAttribute("studentenzgroep",groepen.studentenZonderGroep(studenten));
                        sessie.setAttribute("studentindezegroep", new ArrayList());
                        goToPage("bewerkgroep.jsp", request, response);
                        break;
                    }
                case "docenttobewerk":
                    {
                        sessie.setAttribute("groepnr", Integer.parseInt(request.getParameter("groepnr")));
                        sessie.setAttribute("studentindezegroep", groepen.getStudentenMetGnr((Integer)sessie.getAttribute("groepnr")));
                        goToPage("bewerkgroep.jsp", request, response);
                        break;
                    }
                case "meer":
                    {
                        goToPage("student.jsp", request, response);
                        break;
                    }
                case "afmelden":
                    {
                        System.out.println("Afmelden");
                        System.out.println(sessie.getAttribute("unr"));
                        sessie.invalidate();
                        newRequest("ctrl.do", request, response);
                        return;
                    }
                case "bewerktobewerk":
                    {
                        String nummers = request.getParameter("select");
                        int nummeri=Integer.parseInt(nummers);
                        
                        groepen.voegGroepToe(((Integer)sessie.getAttribute("groepnr")),nummeri );
                        sessie.setAttribute("studentenzgroep",groepen.studentenZonderGroep(studenten));
                        sessie.setAttribute("studentindezegroep", groepen.getStudentenMetGnr((Integer)sessie.getAttribute("groepnr")));
                        goToPage("bewerkgroep.jsp", request, response);
                        break;
                    }
                case "bewerktodocent":
                    {
                        sessie.setAttribute("groepnrsverzameling",groepen.getGroepen());
                        goToPage("docent.jsp", request, response);
                        break;
                    }
                default:
                    break;

            }
        }
        
        if(request.getParameter("verwijder") != null){
            groepen.removeVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("verwijder"));
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            System.out.println("De student heeft een voorkeur verwijderd");
            goToPage("student.jsp", request, response);

        }

        if(request.getParameter("knop") != null){
            if("wel".equals(request.getParameter("knop"))){
                groepen.maakVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("sel"), 'J');
            }
            if("niet".equals(request.getParameter("knop"))){
                groepen.maakVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("sel"), 'N');
            }
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            System.out.println("De student heeft een voorkeur toegevoegd");
            goToPage("student.jsp", request, response);
        }
    }
    
    public void goToPage(String s, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(s);
        view.forward(request, response);
    }
    
    public void newRequest(String s, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect(s);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}