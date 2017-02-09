package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.CourseDao;
import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;


    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseDao.deleteCourse(courseId);
    }

    @Override
    public List<Course> allCourses() {
       return courseDao.allCourses();
    }

    @Override
    public Course findByCourseId(String courseId) {
        return courseDao.findByCourseId(courseId);
    }
}
