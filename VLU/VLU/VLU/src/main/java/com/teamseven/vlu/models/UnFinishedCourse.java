package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnFinishedCourse {

    private String unFinishedCourseID, learnerID, courseID;

    public UnFinishedCourse() {
    }

    public UnFinishedCourse(String unFinishedCourseID, String learnerID, String courseID) {
        this.unFinishedCourseID = unFinishedCourseID;
        this.learnerID = learnerID;
        this.courseID = courseID;
    }
}
