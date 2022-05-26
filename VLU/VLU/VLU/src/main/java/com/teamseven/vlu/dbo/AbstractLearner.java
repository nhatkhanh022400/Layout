package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLearner<T> {

    private Connection connection;

    protected abstract List<T> getAllLearnerAccount(Connection connection) throws SQLException;

    protected abstract boolean updateLearnerAccount(Connection connection, T learner) throws SQLException;

    protected abstract boolean addLearner(Connection connection, T learner) throws SQLException;

    protected abstract T getLearnerAccount(Connection connection, Object object) throws SQLException;
    
    protected abstract boolean deleteLearnerAccount(Connection connection, Object id) throws SQLException;

    public boolean updateLearnerAccount(T learner) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateLearnerAccount(connection, learner);
        } finally {
            connection.close();
        }

        return check;
    }

    public boolean addLearner(T learner) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addLearner(connection, learner);
        } finally {
            connection.close();
        }

        return check;
    }

    public T getLearnerAccount(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getLearnerAccount(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }

    public List<T> getAllLearnerAccount() throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllLearnerAccount(connection);
        } finally {
            connection.close();
        }
        return list;
    }
    
    public boolean deleteLearnerAccount(Object id) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteLearnerAccount(connection, id);
        } finally {
            connection.close();
        }

        return check;
    }
    
}
