package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.CourseOffering;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */

public interface CourseService{
    public void addCourse(Course course);
    public void updateCourse(Course course);
    public void deleteCourse(String courseId);
    public List<Course> allCourses();
    public Course findByCourseId(String courseId);
	public List<CourseOffering> getCourseOffering(String courseId);
}
