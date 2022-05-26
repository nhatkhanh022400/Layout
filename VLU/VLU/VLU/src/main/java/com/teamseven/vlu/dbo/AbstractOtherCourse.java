package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOtherCourse<T> {

    private Connection connection;

    protected abstract boolean addOtherCourse(Connection connection, T otherCourse) throws SQLException;

    protected abstract boolean updateOtherCourse(Connection connection, T otherCourse) throws SQLException;

    protected abstract List<T> getOtherCourse(Connection connection, Object value) throws SQLException;

    public boolean addOtherCourse(T otherCourse) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addOtherCourse(connection, otherCourse);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean updateOtherCourse(T otherCourse) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateOtherCourse(connection, otherCourse);
        } finally {
            connection.close();
        }

        return check;
    }

    public List<T> getOtherCourse(Object value) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getOtherCourse(connection, value);
        } finally {
            connection.close();
        }
        return list;
    }
}
