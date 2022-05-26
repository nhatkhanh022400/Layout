package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.LearnerAccount;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LearnerAccountFacade extends AbstractLearner<LearnerAccount> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_EDIT_PROFILE = "UPDATE Learner SET LearnerName = ?, DepartmentID = ?, DateOfBirth = ?, PhoneNumber = ? WHERE Email = ?";
    private static final String SQL_ADD_LEARNER = "INSERT INTO Learner(LearnerID, Email, ImageAvatar) VALUES(?, ?, ?)";
    private static final String SQL_GET_ACCOUNT = "SELECT * FROM Learner WHERE Email = ?";
    private static final String SQL_GET_ALL_ACCOUNT = "SELECT * FROM Learner";
    private static final String SQL_DELETE_ACCOUNT = "DELETE FROM Learner WHERE LearnerID = ?";

    private LearnerAccount getInfoAdminAccountFromSQL(ResultSet resultSet) throws SQLException {
        String getLearnerID = resultSet.getString("LearnerID");
        String getLearnerName = resultSet.getString("LearnerName");
        String getDepartmentID = resultSet.getString("DepartmentID");
        String getEmail = resultSet.getString("Email");
        Date getDateOfBirth = resultSet.getDate("DateOfBirth");
        String getPhoneNumber = resultSet.getString("PhoneNumber");
        String getImageAvatar = resultSet.getString("ImageAvatar");

        return new LearnerAccount(getLearnerID, getLearnerName, getDepartmentID, getEmail, getPhoneNumber, getImageAvatar, getDateOfBirth);
    }

    @Override
    protected boolean updateLearnerAccount(Connection connection, LearnerAccount learner) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_EDIT_PROFILE);
                preparedStatement.setString(1, learner.getLearnerName());
                preparedStatement.setString(2, learner.getDepartmentID());
                preparedStatement.setDate(3, learner.getDateOfBirth());
                preparedStatement.setString(4, learner.getPhoneNumber());
                preparedStatement.setString(5, learner.getEmail());
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

    @Override
    protected boolean addLearner(Connection connection, LearnerAccount learner) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_LEARNER);

                preparedStatement.setString(1, learner.getLearnerID());
                preparedStatement.setString(2, learner.getEmail());
                preparedStatement.setString(3, learner.getImageAvatar());
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

    @Override
    protected LearnerAccount getLearnerAccount(Connection connection, Object object) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ACCOUNT);
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
    protected List<LearnerAccount> getAllLearnerAccount(Connection connection) throws SQLException {
        ArrayList<LearnerAccount> learnerAccountAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_ACCOUNT);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    LearnerAccount learnerAccount = getInfoAdminAccountFromSQL(resultSet);
                    learnerAccountAllList.add(learnerAccount);
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
        return learnerAccountAllList;
    }

    @Override
    protected boolean deleteLearnerAccount(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_ACCOUNT);
                preparedStatement.setString(1, id.toString());
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
