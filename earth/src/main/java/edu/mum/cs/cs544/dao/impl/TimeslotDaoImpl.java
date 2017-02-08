package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.TimeslotDao;
import edu.mum.cs.cs544.model.Timeslot;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Repository("timeSlot")
public class TimeslotDaoImpl extends AbstractDao<Integer, Timeslot> implements TimeslotDao {

    @Override
    public void addTimeslot(Timeslot timeslot) {
        persist(timeslot);
    }

    @Override
    public void updateTimeslot(Timeslot timeslot) {
        update(timeslot);

    }

    @Override
    public void deleteTimeslot(long timeslotId) {
        Timeslot timeslot = (Timeslot) createNamedEntityQuery("Timeslot.timeslotId")
                .setParameter("timeslotId", timeslotId)
                .uniqueResult();
        delete(timeslot);

    }

    @Override
    public List<Timeslot> allTimeslot() {
        return createNamedEntityQuery("Timeslot.allTimeslot").list();
    }

    @Override
    public Timeslot findBySessionId(long sessionId) {
        return (Timeslot) createNamedEntityQuery("Location.findBySessionId")
        .setParameter("sessionId", sessionId).uniqueResult();
    }
    @Override
    public Timeslot findByTimeslotId(long timeslotId) {
        return (Timeslot) createNamedEntityQuery("Timeslot.timeslotId")
                .setParameter("timeslotId", timeslotId).uniqueResult();
    }
}
