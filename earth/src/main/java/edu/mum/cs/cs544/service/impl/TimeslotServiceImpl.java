package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.TimeslotDao;
import edu.mum.cs.cs544.model.Timeslot;
import edu.mum.cs.cs544.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Service("timeSlotService")
@Transactional
public class TimeslotServiceImpl implements TimeslotService {


    @Autowired
    TimeslotDao timeslotDao;


    @Override
    public void addTimeslot(Timeslot timeslot) {
        timeslotDao.addTimeslot(timeslot);

    }

    @Override
    public void updateTimeslot(Timeslot timeslot) {
        timeslotDao.updateTimeslot(timeslot);

    }

    @Override
    public void deleteTimeslot(long timeslotId) {
        timeslotDao.deleteTimeslot(timeslotId);

    }

    @Override
    public List<Timeslot> allTimeslot() {
        return timeslotDao.allTimeslot();
    }

    @Override
    public Timeslot findBySessionId(long sessionId) {
        return timeslotDao.findBySessionId(sessionId);
    }

    @Override
    public Timeslot findByTimeslotId(long timeslotId) {
        return timeslotDao.findByTimeslotId(timeslotId);
    }
}
