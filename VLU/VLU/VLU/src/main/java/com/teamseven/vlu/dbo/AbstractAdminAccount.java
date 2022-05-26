package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractAdminAccount<T> {

    protected abstract T checkAdminAccount(Connection connection, Object object) throws SQLException;
    
    protected abstract boolean updateAdminAccount(Connection connection, T t) throws SQLException;
    
    private Connection connection;
    
    public T checkAdminAccount(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = checkAdminAccount(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
    
    public boolean updateAdminAccount(T t) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateAdminAccount(connection, t);
        } finally {
            connection.close();
        }
        
        return check;
    }
}
