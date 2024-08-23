package com.course.course.Repo;

import com.course.course.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepo  extends JpaRepository<Courses, Integer> {

    @Query( value = "select * from Courses where coursee_title LIKE %:value% OR courses_code LIKE %:value%", nativeQuery = true)
    List<Courses> searchByValue(String value);
}
