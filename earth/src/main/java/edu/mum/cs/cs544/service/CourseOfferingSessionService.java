package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Session;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public interface CourseOfferingSessionService {
    public void addSession(Session session);
    public void updateSession(Session session);
    public void deleteSession(long sessionId);
    public List<Session> allSessions();
    public Session _findByCourseOfferingId(long courseOfferingId);
}
