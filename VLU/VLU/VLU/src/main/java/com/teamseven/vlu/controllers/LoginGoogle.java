package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.LearnerAccountFacade;
import com.teamseven.vlu.models.GoogleAccount;
import com.teamseven.vlu.models.LearnerAccount;
import com.teamseven.vlu.utils.FunctionRandom;
import com.teamseven.vlu.utils.RestGoogle;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginGoogle extends HttpServlet {

    private static final String LOGIN_USER = "LOGIN_USER";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String googleCode = request.getParameter("code");
            String accessToken = RestGoogle.getGoogleToken(googleCode);
            GoogleAccount googleAccount = RestGoogle.getGoogleUserInfo(accessToken);

            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();
            HttpSession session = request.getSession();
            
            LearnerAccount checkLearnerAccount = learnerAccountFacade.getLearnerAccount(googleAccount.getEmail());

            if (checkLearnerAccount == null) {
                LearnerAccount learnerAccount = new LearnerAccount();
                
                learnerAccount.setLearnerID(FunctionRandom.randomID(10));
                learnerAccount.setEmail(googleAccount.getEmail());
                learnerAccount.setImageAvatar(googleAccount.getPicture());
                learnerAccountFacade.addLearner(learnerAccount);
                
                session.setAttribute(LOGIN_USER, learnerAccount);
            } else {
                session.setAttribute(LOGIN_USER, checkLearnerAccount);
            }

            response.sendRedirect(request.getContextPath() + "/home");

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
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
