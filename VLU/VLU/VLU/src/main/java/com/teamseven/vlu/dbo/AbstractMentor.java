package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMentor<T> {

    private Connection connection;

    protected abstract List<T> getAllMentor(Connection connection) throws SQLException;

    protected abstract T getMentor(Connection connection, Object id) throws SQLException;
    
    protected abstract T getMentorWithName(Connection connection, Object name) throws SQLException;

    protected abstract boolean addMentor(Connection connection, T mentor) throws SQLException;

    protected abstract boolean deleteMentor(Connection connection, Object id) throws SQLException;

    protected abstract boolean updateMentor(Connection connection, T mentor) throws SQLException;

    public List<T> getAllMentor() throws SQLException {
        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllMentor(connection);
        } finally {
            connection.close();
        }
        return list;
    }

    public T getMentor(Object id) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getMentor(connection, id);
        } finally {
            connection.close();
        }
        return t;
    }
    
    public T getMentorWithName(Object name) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getMentorWithName(connection, name);
        } finally {
            connection.close();
        }
        return t;
    }

    public boolean addMentor(T mentor) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addMentor(connection, mentor);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean deleteMentor(Object object) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteMentor(connection, object);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean updateMentor(T mentor) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateMentor(connection, mentor);
        } finally {
            connection.close();
        }

        return check;
    }
}
