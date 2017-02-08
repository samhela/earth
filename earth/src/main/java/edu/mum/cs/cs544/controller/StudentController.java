package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Controller
public class StudentController{

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/studentList", method = RequestMethod.GET)
    public String listStudent(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        System.out.println("Size is : " + studentList.size());

        return "student/studentList";
    }


}
