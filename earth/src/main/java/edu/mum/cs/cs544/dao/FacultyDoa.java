package edu.mum.cs.cs544.dao;

import java.util.List;

import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.Timeslot;

public interface FacultyDoa {

	Student findById(int id);

	Student findByFirstname(String firstname);
	
	Student findByLastname(String lastname);
	
	List<Student> findAll();
	
	Course viewByCouseId(String courseId);
	
	List<CourseOffering> findAllCourseOffering(String courseId);
	
	List<Session> viewListOfSession(CourseOffering courseOfferingId);
	
	List<Location> readListOfLocation(CourseOffering courseOfferingId);
	
	List<Timeslot> readListOfTimeSlot();
	
	List<AttendanceRecord> findStudentAttendanceRecords(Student student);
}
