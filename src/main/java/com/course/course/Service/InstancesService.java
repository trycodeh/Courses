package com.course.course.Service;

import com.course.course.Model.Instances;
import com.course.course.Repo.InstancesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstancesService {

    @Autowired
    private InstancesRepo instancesRepo;

    public void Save(Instances instances) {
        instancesRepo.save(instances);
    }

    public List<Instances> findInstancesByYear(Integer year) {
        return instancesRepo.findByYear(year);
    }

    public List<Instances> findInstancesByYearAndSem(Integer year, Integer sem) {
        return instancesRepo.findByYearAndSem(year,sem);
    }

    public Instances findInstancesByYearAndSemAndId(Integer year, Integer sem, Integer coursesid) {
        return instancesRepo.findByYearAndSemAndCoursesid(year,sem,coursesid);
    }

    public String deleteInstancesByYearAndSemAndId(Integer year, Integer sem, Integer coursesid) {
        Instances instances= instancesRepo.findByYearAndSemAndCoursesid(year,sem,coursesid);
        instancesRepo.delete(instances);
        return "data delete sucessfuly";
    }

    public List<Instances> findAll() {
        return instancesRepo.findAll();
    }

    public void deleteInstancesById(Integer id) {
        instancesRepo.deleteById(id);
    }

    public List<Instances> search(String value) {
        return instancesRepo.search(value);
    }
}
