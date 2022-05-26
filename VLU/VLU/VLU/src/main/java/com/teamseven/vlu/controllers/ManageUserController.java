package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.DepartmentFacade;
import com.teamseven.vlu.dbo.LearnerAccountFacade;
import com.teamseven.vlu.models.Department;
import com.teamseven.vlu.models.LearnerAccount;
import com.teamseven.vlu.models.ManageUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class ManageUserController extends HttpServlet {

    private static final String LEARNER_ACCOUNT_LIST = "LEARNER_ACCOUNT_LIST";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();
            DepartmentFacade departmentFacade = new DepartmentFacade();
            ManageUser manageUser;

            List<LearnerAccount> learnerAccountList = learnerAccountFacade.getAllLearnerAccount();
            List<ManageUser> manageUserList = new ArrayList<>();

            if (learnerAccountList.isEmpty()) {
                request.setAttribute(LEARNER_ACCOUNT_LIST, null);
            } else {
                for (int i = 0; i < learnerAccountList.size(); i++) {
                    String departmentName = "";
                    
                    if (learnerAccountList.get(i).getDepartmentID() != null) {
                        Department department = departmentFacade.getDepartmentWithID(learnerAccountList.get(i).getDepartmentID());
                        departmentName = department.getDepartmentName();
                    }

                    manageUserList.add(new ManageUser(learnerAccountList.get(i).getLearnerID(), learnerAccountList.get(i).getLearnerName(), departmentName, learnerAccountList.get(i).getEmail(), learnerAccountList.get(i).getPhoneNumber(), learnerAccountList.get(i).getImageAvatar()));
                }

                JSONArray jsArray = new JSONArray(manageUserList);
                request.setAttribute(LEARNER_ACCOUNT_LIST, jsArray.toString());
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ManageUser.jsp");
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
            String deleteUserID = request.getParameter("DeleteUserID");

            LearnerAccountFacade learnerAccountFacade = new LearnerAccountFacade();

            if (deleteUserID != null) {
                learnerAccountFacade.deleteLearnerAccount(deleteUserID);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
