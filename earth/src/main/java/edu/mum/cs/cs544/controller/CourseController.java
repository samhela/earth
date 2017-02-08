package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.service.CourseOfferingService;
import edu.mum.cs.cs544.service.CourseService;
import edu.mum.cs.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Controller
public class CourseController {


    @Autowired
    CourseOfferingService courseOfferingService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    //list course
    @RequestMapping(value = "/course/courseList", method = RequestMethod.GET)
    public String listCourses(Model model){
        List<Course> courseList = courseService.allCourses();
        model.addAttribute("courseList", courseList);
        return "course/courseList";
    }

    //add course form
    @RequestMapping(value = "/course/addCourse", method = RequestMethod.GET)
    public String addCourse(ModelMap model){
        Course course = new Course();
        model.addAttribute("course", course);
        model.addAttribute("edit", false);

        return "course/addCourse";
    }

    //add course form post
    //Need validation at this point
    @RequestMapping(value = { "/course/addCourse" }, method = RequestMethod.POST)
    public String saveCourse(Course course, BindingResult result,
                           ModelMap model) {
        courseService.addCourse(course);
        model.addAttribute("success", "Course " + course.getName() + "  registered successfully");
        return "redirect:/course/courseList";
    }
}
