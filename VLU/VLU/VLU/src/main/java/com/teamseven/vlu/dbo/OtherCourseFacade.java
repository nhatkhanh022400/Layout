package com.teamseven.vlu.dbo;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.teamseven.vlu.models.OtherCourse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OtherCourseFacade extends AbstractOtherCourse<OtherCourse> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_ADD_OTHER_COURSE = "INSERT INTO OtherCourse(OtherCourseID, OtherCourseName, LearnerID, CertificateImage, StartDate, EndDate) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_OTHER_COURSE = "SELECT * FROM OtherCourse WHERE LearnerID = ?";
    private static final String SQL_UPDATE_OTHER_COURSE = "UPDATE OtherCourse SET OtherCourseName = ?, CertificateImage = ?, StartDate = ?, EndDate = ? WHERE OtherCourseID = ? AND LearnerID = ?";

    private OtherCourse getInfoOtherCourseFromSQL(ResultSet resultSet) throws SQLException {
        String getOtherCourseID = resultSet.getString("OtherCourseID");
        String getOtherCourseName = resultSet.getString("OtherCourseName");
        String getLearnerID = resultSet.getString("LearnerID");
        byte[] getCertificateImage = resultSet.getBytes("CertificateImage");
        Date getStartDate = resultSet.getDate("StartDate");
        Date getEndDate = resultSet.getDate("EndDate");

        return new OtherCourse(getOtherCourseID, getOtherCourseName, getLearnerID, Base64.encode(getCertificateImage), getStartDate, getEndDate);
    }

    @Override
    protected boolean addOtherCourse(Connection connection, OtherCourse otherCourse) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_OTHER_COURSE);
                preparedStatement.setString(1, otherCourse.getOtherCourseID());
                preparedStatement.setString(2, otherCourse.getOtherCourseName());
                preparedStatement.setString(3, otherCourse.getLearnerID());
                preparedStatement.setBytes(4, Base64.decode(otherCourse.getCertificateImage()));
                preparedStatement.setDate(5, otherCourse.getStartDate());
                preparedStatement.setDate(6, otherCourse.getEndDate());
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
    protected boolean updateOtherCourse(Connection connection, OtherCourse otherCourse) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_OTHER_COURSE);
                preparedStatement.setString(1, otherCourse.getOtherCourseName());
                preparedStatement.setBytes(2, Base64.decode(otherCourse.getCertificateImage()));
                preparedStatement.setDate(3, otherCourse.getStartDate());
                preparedStatement.setDate(4, otherCourse.getEndDate());
                preparedStatement.setString(5, otherCourse.getOtherCourseID());
                preparedStatement.setString(6, otherCourse.getLearnerID());
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
    protected List<OtherCourse> getOtherCourse(Connection connection, Object value) throws SQLException {
        ArrayList<OtherCourse> listOtherCourse = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_OTHER_COURSE);
                preparedStatement.setString(1, value.toString());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    OtherCourse otherCourse = getInfoOtherCourseFromSQL(resultSet);
                    listOtherCourse.add(otherCourse);
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
        return listOtherCourse;
    }
}
