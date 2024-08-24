package com.springrest.Event.rest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springrest.Event.rest.dao.LocationDao;
import com.springrest.Event.rest.entities.Location;
@Service
public class LocationServiceimpl implements LocationService {
	
	private LocationDao locationDao;
	
	@Autowired
	public LocationServiceimpl(@Qualifier("locationImplDao") LocationDao theLocationDao) {
		locationDao = theLocationDao;
	}
	
	
	@Override
	@Transactional
	public List<Location> FindAll(){
		return locationDao.FindAll();
	}
	
	@Override
	@Transactional
	public Location findById(int location_id) {
		return locationDao.findById(location_id);
	}
	@Override
	@Transactional
	public List<Location> FindByCapacity(int capacity){
		return locationDao.FindByCapacity(capacity);
	}
	
	@Override
	@Transactional
	public void save(Location the_location) {
		 locationDao.save(the_location);
	}
	
	@Override
	@Transactional
	public void deleteById(int location_id) {
		locationDao.deleteById(location_id);
	}
}
