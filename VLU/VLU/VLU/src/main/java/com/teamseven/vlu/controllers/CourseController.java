package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.CourseFacade;
import com.teamseven.vlu.dbo.MentorFacade;
import com.teamseven.vlu.models.Course;
import com.teamseven.vlu.models.Mentor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class CourseController extends HttpServlet {
    
    private static final String UPCOMING_COURSE_LIST = "UPCOMING_COURSE_LIST";
    private static final String EXISTING_COURSE_LIST = "EXISTING_COURSE_LIST";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            CourseFacade courseFacade = new CourseFacade();
            MentorFacade mentorFacade = new MentorFacade();
            List<Course> upcomingCourseList = courseFacade.getCourse(0);
            List<Course> existingCourseList = courseFacade.getCourse(1);
            
            if (upcomingCourseList.isEmpty()) {
                request.setAttribute(UPCOMING_COURSE_LIST, null);
            } else {
                for (int i = 0; i < upcomingCourseList.size(); i++) {
                    Mentor mentor = mentorFacade.getMentor(upcomingCourseList.get(i).getMentorID());
                    if (upcomingCourseList.get(i).getMentorID().equals(mentor.getMentorID())) {
                        upcomingCourseList.get(i).setMentorID(mentor.getMentorName());
                    }
                }
                
                JSONArray jsArray = new JSONArray(upcomingCourseList);
                request.setAttribute(UPCOMING_COURSE_LIST, jsArray.toString());
            }
            
            if (existingCourseList.isEmpty()) {
                request.setAttribute(EXISTING_COURSE_LIST, null);
            } else {
                for (int i = 0; i < existingCourseList.size(); i++) {
                    Mentor mentor = mentorFacade.getMentor(existingCourseList.get(i).getMentorID());
                    if (existingCourseList.get(i).getMentorID().equals(mentor.getMentorID())) {
                        existingCourseList.get(i).setMentorID(mentor.getMentorName());
                    }
                }
                
                JSONArray jsArray = new JSONArray(existingCourseList);
                request.setAttribute(EXISTING_COURSE_LIST, jsArray.toString());
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Course.jsp");
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
