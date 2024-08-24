package com.springrest.Event.rest.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.Event.rest.dao.EventDao;
import com.springrest.Event.rest.entities.Event;

@Service
public class EventServiceimpl implements EventService {
	
	private EventDao eventDao;
	
	@Autowired
	public EventServiceimpl(@Qualifier("eventImplDao") EventDao theEventDao) {
		eventDao = theEventDao;
	}
	
	@Override
	@Transactional
	public List<Event> FindAll() {
		return eventDao.FindAll();
	}
	
	@Override
	@Transactional
	public Event findById(int event_id) {
		return eventDao.findById(event_id);
	}
	
	@Override
	@Transactional
	public void save(Event the_event) {
		 eventDao.save(the_event);
	}
	
	@Override
	@Transactional
	public void deleteById(int event_id) {
		 eventDao.deleteById(event_id);
	}
	
	@Override
	@Transactional
	public List<Event> findByLocationId(int location_id) {
		return eventDao.findByLocationId(location_id);
	}
}
