package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Location;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public interface LocationService {
    public void addLocation(Location location);
    public void updateLocation(Location location);
    public void deleteLocation(long locationId);
    public List<Location> allLocations();
    public Location findByLocationId(long locationId);
    public List<Location> findByLocationName(long locationName);
}
