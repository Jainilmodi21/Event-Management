package com.springrest.Event.rest.Services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springrest.Event.rest.dao.AttendeeDao;
import com.springrest.Event.rest.entities.Attendee;

@Service
public class AttendeeServiceimpl implements AttendeeService{
	private AttendeeDao attendeeDao;

	@Autowired
	public AttendeeServiceimpl(@Qualifier("attendeeImplDao")AttendeeDao attendeeDao) {
	
		this.attendeeDao = attendeeDao;
	}

	@Override
	@Transactional
	public List<Attendee> getAttendee() {
		return attendeeDao.findAll();
	}
	
	@Override
	@Transactional
	public Attendee getAttendeeById(int attendee_id) {
		return attendeeDao.getAttendeeById(attendee_id);
	}
	
	@Override
	@Transactional
	public void save(Attendee attendee) {
		 attendeeDao.save(attendee);
	}
	
	@Override
	@Transactional
	public void deleteById(int attendee_id) {
		attendeeDao.deleteById(attendee_id);
	}
	
	
}
