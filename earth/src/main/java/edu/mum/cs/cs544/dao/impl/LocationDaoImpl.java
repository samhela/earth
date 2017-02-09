package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.LocationDao;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.model.Student;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Repository("locationDao")
public class LocationDaoImpl extends AbstractDao<Integer, Location> implements LocationDao {
    static final Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);

    @Override
    public void addLocation(Location location) {
        persist(location);

    }

    @Override
    public void updateLocation(Location location) {
        update(location);
    }

    @Override
    public void deleteLocation(String locationId) {
        Location location = (Location) createNamedEntityQuery("Location._findByLocationId")
                .setParameter("locationId", locationId)
                .uniqueResult();
        delete(location);
    }

    @Override
    public List<Location> allLocations() {
        return (List<Location>) createNamedEntityQuery("Location.allLocations").list();
    }

    @Override
    public Location findByLocationId(String locationId) {
        Location location = (Location) createNamedEntityQuery("Location._findByLocationId")
                .setParameter("locationId", locationId)
                .uniqueResult();
        return location;
    }

    @Override
    public List<Location> findByLocationName(String locationName) {
        List<Location> locations = (List<Location>) createNamedEntityQuery("Location._findByLocationName")
                .setParameter("locationName", locationName)
                .list();
        return locations;
    }

	@Override
	public Location getByLocationId(String locationId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("locationId", locationId));
		Location location = (Location)crit.uniqueResult();
		return location;
	}

	@Override
	public void deleteLocationById(String locationId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("locationId", locationId));
		Location location = (Location)crit.uniqueResult();
	        delete(location);
	}
}
