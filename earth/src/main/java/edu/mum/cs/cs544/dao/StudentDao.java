package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();
    public void addStudent(Student student);
    public Student getStudent(long Id);
    public void deleteStudent(long  Id);
    public void updateStudent(Student student);
    public List<CourseOffering> registredCourse(CourseOffering courseOffering);
    public List<AttendanceRecord> getAttendanceRecod(long  locationId);



}
