package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.Mentor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MentorFacade extends AbstractMentor<Mentor> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_MENTOR = "SELECT * FROM Mentor";
    private static final String SQL_GET_MENTOR = "SELECT * FROM Mentor WHERE MentorID = ?";
    private static final String SQL_GET_MENTOR_WITH_NAME = "SELECT * FROM Mentor WHERE MentorName = ?";
    private static final String SQL_DELETE_MENTOR = "DELETE FROM Mentor WHERE MentorID = ?";
    private static final String SQL_ADD_MENTOR = "INSERT INTO Mentor(MentorID, MentorName, MentorPhone, MentorEmail) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE_MENTOR = "UPDATE Mentor SET MentorName = ?, MentorPhone = ?, MentorEmail = ? WHERE MentorID = ?";

    private Mentor getInfoMentorFromSQL(ResultSet resultSet) throws SQLException {
        String getMentorID = resultSet.getString("MentorID");
        String getMentorName = resultSet.getString("MentorName");
        String getMentorPhone = resultSet.getString("MentorPhone");
        String getMentorEmail = resultSet.getString("MentorEmail");

        return new Mentor(getMentorID, getMentorName, getMentorPhone, getMentorEmail);
    }

    @Override
    protected List<Mentor> getAllMentor(Connection connection) throws SQLException {
        ArrayList<Mentor> mentorAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_MENTOR);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Mentor mentor = getInfoMentorFromSQL(resultSet);
                    mentorAllList.add(mentor);
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
        return mentorAllList;
    }

    @Override
    protected boolean addMentor(Connection connection, Mentor mentor) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_MENTOR);
                preparedStatement.setString(1, mentor.getMentorID());
                preparedStatement.setString(2, mentor.getMentorName());
                preparedStatement.setString(3, mentor.getMentorPhone());
                preparedStatement.setString(4, mentor.getMentorEmail());
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
    protected boolean deleteMentor(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_MENTOR);
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

    @Override
    protected boolean updateMentor(Connection connection, Mentor mentor) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_MENTOR);
                preparedStatement.setString(1, mentor.getMentorName());
                preparedStatement.setString(2, mentor.getMentorPhone());
                preparedStatement.setString(3, mentor.getMentorEmail());
                preparedStatement.setString(4, mentor.getMentorID());
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
    protected Mentor getMentor(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_MENTOR);
                preparedStatement.setString(1, id.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoMentorFromSQL(resultSet);
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
    protected Mentor getMentorWithName(Connection connection, Object name) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_MENTOR_WITH_NAME);
                preparedStatement.setString(1, name.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoMentorFromSQL(resultSet);
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

}
