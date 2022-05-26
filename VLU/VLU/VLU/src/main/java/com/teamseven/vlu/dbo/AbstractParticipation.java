package com.teamseven.vlu.dbo;

import com.teamseven.vlu.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParticipation<T> {

    private Connection connection;

    protected abstract List<T> getAllParticipation(Connection connection) throws SQLException;

    protected abstract boolean addParticipation(Connection connection, T participation) throws SQLException;

    public List<T> getAllParticipation() throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllParticipation(connection);
        } finally {
            connection.close();
        }
        return list;
    }

    public boolean addParticipation(T participation) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addParticipation(connection, participation);
        } finally {
            connection.close();
        }

        return check;
    }
}
