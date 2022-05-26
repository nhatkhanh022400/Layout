package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractCourseDetail<T> {

    private Connection connection;

    protected abstract T getCourseDetail(Connection connection, Object courseId) throws SQLException;

    protected abstract boolean addCourseDetail(Connection connection, T courseDetail) throws SQLException;
    
    protected abstract boolean updateCourseDetail(Connection connection, T course) throws SQLException;
    
    protected abstract boolean deleteCourseDetail(Connection connection, Object id) throws SQLException;

    public T getCourseDetail(Object courseId) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getCourseDetail(connection, courseId);
        } finally {
            connection.close();
        }
        return t;
    }

    public boolean addCourseDetail(T courseDetail) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addCourseDetail(connection, courseDetail);
        } finally {
            connection.close();
        }

        return check;
    }
    
    public boolean updateCourseDetail(T courseDetail) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateCourseDetail(connection, courseDetail);
        } finally {
            connection.close();
        }

        return check;
    }
    
    public boolean deleteCourseDetail(Object object) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteCourseDetail(connection, object);
        } finally {
            connection.close();
        }

        return check;
    }
}
