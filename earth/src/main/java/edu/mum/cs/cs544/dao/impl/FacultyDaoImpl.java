package edu.mum.cs.cs544.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.FacultyDoa;
import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.Timeslot;
import edu.mum.cs.cs544.model.UserProfile;

@Repository("facultyDao")
@Transactional
public class FacultyDaoImpl extends AbstractDao<Integer, Student> implements FacultyDoa {

	@Override
	public Student findById(int id) {
		Student student = getByKey(id);
		return student;
	}

	@Override
	public Student findByFirstname(String firstname) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("firstname", firstname));
		Student student = (Student)crit.uniqueResult();
		
		return student;
	}

	@Override
	public Student findByLastname(String lastname) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("lastname", lastname));
		Student student = (Student)crit.uniqueResult();
		
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("firstname"));
		return (List<Student>)crit.list();
	}

	@Override
	public Course viewByCouseId(String courseId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("courseId", courseId));
		return (Course) crit.uniqueResult();
	}

	@Override
	public List<CourseOffering> findAllCourseOffering(String courseId) {
		Criteria crit = createEntityCriteria().createAlias("courseId", "co");
		crit.add(Restrictions.eq("co.courseId", courseId));
		return (List<CourseOffering>) crit.list();
	}

	@Override
	public List<Session> viewListOfSession(CourseOffering courseOfferingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> readListOfLocation(CourseOffering courseOfferingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Timeslot> readListOfTimeSlot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendanceRecord> findStudentAttendanceRecords(Student student) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
