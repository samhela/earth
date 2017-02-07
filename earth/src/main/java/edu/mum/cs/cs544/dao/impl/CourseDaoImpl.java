package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.CourseDao;
import edu.mum.cs.cs544.model.Course;
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
    public void deleteCourse(long courseId) {
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
    public Course findByCourseId(long courseId) {

        Course course = (Course) createNamedEntityQuery("Course.findByCourseId")
                .setParameter("courseId", courseId)
                .uniqueResult();
        return course;
    }
}
