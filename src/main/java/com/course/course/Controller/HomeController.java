package com.course.course.Controller;

import com.course.course.Model.Courses;
import com.course.course.Model.Instances;
import com.course.course.Service.CoursesService;
import com.course.course.Service.InstancesService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private InstancesService instancesService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @PostMapping("/courses")
    public ModelAndView CreateCourses(Courses courses){
        coursesService.createCourses(courses);
        ModelAndView mv= new ModelAndView("index");
        mv.addObject("Message","Data insert Sucessfull");
        return mv;
    }
    @GetMapping("/addcourses")
    public ModelAndView addCourses(){
        return new ModelAndView("index");
    }
    @GetMapping("/courses")
    public ModelAndView listCourses(){
        ModelAndView mv= new ModelAndView("displaycourses");
        List<Courses> list=  coursesService.findAllCourses();
        mv.addObject("list" , list);
        return mv;
    }

    @GetMapping("/courses/{id}")
    public Courses findById(@PathVariable Integer id){
        return coursesService.findCorsesById(id);
    }
    @DeleteMapping("/courses/{id}")
    public String DeleteCoursee(@PathVariable Integer id){
        coursesService.DeleteCourseById(id);
        return " data delete sucessfully";
    }
    @GetMapping("/coursess/{id}")
    public ModelAndView DeleteCourses(@PathVariable Integer id){
        coursesService.DeleteCourseById(id);
        return new ModelAndView("redirect:/api/courses");
    }
    @PostMapping("/search")
    public ModelAndView Search(String value){
        ModelAndView mv= new ModelAndView("displaycourses");
        List<Courses> list = coursesService.Search(value);
        mv.addObject("list",list);
        return mv;

    }
    @PostMapping("/instances")
    public ModelAndView createInstances(int year, int sem,  Integer coursesid){
        ModelAndView mv= new ModelAndView("redirect:/api/addInstance");
        Instances instances = new Instances();
        instances.setSem(sem);
        instances.setYear(year);
        instances.setCoursesid(coursesid);
        String coursesName= coursesService.findCoursesName(coursesid);
        instances.setCourseeTitle(coursesName);
        instancesService.Save(instances);
        mv.addObject("Message","Data Insert Sucessfuly");
        return mv;
    }
    @GetMapping("/instances")
    public ModelAndView displayInstances(){
        ModelAndView mv= new ModelAndView("/listInstance");
        List<Instances> list=  instancesService.findAll();
        mv.addObject("list",list);
        //return "Data Insert Successfull";
        return mv;
    }
    @GetMapping("/instances/{year}")
    public List<Instances> findInstances(@PathVariable Integer year){
        return instancesService.findInstancesByYear(year);
    }

    @GetMapping("/instances/{year}/{sem}")
    public List<Instances> findInstancesBySem(@PathVariable Integer year,@PathVariable Integer sem){
        return instancesService.findInstancesByYearAndSem(year,sem);
    }

    @GetMapping("/instances/{year}/{sem}/{coursesid}")
    public Instances findInstancesById(@PathVariable Integer year,@PathVariable Integer sem,@PathVariable Integer coursesid){
        return instancesService.findInstancesByYearAndSemAndId(year,sem,coursesid);
    }

    @DeleteMapping("/instances/{year}/{sem}/{id}")
    public String DeleteInstancesById(@PathVariable Integer year,@PathVariable Integer sem,@PathVariable Integer id){
        return instancesService.deleteInstancesByYearAndSemAndId(year,sem,id);
    }
    @GetMapping("/addInstance")
    public ModelAndView AddInstance(){
        ModelAndView mv= new ModelAndView("instance");
        List<Courses> list= coursesService.findAllCourses();
        mv.addObject("list",list);
        return mv;
    }
    @GetMapping("/instance/{id}")
    public ModelAndView deleteInstance(@PathVariable Integer id){
        instancesService.deleteInstancesById(id);
        return new ModelAndView("redirect:/api/instances");
    }
    @PostMapping("/searchInstance")
    public ModelAndView searchInstance(String value){
        List<Instances> list= instancesService.search(value);
        ModelAndView mv= new ModelAndView("listInstance");
        mv.addObject("list",list);
        return mv;
    }
}
