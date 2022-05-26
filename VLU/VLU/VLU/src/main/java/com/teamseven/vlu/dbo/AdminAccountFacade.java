package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.AdminAccount;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.sql.*;

public class AdminAccountFacade extends AbstractAdminAccount<AdminAccount> {

    private static final String SQL_LOGIN = "SELECT * FROM AdminAccount WHERE Email = ?";
    private static final String SQL_EDIT_PROFILE = "UPDATE AdminAccount SET FirstName = ?, LastName = ?, UserName = ?, PasswordHash = ?, Email = ?, ImageAvatar = ? WHERE AdminID = ?";
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private AdminAccount getInfoAdminAccountFromSQL(ResultSet resultSet) throws SQLException {
        String getAdminID = resultSet.getString("AdminID");
        String getFirstName = resultSet.getString("FirstName");
        String getLastName = resultSet.getString("LastName");
        String getUserName = resultSet.getString("UserName");
        String getPasswordHash = resultSet.getString("PasswordHash");
        String getEmail = resultSet.getString("Email");
        byte[] getImageAvatar = resultSet.getBytes("ImageAvatar");

        return new AdminAccount(getAdminID, getFirstName, getLastName, getUserName, getPasswordHash, getEmail, Base64.encode(getImageAvatar));
    }

    @Override
    protected AdminAccount checkAdminAccount(Connection connection, Object object) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_LOGIN);
                preparedStatement.setString(1, object.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoAdminAccountFromSQL(resultSet);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    protected boolean updateAdminAccount(Connection connection, AdminAccount adminAccount) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_EDIT_PROFILE);
                preparedStatement.setString(1, adminAccount.getFirstName());
                preparedStatement.setString(2, adminAccount.getLastName());
                preparedStatement.setString(3, adminAccount.getUserName());
                preparedStatement.setString(4, adminAccount.getPassword());
                preparedStatement.setString(5, adminAccount.getEmail());
                preparedStatement.setBytes(6, Base64.decode(adminAccount.getImageAvatar()));
                preparedStatement.setString(7, adminAccount.getIdAdmin());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

}
