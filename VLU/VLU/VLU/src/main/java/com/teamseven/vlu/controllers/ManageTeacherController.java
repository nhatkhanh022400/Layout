package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.MentorFacade;
import com.teamseven.vlu.models.Mentor;
import com.teamseven.vlu.utils.FunctionRandom;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class ManageTeacherController extends HttpServlet {

    private static final String MENTOR_LIST = "MENTOR_LIST";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            MentorFacade mentorFacade = new MentorFacade();
            List<Mentor> mentorList = mentorFacade.getAllMentor();

            if (mentorList.isEmpty()) {
                request.setAttribute(MENTOR_LIST, null);
            } else {
                JSONArray jsArray = new JSONArray(mentorList);
                request.setAttribute(MENTOR_LIST, jsArray.toString());
            }
            
            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ManageTeacher.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try {
            //Value Add
            String mentorName = request.getParameter("MentorName");
            String mentorPhone = request.getParameter("MentorPhone");
            String mentorEmail = request.getParameter("MentorEmail");
            String mentorID = FunctionRandom.randomID(10);

            //Value Delete
            String getMentorID = request.getParameter("MentorID");

            //Value Update
            String updateMentorID = request.getParameter("UpdateMentorID");
            String updateMentorName = request.getParameter("UpdateMentorName");
            String updateMentorPhone = request.getParameter("UpdateMentorPhone");
            String updateMentorEmail = request.getParameter("UpdateMentorEmail");

            Mentor mentor = new Mentor();
            MentorFacade mentorFacade = new MentorFacade();

            if (mentorName != null && mentorPhone != null && mentorEmail != null) {
                Mentor checkMentor = mentorFacade.getMentor(mentorID);
                if (checkMentor == null) {
                    mentor.setMentorID(mentorID);
                    mentor.setMentorName(mentorName);
                    mentor.setMentorPhone(mentorPhone);
                    mentor.setMentorEmail(mentorEmail);

                    mentorFacade.addMentor(mentor);
                }
            } else if (getMentorID != null) {
                mentorFacade.deleteMentor(getMentorID);
            } else if (updateMentorID != null && updateMentorName != null && updateMentorPhone != null && updateMentorEmail != null) {
                mentor.setMentorID(updateMentorID);
                mentor.setMentorName(updateMentorName);
                mentor.setMentorPhone(updateMentorPhone);
                mentor.setMentorEmail(updateMentorEmail);

                mentorFacade.updateMentor(mentor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
