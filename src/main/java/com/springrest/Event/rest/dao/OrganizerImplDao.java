package com.springrest.Event.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.Event.rest.entities.Organizer;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class OrganizerImplDao implements OrganizerDao{
	private EntityManager entityManager;
	
	@Autowired
	public OrganizerImplDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Organizer> FindAll(){
		TypedQuery<Organizer> theQuery = 
				entityManager.createQuery("from Organizer", Organizer.class);
		
		// execute query and get result list
		List<Organizer> organizers = theQuery.getResultList();
	
		// return the results		
		return organizers;
	}
	
	@Override
	public Organizer findById(int organizer_id) {
		Organizer theUser = 
				entityManager.find(Organizer.class, organizer_id);
		return theUser;
	}
	
	@Override
	public void save(Organizer the_organizer) {
		
		Organizer dborganizer=entityManager.merge(the_organizer);
		
	}
	@Override
	public void deleteById(int organizer_id) {
		Query theQuery = entityManager.createQuery(
				"delete from Organizer where organizer_id=:organizer_id");

		theQuery.setParameter("organizer_id", organizer_id);

		theQuery.executeUpdate();
	}
}
