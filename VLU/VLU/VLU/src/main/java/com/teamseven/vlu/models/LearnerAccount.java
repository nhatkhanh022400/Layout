package com.teamseven.vlu.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LearnerAccount {

    private String learnerID, learnerName, departmentID, email, phoneNumber, imageAvatar;
    private Date dateOfBirth;

    public LearnerAccount() {
    }

    public LearnerAccount(String learnerID, String learnerName, String departmentID, String email, String phoneNumber, String imageAvatar, Date dateOfBirth) {
        this.learnerID = learnerID;
        this.learnerName = learnerName;
        this.departmentID = departmentID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageAvatar = imageAvatar;
        this.dateOfBirth = dateOfBirth;
    }
}
