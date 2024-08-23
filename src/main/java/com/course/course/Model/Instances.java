package com.course.course.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Instances {

    @Id
    @GeneratedValue
    private int id;
    private int year;
    private int sem;
    private int coursesid;
    private String CourseeTitle;

}
