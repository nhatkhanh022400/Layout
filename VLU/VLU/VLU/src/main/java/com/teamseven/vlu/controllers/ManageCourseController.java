package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.CourseDetailFacade;
import com.teamseven.vlu.dbo.CourseFacade;
import com.teamseven.vlu.dbo.MentorFacade;
import com.teamseven.vlu.models.Course;
import com.teamseven.vlu.models.CourseDetail;
import com.teamseven.vlu.models.ManageCourse;
import com.teamseven.vlu.models.Mentor;
import com.teamseven.vlu.utils.FunctionRandom;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class ManageCourseController extends HttpServlet {

    private static final String MANAGE_COURSE_LIST = "MANAGE_COURSE_LIST";
    private static final String MENTOR_LIST = "MENTOR_LIST";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            CourseFacade courseFacade = new CourseFacade();
            MentorFacade mentorFacade = new MentorFacade();
            CourseDetailFacade courseDetailFacade = new CourseDetailFacade();
            List<Course> courseList = courseFacade.getAllCourse();
            List<ManageCourse> manageCourseList = new ArrayList<>();
            List<Mentor> mentorList = mentorFacade.getAllMentor();

            if (courseList.isEmpty()) {
                request.setAttribute(MANAGE_COURSE_LIST, null);
            } else {
                for (int i = 0; i < courseList.size(); i++) {
                    String mentorName = "", mentorPhone = "", mentorEmail = "", courseDetailDescription = "";
                    Mentor mentor = mentorFacade.getMentor(courseList.get(i).getMentorID());
                    CourseDetail courseDetail = courseDetailFacade.getCourseDetail(courseList.get(i).getCourseID());

                    if (mentor != null) {
                        if (courseList.get(i).getMentorID().equals(mentor.getMentorID())) {
                            mentorName = mentor.getMentorName();
                            mentorPhone = mentor.getMentorPhone();
                            mentorEmail = mentor.getMentorEmail();
                        }
                    }

                    if (courseDetail != null) {
                        if (courseList.get(i).getCourseID().equals(courseDetail.getCourseID())) {
                            courseDetailDescription = courseDetail.getCourseDetailDescription();
                        }
                    }

                    manageCourseList.add(new ManageCourse(courseList.get(i).getCourseID(), courseList.get(i).getCourseName(), mentorName, mentorPhone, mentorEmail, courseDetailDescription, courseList.get(i).getStartDate(), courseList.get(i).getEndDate(), courseList.get(i).getStatus()));
                }

                JSONArray jsArray = new JSONArray(manageCourseList);
                request.setAttribute(MANAGE_COURSE_LIST, jsArray.toString());
            }

            if (mentorList.isEmpty()) {
                request.setAttribute(MENTOR_LIST, null);
            } else {
                JSONArray mentorListArray = new JSONArray(mentorList);
                request.setAttribute(MENTOR_LIST, mentorListArray.toString());
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ManageCourse.jsp");
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
            // Add Value
            String addCourseName = request.getParameter("CourseName");
            String addStatus = request.getParameter("Status");
            String addStartDate = request.getParameter("StartDate");
            String addEndDate = request.getParameter("EndDate");
            String addMentorID = request.getParameter("MentorID");
            String addImageCourse = request.getParameter("ImageCourse");
            String addDescription = request.getParameter("Description");
            String courseID = FunctionRandom.randomID(10);
            
            // Update Value
            String updateCourseID = request.getParameter("UpdateCourseID");
            String updateCourseName = request.getParameter("UpdateCourseName");
            String updateStatus = request.getParameter("UpdateStatus");
            String updateStartDate = request.getParameter("UpdateStartDate");
            String updateEndDate = request.getParameter("UpdateEndDate");
            String updateMentorName = request.getParameter("UpdateMentorName");
            String updateDescription = request.getParameter("UpdateDescription");
            String updateImageCourse = request.getParameter("UpdateImageCourse");
            
            // Delete Value
            String deleteCourseID = request.getParameter("DeleteCourseID");

            CourseFacade courseFacade = new CourseFacade();
            CourseDetailFacade courseDetailFacade = new CourseDetailFacade();
            MentorFacade mentorFacade = new MentorFacade();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Course course = new Course();
            CourseDetail courseDetail = new CourseDetail();

            if (addCourseName != null && addStatus != null && addStartDate != null && addEndDate != null && addMentorID != null && addDescription != null) {
                Mentor checkMentor = mentorFacade.getMentor(addMentorID);

                course.setCourseID(courseID);
                course.setCourseName(addCourseName);
                course.setMentorID(checkMentor.getMentorID());
                if (addImageCourse != null) {
                    String[] cutCodeImage = addImageCourse.split("\\,");
                    course.setImageCourse(cutCodeImage[1]);
                }
                java.util.Date startDate = formatter.parse(addStartDate);
                java.sql.Date convertStartDate = new Date(startDate.getTime());
                course.setStartDate(convertStartDate);
                java.util.Date endDate = formatter.parse(addEndDate);
                java.sql.Date convertEndDate = new Date(endDate.getTime());
                course.setEndDate(convertEndDate);
                if (addStatus.equals("Sắp diễn ra")) {
                    course.setStatus(0);
                } else {
                    course.setStatus(1);
                }

                courseDetail.setCourseDetailID(FunctionRandom.randomID(10));
                courseDetail.setCourseDetailDescription(addDescription);
                courseDetail.setCourseID(courseID);

                courseFacade.addCourse(course);
                courseDetailFacade.addCourseDetail(courseDetail);
            } else if (updateCourseID != null && updateCourseName != null && updateStatus != null && updateStartDate != null && updateEndDate != null && updateMentorName != null && updateDescription != null && updateImageCourse != null) {
                Mentor checkMentor = mentorFacade.getMentor(updateMentorName);

                course.setCourseID(updateCourseID);
                course.setCourseName(updateCourseName);
                course.setMentorID(checkMentor.getMentorID());
                course.setImageCourse(updateImageCourse);
                
                java.util.Date startDate = formatter.parse(updateStartDate);
                java.sql.Date convertStartDate = new Date(startDate.getTime());
                course.setStartDate(convertStartDate);
                
                java.util.Date endDate = formatter.parse(updateEndDate);
                java.sql.Date convertEndDate = new Date(endDate.getTime());
                course.setEndDate(convertEndDate);
                
                if (updateStatus.equals("Sắp diễn ra")) {
                    course.setStatus(0);
                } else {
                    course.setStatus(1);
                }
                
                courseDetail.setCourseDetailDescription(updateDescription);
                courseDetail.setCourseID(updateCourseID);
                
                courseFacade.updateCourse(course);
                courseDetailFacade.updateCourseDetail(courseDetail);
            } else if (deleteCourseID != null) {
                courseDetailFacade.deleteCourseDetail(deleteCourseID);
                courseFacade.deleteCourse(deleteCourseID);
            }

        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
