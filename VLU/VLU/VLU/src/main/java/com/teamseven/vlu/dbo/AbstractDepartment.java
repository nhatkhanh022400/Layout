package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDepartment<T> {

    private Connection connection;

    protected abstract List<T> getAllDepartment(Connection connection) throws SQLException;
    
    protected abstract T getDepartmentWithID(Connection connection, Object object) throws SQLException;
    
    protected abstract boolean addDepartment(Connection connection, T department) throws SQLException;
    
    protected abstract boolean updateDepartment(Connection connection, T department) throws SQLException;
    
    protected abstract boolean deleteDepartment(Connection connection, Object id) throws SQLException;
    
    public List<T> getAllDepartment() throws SQLException {
        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllDepartment(connection);
        } finally {
            connection.close();
        }
        return list;
    }
    
    public T getDepartmentWithID(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getDepartmentWithID(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
    
    public boolean addDepartment(T department) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addDepartment(connection, department);
        } finally {
            connection.close();
        }

        return check;
    }
    
    public boolean updateDepartment(T department) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateDepartment(connection, department);
        } finally {
            connection.close();
        }

        return check;
    }
    
    public boolean deleteDepartment(Object object) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = deleteDepartment(connection, object);
        } finally {
            connection.close();
        }

        return check;
    }
}
