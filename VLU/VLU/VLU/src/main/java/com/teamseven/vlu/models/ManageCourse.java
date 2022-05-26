package com.teamseven.vlu.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageCourse {

    private String courseID, courseName, mentorName, mentorPhone, mentorEmail, courseDetailDescription;
    private Date startDate, endDate;
    private int status;

    public ManageCourse() {
    }

    public ManageCourse(String courseID, String courseName, String mentorName, String mentorPhone, String mentorEmail, String courseDetailDescription, Date startDate, Date endDate, int status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
        this.courseDetailDescription = courseDetailDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
