/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionBeans.GroepenLocal;

/**
 *
 * @author student
 */
public class Controller extends HttpServlet {

    @EJB
    private GroepenLocal groepen;
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
        if(request.isUserInRole("student")){
            sessie.setAttribute("unr", request.getUserPrincipal().getName());
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            Collection studenten = groepen.getUsers();
            sessie.setAttribute("studenten", studenten);
            goToPage("student.jsp", request, response);
        }
        else if(request.isUserInRole("docent")){
            goToPage("docent.jsp", request, response);
        }
        switch (request.getParameter("komvan")){
            case "index":
                {
                    goToPage("aanloggen.jsp", request, response);
                    break;
                }
            case "student":
                {                    
                    goToPage("bevestiging.jsp", request, response);
                }
            case "studoverzicht":
                {
                    goToPage("studoverzicht.jsp", request, response);
                }
            case "docenttonieuw":
                {
                    goToPage("nieuwegroep.jsp", request, response);
                }
            case "docenttobewerk":
                {
                    goToPage("bewerkgroep.jsp", request, response);
                }
        }
        if(request.getParameter("verwijder") != null){
            groepen.removeVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("verwijder"));
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            goToPage("student.jsp", request, response);
        }
        if(request.getParameter("wel") != null){
            groepen.maakVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("wel"), 'J');
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            goToPage("student.jsp", request, response);
        }
        if(request.getParameter("niet") != null){
            groepen.maakVoorkeur(sessie.getAttribute("unr").toString(), request.getParameter("niet"), 'N');
            Collection voorkeuren = groepen.getVoorkeur(sessie.getAttribute("unr").toString());
            sessie.setAttribute("voorkeuren", voorkeuren);
            goToPage("student.jsp", request, response);
        }
    }
    
    public void goToPage(String s, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(s);
        view.forward(request, response);
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