package com.teamseven.vlu.dbo;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.teamseven.vlu.models.Course;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class CourseFacade extends AbstractCourse<Course> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_COURSE = "SELECT * FROM Course";
    private static final String SQL_GET_COURSE_BY_STATUS = "SELECT * FROM Course WHERE StatusCourse = ?";
    private static final String SQL_GET_COURSE_BY_ID = "SELECT * FROM Course WHERE CourseID = ?";
    private static final String SQL_DELETE_COURSE = "DELETE FROM Course WHERE CourseID = ?";
    private static final String SQL_ADD_COURSE = "INSERT INTO Course(CourseID, CourseName, MentorID, ImageCourse, StartDate, EndDate, StatusCourse) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_COURSE = "UPDATE Course SET CourseName = ?, MentorID = ?, ImageCourse = ?, StartDate = ?, EndDate = ?, StatusCourse = ? WHERE CourseID = ?";

    private Course getInfoCourseFromSQL(ResultSet resultSet) throws SQLException {
        String getCourseID = resultSet.getString("CourseID");
        String getCourseName = resultSet.getString("CourseName");
        String getMentorID = resultSet.getString("MentorID");
        Date getStartDate = resultSet.getDate("StartDate");
        Date getEndDate = resultSet.getDate("EndDate");
        int getStatusCourse = resultSet.getInt("StatusCourse");
        byte[] getImageCourse = resultSet.getBytes("ImageCourse");

        return new Course(getCourseID, getCourseName, getMentorID, Base64.encode(getImageCourse), getStartDate, getEndDate, getStatusCourse);
    }

    @Override
    protected List<Course> getAllCourse(Connection connection) throws SQLException {
        ArrayList<Course> courseAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_COURSE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Course course = getInfoCourseFromSQL(resultSet);
                    courseAllList.add(course);
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
        return courseAllList;
    }

    @Override
    protected List<Course> getCourse(Connection connection, Object value) throws SQLException {
        ArrayList<Course> listCourse = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_COURSE_BY_STATUS);
                preparedStatement.setInt(1, Integer.parseInt(value.toString()));
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Course course = getInfoCourseFromSQL(resultSet);
                    listCourse.add(course);
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
        return listCourse;
    }

    @Override
    protected boolean deleteCourse(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_COURSE);
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
    protected boolean addCourse(Connection connection, Course course) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_COURSE);
                preparedStatement.setString(1, course.getCourseID());
                preparedStatement.setString(2, course.getCourseName());
                preparedStatement.setString(3, course.getMentorID());
                preparedStatement.setBytes(4, Base64.decode(course.getImageCourse()));
                preparedStatement.setDate(5, course.getStartDate());
                preparedStatement.setDate(6, course.getEndDate());
                preparedStatement.setInt(7, course.getStatus());
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
    protected Course checkCourse(Connection connection, Object object) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_COURSE_BY_ID);
                preparedStatement.setString(1, object.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoCourseFromSQL(resultSet);
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
    protected boolean updateCourse(Connection connection, Course course) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_COURSE);
                preparedStatement.setString(1, course.getCourseName());
                preparedStatement.setString(2, course.getMentorID());
                preparedStatement.setBytes(3, Base64.decode(course.getImageCourse()));
                preparedStatement.setDate(4, course.getStartDate());
                preparedStatement.setDate(5, course.getEndDate());
                preparedStatement.setInt(6, course.getStatus());
                preparedStatement.setString(7, course.getCourseID());
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
