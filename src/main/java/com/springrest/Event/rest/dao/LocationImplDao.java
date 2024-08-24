package com.springrest.Event.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.Event.rest.entities.Event;
import com.springrest.Event.rest.entities.Location;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@Repository
public class LocationImplDao implements LocationDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public LocationImplDao(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public List<Location> FindAll(){
		TypedQuery<Location> q1=entityManager.createQuery("From Location",Location.class);
		List<Location> locations = q1.getResultList();
		return locations;
	}
	@Override
	public Location findById(int location_id) {
		Location theLocation = 
				entityManager.find(Location.class, location_id);
		return theLocation;
	}
	
	public List<Location> FindByCapacity(int capacity){
		TypedQuery<Location> theQuery =
				entityManager.createQuery("from Location Where capacity>= :capacity", Location.class);
				theQuery.setParameter("capacity", capacity);
				List<Location> locations = theQuery.getResultList();
				
				// return the results		
				return locations;
	}
	@Override
	public void save(Location the_location) {
		System.out.println("Before Setting: "+the_location.getLocation_id());
		Location dblocaion=entityManager.merge(the_location);
		System.out.println("After Setting: "+the_location.getLocation_id());
	}
	@Override
	public void deleteById(int location_id) {
		Query theQuery = entityManager.createQuery(
				"delete from Location where location_id=:location_id");

		theQuery.setParameter("location_id", location_id);

		theQuery.executeUpdate();
	}
}
