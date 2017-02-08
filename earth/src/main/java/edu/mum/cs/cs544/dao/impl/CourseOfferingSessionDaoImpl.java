package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.CourseOfferingSessionDao;
import edu.mum.cs.cs544.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Repository("courseOfferingSessionDao")
public class CourseOfferingSessionDaoImpl extends AbstractDao<Integer, Session> implements CourseOfferingSessionDao {

    static final Logger logger = LoggerFactory.getLogger(CourseOfferingSessionDaoImpl.class);

    @Override
    public void addSession(Session session) {
        persist(session);

    }

    @Override
    public void updateSession(Session session) {
        update(session);

    }

    @Override
    public void deleteSession(long sessionId) {
        Session session = (Session) createNamedEntityQuery("Session.findBySessionId")
                .setParameter("sessionId", sessionId)
                .uniqueResult();
        delete(session);

    }

    @Override
    public List<Session> allSessions() {
        return createNamedEntityQuery("Session.allSessions").list();
    }

    @Override
    public Session _findByCourseOfferingId(long courseOfferingId) {
        Session session = (Session) createNamedEntityQuery("Session.findByCourseOfferingId")
                .setParameter("courseOfferingId", courseOfferingId)
                .uniqueResult();
        return session;
    }
}
