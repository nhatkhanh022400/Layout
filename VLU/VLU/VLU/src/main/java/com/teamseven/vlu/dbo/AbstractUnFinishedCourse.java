package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnFinishedCourse<T> {

    private Connection connection;

    protected abstract List<T> getAllUnFinishedCourse(Connection connection) throws SQLException;

    protected abstract boolean addUnFinishedCourse(Connection connection, T unFinishedCourse) throws SQLException;

    protected abstract boolean deleteUnFinishedCourse(Connection connection, Object id) throws SQLException;

    protected abstract T checkUnFinishedCourse(Connection connection, Object courseID, Object learnerID) throws SQLException;

    public List<T> getAllUnFinishedCourse() throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllUnFinishedCourse(connection);
        } finally {
            connection.close();
        }
        return list;
    }

    public boolean addUnFinishedCourse(T unFinishedCourse) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addUnFinishedCourse(connection, unFinishedCourse);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean deleteUnFinishedCourse(Object object) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteUnFinishedCourse(connection, object);
        } finally {
            connection.close();
        }

        return check;
    }

    public T checkUnFinishedCourse(Object courseID, Object learnerID) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = checkUnFinishedCourse(connection, courseID, learnerID);
        } finally {
            connection.close();
        }
        return t;
    }
}
