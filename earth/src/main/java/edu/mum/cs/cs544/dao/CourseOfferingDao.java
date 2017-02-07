package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.CourseOffering;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public interface CourseOfferingDao {
    public void addCourseOffering(CourseOffering courseOffering);
    public void updateCourseOffering(CourseOffering courseOffering);
    public void deleteCourseOffering(long courseOfferId);
    public List<CourseOffering> allCourseOfferings();

    public List<CourseOffering> findCourseOfferingByCourseName(String courseName);
    public List<CourseOffering> findCourseOfferingByLocation(String locationName);
    public CourseOffering findCourseOfferingById(long courseOfferingId);
}
