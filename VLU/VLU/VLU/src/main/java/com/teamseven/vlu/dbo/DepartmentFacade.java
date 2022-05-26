package com.teamseven.vlu.dbo;

import com.teamseven.vlu.models.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentFacade extends AbstractDepartment<Department> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_DEPARTMENT = "SELECT * FROM Department";
    private static final String SQL_GET_DEPARTMENT_WITH_ID = "SELECT * FROM Department WHERE DepartmentID = ?";
    private static final String SQL_DELETE_DEPARTMENT = "DELETE FROM Department WHERE DepartmentID = ?";
    private static final String SQL_ADD_DEPARTMENT = "INSERT INTO Department(DepartmentID, DepartmentName) VALUES(?, ?)";
    private static final String SQL_UPDATE_DEPARTMENT = "UPDATE Department SET DepartmentName = ? WHERE DepartmentID = ?";

    private Department getInfoDepartmentFromSQL(ResultSet resultSet) throws SQLException {
        String getDepartmentID = resultSet.getString("DepartmentID");
        String getDepartmentName = resultSet.getString("DepartmentName");

        return new Department(getDepartmentID, getDepartmentName);
    }

    @Override
    protected List<Department> getAllDepartment(Connection connection) throws SQLException {
        ArrayList<Department> departmentAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_DEPARTMENT);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Department mentor = getInfoDepartmentFromSQL(resultSet);
                    departmentAllList.add(mentor);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return departmentAllList;
    }

    @Override
    protected Department getDepartmentWithID(Connection connection, Object object) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_DEPARTMENT_WITH_ID);
                preparedStatement.setString(1, object.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoDepartmentFromSQL(resultSet);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    protected boolean addDepartment(Connection connection, Department department) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_DEPARTMENT);
                preparedStatement.setString(1, department.getDepartmentID());
                preparedStatement.setString(2, department.getDepartmentName());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected boolean updateDepartment(Connection connection, Department department) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_DEPARTMENT);
                preparedStatement.setString(1, department.getDepartmentName());
                preparedStatement.setString(2, department.getDepartmentID());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected boolean deleteDepartment(Connection connection, Object id) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_DEPARTMENT);
                preparedStatement.setString(1, id.toString());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

}
