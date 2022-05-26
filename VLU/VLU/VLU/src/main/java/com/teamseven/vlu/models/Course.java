package com.teamseven.vlu.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private String courseID, courseName, mentorID, imageCourse;
    private Date startDate, endDate;
    private int status;

    public Course() {
    }

    public Course(String courseID, String courseName, String mentorID, String imageCourse, Date startDate, Date endDate, int status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.mentorID = mentorID;
        this.imageCourse = imageCourse;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
