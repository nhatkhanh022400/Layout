package com.teamseven.vlu.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompletedCourse {

    private String completedCourseID, learnerID, courseID;
    private Date startDate, endDate;

    public CompletedCourse() {
    }

    public CompletedCourse(String completedCourseID, String learnerID, String courseID, Date startDate, Date endDate) {
        this.completedCourseID = completedCourseID;
        this.learnerID = learnerID;
        this.courseID = courseID;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
