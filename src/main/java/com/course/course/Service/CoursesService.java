package com.course.course.Service;

import com.course.course.Model.Courses;
import com.course.course.Repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepo coursesRepo;

    public void createCourses(Courses courses) {
        coursesRepo.save(courses);
    }

    public List<Courses> findAllCourses() {
        return coursesRepo.findAll();
    }

    public Courses findCorsesById(Integer id) {
        return coursesRepo.findById(id).get();
    }

    public void DeleteCourseById(Integer id) {
        coursesRepo.deleteById(id);
    }

    public List<Courses> Search(String value) {
        return  coursesRepo.searchByValue(value);
    }

    public String findCoursesName(Integer id) {
        Courses courses = coursesRepo.findById(id).get();
        return courses.getCourseeTitle();
    }
}
