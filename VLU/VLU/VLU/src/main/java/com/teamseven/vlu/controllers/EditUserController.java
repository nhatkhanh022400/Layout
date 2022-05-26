package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.DepartmentFacade;
import com.teamseven.vlu.dbo.LearnerAccountFacade;
import com.teamseven.vlu.dbo.OtherCourseFacade;
import com.teamseven.vlu.models.Department;
import com.teamseven.vlu.models.LearnerAccount;
import com.teamseven.vlu.models.LearnerAccountError;
import com.teamseven.vlu.models.OtherCourse;
import com.teamseven.vlu.utils.FunctionRandom;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditUserController extends HttpServlet {

    private static final String LOGIN_USER = "LOGIN_USER";
    private static final String DEPARTMENT = "DEPARTMENT";
    private static final String DEPARTMENT_LIST = "DEPARTMENT_LIST";
    private static final String FULLNAME = "FULLNAME";
    private static final String PHONENUMBER = "PHONENUMBER";
    private static final String EDIT_PROFILE_ERROR = "EDIT_PROFILE_ERROR";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            LearnerAccount loginUser = (LearnerAccount) session.getAttribute(LOGIN_USER);

            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();
            DepartmentFacade departmentFacade = new DepartmentFacade();

            LearnerAccount learnerAccount = learnerAccountFacade.getLearnerAccount(loginUser.getEmail());
            List<Department> departmentList = departmentFacade.getAllDepartment();

            if (learnerAccount.getDepartmentID() != null) {
                Department department = departmentFacade.getDepartmentWithID(learnerAccount.getDepartmentID());
                request.setAttribute(DEPARTMENT, department.getDepartmentName());
            }

            if (departmentList.isEmpty()) {
                request.setAttribute(DEPARTMENT_LIST, null);
            } else {
                request.setAttribute(DEPARTMENT_LIST, departmentList);
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/EditUser.jsp");
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
            String fullName = request.getParameter("FullName");
            String dateOfBirth = request.getParameter("DateOfBirth");
            String phoneNumber = request.getParameter("PhoneNumber");
            String department = request.getParameter("Department");

            String otherCourseName = request.getParameter("OtherCourseName");
            String uploadImage = request.getParameter("UploadImage");
            String startDate = request.getParameter("StartDate");
            String endDate = request.getParameter("EndDate");

            LearnerAccount learnerAccount;
            OtherCourse otherCourse;
            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();
            OtherCourseFacade otherCourseFacade = new OtherCourseFacade();
            LearnerAccountError learnerAccountError = new LearnerAccountError();
            boolean hasError = false;

            if (fullName != null && phoneNumber != null && department != null) {
                if (fullName.equals("") && phoneNumber.equals("") && department.equals("")) {
                    hasError = true;
                    learnerAccountError.setLearnerName("Please enter your full name!");
                    learnerAccountError.setPhoneNumber("Please enter your phone number!");
                    learnerAccountError.setDepartment("Please enter your department!");
                } else if (fullName.equals("")) {
                    hasError = true;
                    learnerAccountError.setLearnerName("Please enter your full name!");
                } else if (phoneNumber.equals("")) {
                    hasError = true;
                    learnerAccountError.setPhoneNumber("Please enter your phone number!");
                } else if (department.equals("")) {
                    hasError = true;
                    learnerAccountError.setDepartment("Please enter your department!");
                }
            } else if (otherCourseName != null && startDate != null && endDate != null) {

            }

            if (hasError) {
                request.setAttribute(FULLNAME, fullName);
                request.setAttribute(PHONENUMBER, phoneNumber);
                request.setAttribute(DEPARTMENT, department);
                request.setAttribute(EDIT_PROFILE_ERROR, learnerAccountError);

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/EditUser.jsp");
                requestDispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                learnerAccount = new LearnerAccount();
                LearnerAccount loginUser = (LearnerAccount) session.getAttribute(LOGIN_USER);

                if (fullName != null && phoneNumber != null && department != null) {
                    Date convertDateOfBirth = Date.valueOf(dateOfBirth);

                    learnerAccount.setEmail(loginUser.getEmail());
                    learnerAccount.setLearnerName(fullName);
                    learnerAccount.setDateOfBirth(convertDateOfBirth);
                    learnerAccount.setPhoneNumber(phoneNumber);
                    learnerAccount.setDepartmentID(department);

                    boolean checkEditProfile = learnerAccountFacade.updateLearnerAccount(learnerAccount);
                    if (checkEditProfile) {
                        session.setAttribute(LOGIN_USER, learnerAccountFacade.getLearnerAccount(loginUser.getEmail()));
                    }
                } else if (otherCourseName != null && startDate != null && endDate != null) {
                    Date convertStartDate = Date.valueOf(startDate);
                    Date convertEndDate = Date.valueOf(endDate);

                    otherCourse = new OtherCourse();
                    otherCourse.setOtherCourseID(FunctionRandom.randomID(10));
                    otherCourse.setOtherCourseName(otherCourseName);
                    otherCourse.setLearnerID(loginUser.getLearnerID());
                    if (uploadImage != null) {
                        String[] cutCodeImage = uploadImage.split("\\,");
                        otherCourse.setCertificateImage(cutCodeImage[1]);
                    }
                    otherCourse.setStartDate(convertStartDate);
                    otherCourse.setEndDate(convertEndDate);

                    otherCourseFacade.addOtherCourse(otherCourse);
                }

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/profile");
                requestDispatcher.forward(request, response);
            }

        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
