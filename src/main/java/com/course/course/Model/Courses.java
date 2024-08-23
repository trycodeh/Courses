package com.course.course.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Courses {

    @Id
    @GeneratedValue
    private int id;
    private String CourseeTitle;
    private Integer CoursesCode;
    private String Description;

    public Courses(String courseeTitle, Integer coursesCode, String description) {
        CourseeTitle = courseeTitle;
        CoursesCode = coursesCode;
        Description = description;
    }
}
