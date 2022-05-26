package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor {

    private String mentorID, mentorName, mentorPhone, mentorEmail;

    public Mentor() {
    }

    public Mentor(String mentorID, String mentorName, String mentorPhone, String mentorEmail) {
        this.mentorID = mentorID;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
    }
}
