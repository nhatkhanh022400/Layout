package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourse<T> {

    private Connection connection;

    protected abstract List<T> getAllCourse(Connection connection) throws SQLException;

    protected abstract List<T> getCourse(Connection connection, Object value) throws SQLException;

    protected abstract boolean deleteCourse(Connection connection, Object id) throws SQLException;

    protected abstract boolean addCourse(Connection connection, T course) throws SQLException;

    protected abstract T checkCourse(Connection connection, Object object) throws SQLException;
    
    protected abstract boolean updateCourse(Connection connection, T course) throws SQLException;

    public List<T> getAllCourse() throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllCourse(connection);
        } finally {
            connection.close();
        }
        return list;
    }

    public List<T> getCourse(Object value) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getCourse(connection, value);
        } finally {
            connection.close();
        }
        return list;
    }

    public boolean deleteCourse(Object object) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteCourse(connection, object);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean addCourse(T course) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addCourse(connection, course);
        } finally {
            connection.close();
        }

        return check;
    }

    public T checkCourse(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = checkCourse(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
    
    public boolean updateCourse(T course) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateCourse(connection, course);
        } finally {
            connection.close();
        }

        return check;
    }
}
