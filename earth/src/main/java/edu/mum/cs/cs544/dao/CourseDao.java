package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.Course;

import java.util.List;

/**
 * Created by samue on 2/6/2017.
 */
public interface CourseDao  {

    public void addCourse(Course course);
    public void updateCourse(Course course);
    public void deleteCourse(String courseId);
    public List<Course> allCourses();
    public Course findByCourseId(String courseId);


}
