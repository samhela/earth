package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Location;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public interface LocationService {
    public void addLocation(Location location);
    public void updateLocation(Location location);
    public void deleteLocation(String locationId);
    public List<Location> allLocations();
    public Location findByLocationId(String locationId);
    public List<Location> findByLocationName(String locationName);
	public Location getByLocationId(String locationId);
	public void deleteLocationById(String locationId);
}
