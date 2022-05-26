package com.teamseven.vlu.models;

import lombok.Data;

@Data
public class LearnerAccountError {

    private String learnerName, department, phoneNumber;
    
    public LearnerAccountError() {
        this.learnerName = "";
        this.department = "";
        this.phoneNumber = "";
    }
}
