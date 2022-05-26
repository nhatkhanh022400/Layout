package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageUser {

    private String learnerID, learnerName, departmentName, email, phoneNumber, imageAvatar;

    public ManageUser() {
    }

    public ManageUser(String learnerID, String learnerName, String departmentName, String email, String phoneNumber, String imageAvatar) {
        this.learnerID = learnerID;
        this.learnerName = learnerName;
        this.departmentName = departmentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageAvatar = imageAvatar;
    }
}
