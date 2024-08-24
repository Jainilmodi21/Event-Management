package com.springrest.Event.rest.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.Event.rest.entities.Event;

public interface EventDao {
	public List<Event> FindAll();
	public Event findById(int event_id);
	public List<Event> findByLocationId(int location_id);
	public void save(Event the_event);
	public void deleteById(int event_id);
}
