package com.springrest.Event.rest.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.Event.rest.entities.Event;


public interface EventService {
	public List<Event> FindAll();
	public Event findById(int event_id);
	public List<Event> findByLocationId(int location_id);
	public void save(Event the_event);
	public void deleteById(int event_id);
}

