package edu.mum.cs.cs544.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.service.FacultyService;

@Controller
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	 @RequestMapping(value={"/viewStudentAttendance"},  method = RequestMethod.GET)
	    public String studentAttendance(Model model){
	        System.out.println("Faculty Controller is called");
	        // need to show students
	        return "studentTest/attendance";
	    }
	 
	 @RequestMapping("/faculty")
	 public ModelAndView test()
	 {
		 String s ="/student/attendance";
		 ModelAndView model = new ModelAndView(s);
		 System.out.println("------------------------------");
		 
		 return model;
		 
	 }
}
