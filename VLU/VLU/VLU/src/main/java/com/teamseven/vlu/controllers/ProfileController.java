package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.CompletedCourseFacade;
import com.teamseven.vlu.dbo.DepartmentFacade;
import com.teamseven.vlu.dbo.LearnerAccountFacade;
import com.teamseven.vlu.dbo.OtherCourseFacade;
import com.teamseven.vlu.models.CompletedCourse;
import com.teamseven.vlu.models.Department;
import com.teamseven.vlu.models.LearnerAccount;
import com.teamseven.vlu.models.OtherCourse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;

public class ProfileController extends HttpServlet {

    private static final String LOGIN_USER = "LOGIN_USER";
    private static final String DEPARTMENT = "DEPARTMENT";
    private static final String LIST_OTHER_COURSE = "LIST_OTHER_COURSE";
    private static final String LIST_COMPLETE_COURSE = "LIST_COMPLETE_COURSE";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            LearnerAccount loginUser = (LearnerAccount) session.getAttribute(LOGIN_USER);

            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();
            DepartmentFacade departmentFacade = new DepartmentFacade();
            OtherCourseFacade otherCourseFacade = new OtherCourseFacade();
            CompletedCourseFacade completedCourseFacade = new CompletedCourseFacade();
            LearnerAccount learnerAccount = learnerAccountFacade.getLearnerAccount(loginUser.getEmail());
            
            if (learnerAccount.getDepartmentID() != null) {
                Department department = departmentFacade.getDepartmentWithID(learnerAccount.getDepartmentID());
                request.setAttribute(DEPARTMENT, department.getDepartmentName());
            }
            
            List<OtherCourse> otherCourse = otherCourseFacade.getOtherCourse(learnerAccount.getLearnerID());
            List<CompletedCourse> completedCourse = completedCourseFacade.getAllCompletedCourse(learnerAccount.getLearnerID());

            session.setAttribute(LOGIN_USER, learnerAccount);
            
            if (otherCourse.isEmpty()) {
                request.setAttribute(LIST_OTHER_COURSE, null);
            } else {
                JSONArray jsArray = new JSONArray(otherCourse);
                request.setAttribute(LIST_OTHER_COURSE, jsArray.toString());
            }
            
            if (completedCourse.isEmpty()) {
                request.setAttribute(LIST_COMPLETE_COURSE, null);
            } else {
                JSONArray jsArray = new JSONArray(completedCourse);
                request.setAttribute(LIST_COMPLETE_COURSE, jsArray.toString());
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Profile.jsp");
            requestDispatcher.forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
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
