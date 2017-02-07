package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.CourseOfferingDao;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Service("courseOffering")
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Autowired
    CourseOfferingDao courseOfferingDao;

    @Override
    public void addCourseOffering(CourseOffering courseOffering) {
        courseOfferingDao.addCourseOffering(courseOffering);

    }

    @Override
    public void updateCourseOffering(CourseOffering courseOffering) {
        courseOfferingDao.updateCourseOffering(courseOffering);

    }

    @Override
    public void deleteCourseOffering(long courseOfferId) {
        courseOfferingDao.deleteCourseOffering(courseOfferId);

    }

    @Override
    public List<CourseOffering> allCourseOfferings() {
        return courseOfferingDao.allCourseOfferings();
    }

    @Override
    public List<CourseOffering> findCourseOfferingByCourseName(String courseName) {
        return courseOfferingDao.findCourseOfferingByCourseName(courseName);
    }

    @Override
    public List<CourseOffering> findCourseOfferingByLocation(String locationName) {
        return courseOfferingDao.findCourseOfferingByLocation(locationName);
    }

    @Override
    public CourseOffering findCourseOfferingById(long courseOfferingId) {
        return courseOfferingDao.findCourseOfferingById(courseOfferingId);
    }
}
