package com.teamseven.vlu.controllers;

import com.teamseven.vlu.dbo.AdminAccountFacade;
import com.teamseven.vlu.models.AdminAccount;
import com.teamseven.vlu.models.AdminAccountError;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

public class UpdateInforController extends HttpServlet {

    private static final String LOGIN_ADMIN = "LOGIN_ADMIN";
    private static final String EDIT_PROFILE_ERROR = "EDIT_PROFILE_ERROR";
    private static final String FIRSTNAME = "FIRSTNAME";
    private static final String LASTNAME = "LASTNAME";
    private static final String USERNAME = "USERNAME";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/UpdateInfor.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            HttpSession session = request.getSession();
            AdminAccount loginAdmin = (AdminAccount) session.getAttribute(LOGIN_ADMIN);
            
            String getFirstName = request.getParameter("FirstName");
            String getLastName = request.getParameter("LastName");
            String getUsername = request.getParameter("Username");
            String getEmail = request.getParameter("Email");
            String getCurrentPassword = request.getParameter("CurrentPassword");
            String getNewPassword = request.getParameter("NewPassword");
            String getConfirmNewPassword = request.getParameter("ConfirmNewPassword");
            String imageAvatar = request.getParameter("imageAvatar");
            
            String hashOldPassword = DigestUtils.md5Hex(getCurrentPassword);
            String hashNewPassword = DigestUtils.md5Hex(getNewPassword);

            AdminAccount adminAccount;
            AdminAccountError adminAccountError = new AdminAccountError();
            AdminAccountFacade adminAccountFacade = new AdminAccountFacade();
            boolean hasError = false;

            if (getFirstName.equals("") && getLastName.equals("") && getUsername.equals("") && getEmail.equals("") && getCurrentPassword.equals("") && getNewPassword.equals("") && getConfirmNewPassword.equals("")) {
                hasError = true;
                adminAccountError.setFirstName("Please enter your first name!");
                adminAccountError.setLastName("Please enter your last name!");
                adminAccountError.setUserName("Please enter your username!");
                adminAccountError.setEmail("Please enter your email!");
                adminAccountError.setCurrentPassword("Please enter your current password!");
                adminAccountError.setNewPassword("Please enter your new password!");
                adminAccountError.setConfirmNewPassword("Please enter your confirm password!");
            } else if (getFirstName.equals("")) {
                hasError = true;
                adminAccountError.setFirstName("Please enter your first name!");
            } else if (getLastName.equals("")) {
                hasError = true;
                adminAccountError.setLastName("Please enter your last name!");
            } else if (getUsername.equals("")) {
                hasError = true;
                adminAccountError.setUserName("Please enter your username!");
            } else if (getEmail.equals("")) {
                hasError = true;
                adminAccountError.setEmail("Please enter your email!");
            } else if (getCurrentPassword.equals("")) {
                hasError = true;
                adminAccountError.setCurrentPassword("Please enter your current password!");
            } else if (getNewPassword.equals("")) {
                hasError = true;
                adminAccountError.setNewPassword("Please enter your new password!");
            } else if (getConfirmNewPassword.equals("")) {
                hasError = true;
                adminAccountError.setConfirmNewPassword("Please enter your confirm password!");
            } else if (!getNewPassword.equals(getConfirmNewPassword)) {
                hasError = true;
                adminAccountError.setConfirmNewPassword("Password does not match!");
            } else if (!hashOldPassword.equals(loginAdmin.getPassword())) {
                hasError = true;
                adminAccountError.setCurrentPassword("Old password is incorrect!");
            }

            if (hasError) {
                request.setAttribute(FIRSTNAME, getFirstName);
                request.setAttribute(LASTNAME, getLastName);
                request.setAttribute(USERNAME, getUsername);
                request.setAttribute(EDIT_PROFILE_ERROR, adminAccountError);
                
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/UpdateInfor.jsp");
                requestDispatcher.forward(request, response);
            } else {
                adminAccount = new AdminAccount();
                adminAccount.setIdAdmin(loginAdmin.getIdAdmin());
                adminAccount.setFirstName(getFirstName);
                adminAccount.setLastName(getLastName);
                adminAccount.setUserName(getUsername);
                adminAccount.setEmail(getEmail);
                adminAccount.setPassword(hashNewPassword);
                if (imageAvatar != null) {
                    String[] cutCodeImage = imageAvatar.split("\\,");
                    adminAccount.setImageAvatar(cutCodeImage[1]);
                }
                
                boolean checkEditProfile = adminAccountFacade.updateAdminAccount(adminAccount);
                if (checkEditProfile) {
                    AdminAccount getAccount = adminAccountFacade.checkAdminAccount(adminAccount.getEmail());
                    session.setAttribute(LOGIN_ADMIN, getAccount);
                }
                
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/UpdateInfor.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
