package com.springrest.Event.rest.Services;

import java.util.List;

import com.springrest.Event.rest.entities.Location;



public interface LocationService {
	public List<Location> FindAll();
	public List<Location> FindByCapacity(int capacity);
	public Location findById(int location_id);
	public void save(Location the_location);
	public void deleteById(int location_id);
}
