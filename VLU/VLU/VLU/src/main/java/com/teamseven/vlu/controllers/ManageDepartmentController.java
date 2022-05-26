package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.DepartmentFacade;
import com.teamseven.vlu.models.Department;
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

public class ManageDepartmentController extends HttpServlet {
    
    private static final String DEPARTMENT_LIST = "DEPARTMENT_LIST";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            DepartmentFacade departmentFacade = new DepartmentFacade();
            
            List<Department> departmentList = departmentFacade.getAllDepartment();
            
            if (departmentList.isEmpty()) {
                request.setAttribute(DEPARTMENT_LIST, null);
            } else {
                JSONArray jsArray = new JSONArray(departmentList);
                request.setAttribute(DEPARTMENT_LIST, jsArray.toString());
            }
            
            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ManageDepartment.jsp");
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
            String addDepartmentName = request.getParameter("AddDepartmentName");
            String departmentID = FunctionRandom.randomID(10);
            
            //Value Update
            String updateDepartmentID = request.getParameter("UpdateDepartmentID");
            String updateDepartmentName = request.getParameter("UpdateDepartmentName");
            
            //Value Delete
            String deleteDepartmentID = request.getParameter("DeleteDepartmentID");
            
            DepartmentFacade departmentFacade = new DepartmentFacade();
            Department department = new Department();
            
            if (addDepartmentName != null) {
                department.setDepartmentID(departmentID);
                department.setDepartmentName(addDepartmentName);
                departmentFacade.addDepartment(department);
            } else if (updateDepartmentID != null && updateDepartmentName != null) {
                department.setDepartmentID(updateDepartmentID);
                department.setDepartmentName(updateDepartmentName);
                departmentFacade.updateDepartment(department);
            } else if (deleteDepartmentID != null) {
                departmentFacade.deleteDepartment(deleteDepartmentID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
