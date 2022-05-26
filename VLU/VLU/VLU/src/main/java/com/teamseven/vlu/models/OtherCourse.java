package com.teamseven.vlu.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtherCourse {

    private String otherCourseID, otherCourseName, learnerID, certificateImage;
    private Date startDate, endDate;

    public OtherCourse() {
    }

    public OtherCourse(String otherCourseID, String otherCourseName, String learnerID, String certificateImage, Date startDate, Date endDate) {
        this.otherCourseID = otherCourseID;
        this.otherCourseName = otherCourseName;
        this.learnerID = learnerID;
        this.certificateImage = certificateImage;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
