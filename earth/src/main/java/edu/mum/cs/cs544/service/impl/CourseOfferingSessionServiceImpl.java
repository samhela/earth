package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.CourseOfferingSessionDao;
import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.service.CourseOfferingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Service("courseOfferingSessionService")
@Transactional
public class CourseOfferingSessionServiceImpl implements CourseOfferingSessionService {
    @Autowired
    CourseOfferingSessionDao courseOfferingSessionDao;
    @Override
    public void addSession(Session session) {
        courseOfferingSessionDao.addSession(session);

    }

    @Override
    public void updateSession(Session session) {
        courseOfferingSessionDao.updateSession(session);

    }

    @Override
    public void deleteSession(long sessionId) {
        courseOfferingSessionDao.deleteSession(sessionId);

    }

    @Override
    public List<Session> allSessions() {
        return courseOfferingSessionDao.allSessions();
    }

    @Override
    public Session _findByCourseOfferingId(long courseOfferingId) {
        return courseOfferingSessionDao._findByCourseOfferingId(courseOfferingId);
    }
}
