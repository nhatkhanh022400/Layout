package com.teamseven.vlu.models;

import lombok.Data;

@Data
public class AdminAccountError {

    private String firstName, lastName, userName, currentPassword, newPassword, confirmNewPassword, email;

    public AdminAccountError() {
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.currentPassword = "";
        this.newPassword = "";
        this.confirmNewPassword = "";
        this.email = "";
    }
}
