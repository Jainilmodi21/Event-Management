package com.springrest.Event.rest.dao;

import java.util.List;

import com.springrest.Event.rest.entities.Organizer;


public interface OrganizerDao {
	public List<Organizer> FindAll();
	public Organizer findById(int organizer_id);
	public void save(Organizer the_organizer);
	public void deleteById(int organizer_id);
}
