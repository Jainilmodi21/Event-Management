package com.springrest.Event.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.Event.rest.entities.Event;
import com.springrest.Event.rest.entities.Location;




public interface LocationDao {
	public List<Location> FindAll();
	public List<Location> FindByCapacity(int capacity);
	public Location findById(int location_id);
	public void save(Location the_location);
	public void deleteById(int location_id);
}