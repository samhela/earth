package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.CourseOfferingDao;
import edu.mum.cs.cs544.model.CourseOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Repository("courseOffering")
public class CourseOfferingImpl extends AbstractDao<Integer, CourseOffering> implements CourseOfferingDao{

    static final Logger logger = LoggerFactory.getLogger(CourseOfferingImpl.class);
    @Override
    public void addCourseOffering(CourseOffering courseOffering) {
        persist(courseOffering);

    }

    @Override
    public void updateCourseOffering(CourseOffering courseOffering) {
        update(courseOffering);

    }

    @Override
    public void deleteCourseOffering(long courseOfferId) {
        CourseOffering courseOffering = (CourseOffering) createNamedEntityQuery("CourseOffering.findCourseOfferingById")
                .setParameter("courseOfferringId", courseOfferId)
                .uniqueResult();
        delete(courseOffering);

    }

    @Override
    public List<CourseOffering> allCourseOfferings() {
        return (List<CourseOffering>) createNamedEntityQuery("CourseOffering.allCourseOfferings").list();
    }

    @Override
    public List<CourseOffering> findCourseOfferingByCourseName(String courseName) {
        List<CourseOffering> courseOfferings = (List<CourseOffering>) createNamedEntityQuery("CourseOffering.findCourseOfferingByCourseName")
                .setParameter("courseName", courseName)
                .list();
        return courseOfferings;
    }

    @Override
    public List<CourseOffering> findCourseOfferingByLocation(String locationName) {
        List<CourseOffering> courseOfferings = (List<CourseOffering>) createNamedEntityQuery("CourseOffering.findCourseOfferingByLocation")
                .setParameter("locationName", locationName)
                .list();
        return courseOfferings;
    }

    @Override
    public CourseOffering findCourseOfferingById(long courseOfferingId){
        CourseOffering courseOffering = (CourseOffering) createNamedEntityQuery("CourseOffering.findCourseOfferingById")
                .setParameter("courseOfferingId", courseOfferingId)
                .uniqueResult();
        return courseOffering;
    }
}
