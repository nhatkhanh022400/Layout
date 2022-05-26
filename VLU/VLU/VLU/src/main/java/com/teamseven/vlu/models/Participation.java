package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participation {
    private String participationID, courseID, learnerID;

    public Participation() {
    }

    public Participation(String participationID, String courseID, String learnerID) {
        this.participationID = participationID;
        this.courseID = courseID;
        this.learnerID = learnerID;
    }
}
