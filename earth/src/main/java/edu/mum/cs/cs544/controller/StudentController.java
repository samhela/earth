package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.model.UserProfile;
import edu.mum.cs.cs544.service.StudentService;
import edu.mum.cs.cs544.service.UserService;
import edu.mum.cs.cs544.ws.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

/**
 * Created by samue on 2/7/2017.
 */
@Controller
public class StudentController{

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/student/studentList", method = RequestMethod.GET)
    public String listStudent(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        System.out.println("Size is : " + studentList.size());
        return "student/studentList";
    }

    @RequestMapping(value = { "/student/edit-student-{id}" }, method = RequestMethod.GET)
    public String editStudent(@PathVariable long id, ModelMap model) {
        Student student = studentService.getStudent(id);
        if(student == null){
            System.out.println("Student is null");
        }
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        //model.addAttribute("loggedinuser", getPrincipal());
        return "student/addStudent";
    }
    @RequestMapping(value = { "/student/edit-student-{id}" }, method = RequestMethod.POST)
    public String updateStudent(Student student, BindingResult result,
                             ModelMap model, @PathVariable long id) {
        studentService.updateStudent(student);
        return "redirect:/student/studentList";
    }


    @RequestMapping(value = { "/student/delete-student-{id}" }, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/studentList";
    }

    @RequestMapping(value = { "/student/addStudent" }, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result,
                           ModelMap model) {
    	if(!result.hasErrors()){
    		 return "student/addStudent";
    	}
        studentService.addStudent(student);
        model.addAttribute("success", "Studnet " + student.getFirstname() + " With  Barcode "+ student.getBarcode() + " registered successfully");
        return "redirect:/student/studentList";
    }

    @RequestMapping(value = { "/student/addStudent" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("edit", false);

        return "student/addStudent";
    }

    @RequestMapping(value = { "/student/addStudent1" }, method = RequestMethod.POST)
    public String saveStudent(@RequestParam("txtStudentId") String studentId, @RequestParam("txtFirstName") String firstName,
                              @RequestParam("txtLastName") String lastName,  @RequestParam("txtBarcode") String barcode,
                              @RequestParam("txtUserName") String userName,
                              @RequestParam("txtEmail") String email, @RequestParam("txtPassword") String password){


        System.out.println("NEW USER LAST NAME: " + lastName);


        Student student = new Student(studentId, firstName, lastName, barcode);

        User user = new User();

        UserProfile userProfileStudent = new UserProfile();

        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

      /*  Set<UserProfile> userProfilesStudent = new HashSet<UserProfile>();
        userProfileStudent.getType();

        userProfilesStudent.add(userProfileStudent);

        user.getUserProfiles().addAll(userProfilesStudent);
        user.setUserProfiles(userProfilesStudent);*/



        userService.saveUser(user);
        studentService.addStudent(student);

        return "/student/studentList";
    }

    @RequestMapping(value = "/student/studentGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public StudentResponse listStudent() {

        List<Student> students = studentService.getAllStudents();
        StudentResponse response = new StudentResponse();

        response.setRows(students);
        return response;
    }

    @RequestMapping("/student")
    public String studentIndex(Model model){
        //model.addAttribute("loggedinuser", getPrincipal());
        System.out.println("Controller is called");
        return "student/studentDashboard";
    }


}
