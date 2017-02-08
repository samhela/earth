package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();
    public void addStudent(Student student);
    public Student getStudent(long Id);
    public void deleteStudent(long  Id);
    public void updateStudent(Student student);


}
