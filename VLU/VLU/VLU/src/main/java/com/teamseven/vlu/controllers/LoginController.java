package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.AdminAccountFacade;
import com.teamseven.vlu.models.AdminAccount;
import com.teamseven.vlu.models.AdminAccountError;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginController extends HttpServlet {

    private static final String LOGIN_ADMIN = "LOGIN_ADMIN";
    private static final String LOGIN_ACCOUNT_ERROR = "LOGIN_ACCOUNT_ERROR";
    private static final String EMAIL = "EMAIL";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String getEmail = request.getParameter("email");
            String getPassword = request.getParameter("password");
            String hashPassword = DigestUtils.md5Hex(getPassword);

            AdminAccount adminAccount = null;
            AdminAccountError adminAccountError = new AdminAccountError();
            boolean hasError = false;

            if (getEmail.equals("") && getPassword.equals("")) {
                hasError = true;
                adminAccountError.setEmail("Please enter your email!");
                adminAccountError.setCurrentPassword("Please enter your password!");
            } else if (getEmail.equals("")) {
                hasError = true;
                adminAccountError.setEmail("Please enter your email!");
            } else if (getPassword.equals("")) {
                hasError = true;
                adminAccountError.setCurrentPassword("Please enter your password!");
            } else {
                AdminAccountFacade checkLogin = new AdminAccountFacade();
                adminAccount = checkLogin.checkAdminAccount(getEmail);
                if (adminAccount == null) {
                    hasError = true;
                    adminAccountError.setEmail("Account does not exist!");
                    adminAccountError.setCurrentPassword("Account does not exist!");
                } else if (!hashPassword.equals(adminAccount.getPassword())) {
                    hasError = true;
                    adminAccountError.setCurrentPassword("Wrong password, please try again!");
                }
            }

            if (hasError) {
                request.setAttribute(LOGIN_ACCOUNT_ERROR, adminAccountError);
                request.setAttribute(EMAIL, getEmail);
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
                requestDispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();

                session.setAttribute(LOGIN_ADMIN, adminAccount);
                response.sendRedirect(request.getContextPath() + "/admin/chart");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
