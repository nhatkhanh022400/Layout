package com.teamseven.vlu.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDetail {

    private String courseDetailID, courseDetailDescription, courseID;

    public CourseDetail() {
    }

    public CourseDetail(String courseDetailID, String courseDetailDescription, String courseID) {
        this.courseDetailID = courseDetailID;
        this.courseDetailDescription = courseDetailDescription;
        this.courseID = courseID;
    }
}
