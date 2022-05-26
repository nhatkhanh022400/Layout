package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.UnFinishedCourse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnFinishedCourseFacade extends AbstractUnFinishedCourse<UnFinishedCourse> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_UNFINISHED_COURSE = "SELECT * FROM UnFinishedCourse";
    private static final String SQL_GET_UNFINISHED_COURSE_BY_ID = "SELECT * FROM UnFinishedCourse WHERE CourseID = ? AND LearnerID = ?";
    private static final String SQL_ADD_UNFINISHED_COURSE = "INSERT INTO UnFinishedCourse(UnFinishedCourseID, LearnerID, CourseID) VALUES(?, ?, ?)";
    private static final String SQL_DELETE_UNFINISHED_COURSE = "DELETE FROM UnFinishedCourse WHERE CourseID = ?";

    private UnFinishedCourse getInfoUnFinishedCourseFromSQL(ResultSet resultSet) throws SQLException {
        String getUnFinishedCourseID = resultSet.getString("UnFinishedCourseID");
        String getLearnerID = resultSet.getString("LearnerID");
        String getCourseID = resultSet.getString("CourseID");

        return new UnFinishedCourse(getUnFinishedCourseID, getLearnerID, getCourseID);
    }

    @Override
    protected List<UnFinishedCourse> getAllUnFinishedCourse(Connection connection) throws SQLException {
        ArrayList<UnFinishedCourse> unFinishedCourseAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_UNFINISHED_COURSE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    UnFinishedCourse unFinishedCourse = getInfoUnFinishedCourseFromSQL(resultSet);
                    unFinishedCourseAllList.add(unFinishedCourse);
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
        return unFinishedCourseAllList;
    }

    @Override
    protected boolean addUnFinishedCourse(Connection connection, UnFinishedCourse unFinishedCourse) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_UNFINISHED_COURSE);
                preparedStatement.setString(1, unFinishedCourse.getUnFinishedCourseID());
                preparedStatement.setString(2, unFinishedCourse.getLearnerID());
                preparedStatement.setString(3, unFinishedCourse.getCourseID());
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
    protected boolean deleteUnFinishedCourse(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_UNFINISHED_COURSE);
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
    protected UnFinishedCourse checkUnFinishedCourse(Connection connection, Object courseID, Object learnerID) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_UNFINISHED_COURSE_BY_ID);
                preparedStatement.setString(1, courseID.toString());
                preparedStatement.setString(2, learnerID.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoUnFinishedCourseFromSQL(resultSet);
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
