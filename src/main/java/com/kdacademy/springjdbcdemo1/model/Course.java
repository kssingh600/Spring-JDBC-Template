package com.kdacademy.springjdbcdemo1.model;

public class Course {
    
    private int courseId ;
    private String title ;
    private String desciption ;
    private String link ;

    public Course() {

    }

    public Course(int courseId, String title, String desciption, String link) {
        this.courseId = courseId;
        this.title = title;
        this.desciption = desciption;
        this.link = link;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", title=" + title + ", desciption=" + desciption + ", link=" + link
        + "]";
    }
    
    
}
