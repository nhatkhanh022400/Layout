package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {

    private String departmentID, departmentName;

    public Department() {
    }

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
}
