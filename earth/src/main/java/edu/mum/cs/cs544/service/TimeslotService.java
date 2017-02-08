package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Timeslot;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public interface TimeslotService {
    public void addTimeslot(Timeslot timeslot);
    public void updateTimeslot(Timeslot timeslot);
    public void deleteTimeslot(long timeslotId);
    public List<Timeslot> allTimeslot();
    public Timeslot findBySessionId(long sessionId);
    public Timeslot findByTimeslotId(long timeslotId);
}
