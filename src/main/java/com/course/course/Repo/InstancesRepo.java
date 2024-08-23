package com.course.course.Repo;

import com.course.course.Model.Instances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstancesRepo extends JpaRepository<Instances,Integer> {

    List<Instances> findByYear(Integer year);

    List<Instances> findByYearAndSem(Integer year, Integer sem);

    Instances findByYearAndSemAndCoursesid(Integer year, Integer sem, Integer coursesid);

    @Query( value = "select * from instances where coursee_title LIKE %:value% OR sem LIKE %:value% OR year LIKE %:value%", nativeQuery = true)
    List<Instances> search(String value);
}
