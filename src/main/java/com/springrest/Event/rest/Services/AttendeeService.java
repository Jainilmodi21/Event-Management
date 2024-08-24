package com.springrest.Event.rest.Services;

import java.util.List;

import com.springrest.Event.rest.entities.Attendee;


public interface AttendeeService {
	public List<Attendee> getAttendee();
	public Attendee getAttendeeById(int attendee_id);
	public void  save(Attendee attendee);
	public void deleteById(int attendee_id);
}
