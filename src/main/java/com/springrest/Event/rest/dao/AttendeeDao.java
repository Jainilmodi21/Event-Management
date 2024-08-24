package com.springrest.Event.rest.dao;
import java.util.*;

import com.springrest.Event.rest.entities.Attendee;

public interface AttendeeDao {
	public List<Attendee> findAll();
	public Attendee getAttendeeById(int attendee_id);
	public void save(Attendee attendee);
	public void deleteById(int attendee_id);
	
}
