package edu.mum.cs.cs544.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs544.dao.FacultyDoa;
import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.Timeslot;
import edu.mum.cs.cs544.service.FacultyService;

@Service("facultyService")
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyDoa dao;
	
	
	@Override
	public Student findByStudentId(int id) {
		return dao.findById(id);
	}

	@Override
	public Student findByFirstname(String firstname) {
		return dao.findByFirstname(firstname);
	}

	@Override
	public Student findByLastname(String lastname) {
		return dao.findByLastname(lastname);
	}

	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public Course viewByCouseId(String courseId) {
		return dao.viewByCouseId(courseId);
	}

	@Override
	public List<CourseOffering> findAllCourseOffering(String courseId) {
		return dao.findAllCourseOffering(courseId);
	}

	@Override
	public List<Session> viewListOfSession(CourseOffering courseOfferingId) {
		return dao.viewListOfSession(courseOfferingId);
	}

	@Override
	public List<Location> readListOfLocation(CourseOffering courseOfferingId) {
		return dao.readListOfLocation(courseOfferingId);
	}

	@Override
	public List<Timeslot> readListOfTimeSlot() {
		return dao.readListOfTimeSlot();
	}

	@Override
	public List<AttendanceRecord> findStudentAttendanceRecords(Student student) {
		return dao.findStudentAttendanceRecords(student);
	}

	
}
