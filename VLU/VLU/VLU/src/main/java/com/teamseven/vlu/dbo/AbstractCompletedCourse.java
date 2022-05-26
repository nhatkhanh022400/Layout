package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompletedCourse<T> {

    private Connection connection;

    protected abstract List<T> getAllCompletedCourse(Connection connection, Object object) throws SQLException;

    protected abstract boolean addCompletedCourse(Connection connection, T completedCourse) throws SQLException;

    public List<T> getAllCompletedCourse(Object object) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllCompletedCourse(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }

    public boolean addCompletedCourse(T completedCourse) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addCompletedCourse(connection, completedCourse);
        } finally {
            connection.close();
        }

        return check;
    }
}
