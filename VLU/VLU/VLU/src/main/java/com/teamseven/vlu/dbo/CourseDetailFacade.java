package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.CourseDetail;
import java.sql.*;

public class CourseDetailFacade extends AbstractCourseDetail<CourseDetail> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_COURSE_DETAIL_BY_ID = "SELECT * FROM CourseDetail WHERE CourseID = ?";
    private static final String SQL_ADD_COURSE_DETAIL = "INSERT INTO CourseDetail(CourseDetailID, CourseDetailDescription, CourseID) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE_COURSE_DETAIL = "UPDATE CourseDetail SET CourseDetailDescription = ? WHERE CourseID = ?";
    private static final String SQL_DELETE_COURSE_DETAIL = "DELETE FROM CourseDetail WHERE CourseID = ?";

    private CourseDetail getInfoCourseDetailFromSQL(ResultSet resultSet) throws SQLException {
        String getCourseDetailID = resultSet.getString("CourseDetailID");
        String getCourseDetailDescription = resultSet.getString("CourseDetailDescription");
        String getCourseID = resultSet.getString("CourseID");

        return new CourseDetail(getCourseDetailID, getCourseDetailDescription, getCourseID);
    }

    @Override
    protected CourseDetail getCourseDetail(Connection connection, Object courseId) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_COURSE_DETAIL_BY_ID);
                preparedStatement.setString(1, courseId.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoCourseDetailFromSQL(resultSet);
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
    protected boolean addCourseDetail(Connection connection, CourseDetail courseDetail) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_COURSE_DETAIL);
                preparedStatement.setString(1, courseDetail.getCourseDetailID());
                preparedStatement.setString(2, courseDetail.getCourseDetailDescription());
                preparedStatement.setString(3, courseDetail.getCourseID());
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
    protected boolean updateCourseDetail(Connection connection, CourseDetail courseDetail) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_COURSE_DETAIL);
                preparedStatement.setString(1, courseDetail.getCourseDetailDescription());
                preparedStatement.setString(2, courseDetail.getCourseID());
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
    protected boolean deleteCourseDetail(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_COURSE_DETAIL);
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