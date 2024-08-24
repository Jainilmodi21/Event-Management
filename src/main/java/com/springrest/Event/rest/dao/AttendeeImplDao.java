package com.springrest.Event.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.Event.rest.entities.Attendee;
import com.springrest.Event.rest.entities.Event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class AttendeeImplDao implements AttendeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public AttendeeImplDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Attendee> findAll(){
		TypedQuery<Attendee> theQuery=entityManager.createQuery("from Attendee",Attendee.class);
		List<Attendee> attendee=theQuery.getResultList();
		return attendee;
	}
	
	@Override
	public Attendee getAttendeeById(int attendee_id) {
		Attendee attendee=entityManager.find(Attendee.class, attendee_id);
		return attendee;
	}
	
	@Override
	public void save(Attendee attendee) {
		Attendee attendee1=entityManager.merge(attendee);
	}
	
	@Override
	public void deleteById(int attendee_id) {
		Query theQuery = entityManager.createQuery(
				"delete from Attendee where attendee_id=:attendee_id");

		theQuery.setParameter("attendee_id", attendee_id);

		theQuery.executeUpdate();
	}
}
