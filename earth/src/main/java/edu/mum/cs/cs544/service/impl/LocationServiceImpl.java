package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.LocationDao;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService{
    @Autowired
    LocationDao locationDao;
    @Override
    public void addLocation(Location location) {
        locationDao.addLocation(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationDao.updateLocation(location);

    }

    @Override
    public void deleteLocation(String locationId) {
        locationDao.deleteLocation(locationId);

    }

    @Override
    public List<Location> allLocations() {
        return locationDao.allLocations();
    }

    @Override
    public Location findByLocationId(String locationId) {
        return locationDao.findByLocationId(locationId);
    }

    @Override
    public List<Location> findByLocationName(String locationName) {
        return locationDao.findByLocationName(locationName);
    }

	@Override
	public Location getByLocationId(String locationId) {
		
		return locationDao.getByLocationId(locationId);
	}

	@Override
	public void deleteLocationById(String locationId) {
		locationDao.deleteLocationById(locationId);
		
	}
}
