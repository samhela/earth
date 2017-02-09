package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.CourseDao;
import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Location;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/6/2017.
 */
@Repository("courseDao")
public class  CourseDaoImpl extends AbstractDao<Integer, Course> implements CourseDao{

    static final Logger logger = LoggerFactory.getLogger(CourseDaoImpl.class);

    @Override
    public void addCourse(Course course) {
        persist(course);
    }

    @Override
    public void updateCourse(Course course) {
        update(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        Course course = (Course) createNamedEntityQuery("Course.findByCourseId")
                .setParameter("courseId", courseId)
                .uniqueResult();
        delete(course);
    }

    @Override
    public List<Course> allCourses() {
        List<Course> courses = (List<Course>) createNamedEntityQuery("Course.finadAllCourse").list();
        return courses;
    }

    @Override
    public Course findByCourseId(String courseId) {

        Course course = (Course) createNamedEntityQuery("Course.findByCourseId")
                .setParameter("courseId", courseId)
                .uniqueResult();
        return course;
    }

	@Override
	public List<CourseOffering> getCourseOfferings(String courseId) {
		 Course course = (Course) createNamedEntityQuery("Course.findByCourseId")
	               .setParameter("courseId", courseId)
	                .uniqueResult();
		 int id = course.getId();
		 System.out.println("------------------------------>>>"+id);
		 
		 String courseName = course.getName();
		 System.out.println(courseName);
		 
		List<CourseOffering> courseOfferings = createNamedEntityQuery("CourseOffering.findCourseOfferingByCourseName")
				.setParameter("courseName", courseName)
				.list();
		
	
		 
		 
		return courseOfferings;
	}
}
