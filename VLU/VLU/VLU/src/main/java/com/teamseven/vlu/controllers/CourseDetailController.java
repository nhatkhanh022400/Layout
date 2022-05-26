package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.CourseDetailFacade;
import com.teamseven.vlu.dbo.CourseFacade;
import com.teamseven.vlu.dbo.MentorFacade;
import com.teamseven.vlu.dbo.UnFinishedCourseFacade;
import com.teamseven.vlu.models.Course;
import com.teamseven.vlu.models.CourseDetail;
import com.teamseven.vlu.models.LearnerAccount;
import com.teamseven.vlu.models.Mentor;
import com.teamseven.vlu.models.UnFinishedCourse;
import com.teamseven.vlu.utils.FunctionRandom;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CourseDetailController extends HttpServlet {

    private static final String COURSE_DETAIL = "COURSE_DETAIL";
    private static final String COURSE = "COURSE";
    private static final String MENTOR = "MENTOR";
    private static final String HAS_ENROLL = "HAS_ENROLL";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String detailCourse = request.getParameter("cid");
            HttpSession session = request.getSession();

            CourseDetailFacade courseDetailFacade = new CourseDetailFacade();
            CourseFacade courseFacade = new CourseFacade();
            MentorFacade mentorFacade = new MentorFacade();
            UnFinishedCourseFacade unFinishedCourseFacade = new UnFinishedCourseFacade();

            CourseDetail courseDetail;
            Course course;
            Mentor mentor;

            if (detailCourse != null) {
                courseDetail = courseDetailFacade.getCourseDetail(detailCourse);
                if (session.getAttribute("LOGIN_USER") != null) {
                    LearnerAccount learnerAccount = (LearnerAccount) session.getAttribute("LOGIN_USER");
                    UnFinishedCourse checkUnFinishedCourse = unFinishedCourseFacade.checkUnFinishedCourse(detailCourse, learnerAccount.getLearnerID());
                    if (checkUnFinishedCourse == null) {
                        request.setAttribute(HAS_ENROLL, null);
                    } else {
                        request.setAttribute(HAS_ENROLL, HAS_ENROLL);
                    }
                }
                
                course = courseFacade.checkCourse(detailCourse);
                mentor = mentorFacade.getMentor(course.getMentorID());
                request.setAttribute(MENTOR, mentor);
                request.setAttribute(COURSE_DETAIL, courseDetail);
                request.setAttribute(COURSE, course);
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/CourseDetail.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String userID = request.getParameter("UserID");
            String courseID = request.getParameter("CourseID");
            String unFinishedCourseID = FunctionRandom.randomID(10);

            UnFinishedCourseFacade unFinishedCourseFacade = new UnFinishedCourseFacade();
            UnFinishedCourse unFinishedCourse = new UnFinishedCourse();

            if (userID != null && courseID != null) {
                UnFinishedCourse checkUnFinishedCourse = unFinishedCourseFacade.checkUnFinishedCourse(courseID, userID);

                if (checkUnFinishedCourse == null) {
                    unFinishedCourse.setUnFinishedCourseID(unFinishedCourseID);
                    unFinishedCourse.setCourseID(courseID);
                    unFinishedCourse.setLearnerID(userID);

                    unFinishedCourseFacade.addUnFinishedCourse(unFinishedCourse);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
