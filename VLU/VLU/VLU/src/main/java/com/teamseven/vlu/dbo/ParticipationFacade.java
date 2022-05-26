package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.Participation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipationFacade extends AbstractParticipation<Participation> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_PARTICIPATION = "SELECT * FROM Participation";
    private static final String SQL_ADD_PARTICIPATION = "INSERT INTO Participation(ParticipationID, CourseID, LearnerID) VALUES(?, ?, ?)";

    private Participation getInfoParticipationFromSQL(ResultSet resultSet) throws SQLException {
        String getParticipationID = resultSet.getString("ParticipationID");
        String getCourseID = resultSet.getString("CourseID");
        String getLearnerID = resultSet.getString("LearnerID");

        return new Participation(getParticipationID, getCourseID, getLearnerID);
    }

    @Override
    protected List<Participation> getAllParticipation(Connection connection) throws SQLException {
        ArrayList<Participation> participationAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_PARTICIPATION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Participation participation = getInfoParticipationFromSQL(resultSet);
                    participationAllList.add(participation);
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
        return participationAllList;
    }

    @Override
    protected boolean addParticipation(Connection connection, Participation participation) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_PARTICIPATION);
                preparedStatement.setString(1, participation.getParticipationID());
                preparedStatement.setString(2, participation.getCourseID());
                preparedStatement.setString(3, participation.getLearnerID());
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
