package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.CompletedCourse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompletedCourseFacade extends AbstractCompletedCourse<CompletedCourse> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_COMPLETED_COURSE_BY_ID = "SELECT * FROM CompletedCourse WHERE LearnerID = ?";
    private static final String SQL_ADD_COMPLETED_COURSE = "INSERT INTO CompletedCourse(CompletedCourseID, LearnerID, CourseID, StartDate, EndDate) VALUES(?, ?, ?, ?, ?)";

    private CompletedCourse getInfoCompletedCourseFromSQL(ResultSet resultSet) throws SQLException {
        String getCompletedCourseID = resultSet.getString("CompletedCourseID");
        String getLearnerID = resultSet.getString("LearnerID");
        String getCourseID = resultSet.getString("CourseID");
        Date getStartDate = resultSet.getDate("StartDate");
        Date getEndDate = resultSet.getDate("EndDate");

        return new CompletedCourse(getCompletedCourseID, getLearnerID, getCourseID, getStartDate, getEndDate);
    }

    @Override
    protected List<CompletedCourse> getAllCompletedCourse(Connection connection, Object object) throws SQLException {
        ArrayList<CompletedCourse> completedCourseAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_COMPLETED_COURSE_BY_ID);
                preparedStatement.setString(1, object.toString());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CompletedCourse completedCourse = getInfoCompletedCourseFromSQL(resultSet);
                    completedCourseAllList.add(completedCourse);
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
        return completedCourseAllList;
    }

    @Override
    protected boolean addCompletedCourse(Connection connection, CompletedCourse completedCourse) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_COMPLETED_COURSE);
                preparedStatement.setString(1, completedCourse.getCompletedCourseID());
                preparedStatement.setString(2, completedCourse.getLearnerID());
                preparedStatement.setString(3, completedCourse.getCourseID());
                preparedStatement.setDate(4, completedCourse.getStartDate());
                preparedStatement.setDate(5, completedCourse.getEndDate());
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
