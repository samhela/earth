package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Course;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */

public interface CourseService{
    public void addCourse(Course course);
    public void updateCourse(Course course);
    public void deleteCourse(long courseId);
    public List<Course> allCourses();
    public Course findByCourseId(long courseId);
}
