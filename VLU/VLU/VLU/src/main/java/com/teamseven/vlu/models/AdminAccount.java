package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminAccount {

    private String idAdmin, firstName, lastName, userName, password, email, imageAvatar;

    public AdminAccount() {
    }

    public AdminAccount(String idAdmin, String firstName, String lastName, String userName, String password, String email, String imageAvatar) {
        this.idAdmin = idAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.imageAvatar = imageAvatar;
    }
}
