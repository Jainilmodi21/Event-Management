package com.springrest.Event.rest.Controller;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Event.rest.Services.AttendeeService;
import com.springrest.Event.rest.Services.EventService;
import com.springrest.Event.rest.Services.LocationService;
import com.springrest.Event.rest.Services.OrganizerService;
import com.springrest.Event.rest.entities.Event;
import com.springrest.Event.rest.entities.Location;
import com.springrest.Event.rest.entities.Organizer;


@RestController
@RequestMapping("/api")
public class EventController {
	
	 private  EventService eventService;
	 private AttendeeService attendeeService;
	 @Autowired
	 private LocationService locationService;
	 
	 @Autowired
	 private OrganizerService organizerService;
	 
	   @Autowired
	    public EventController(EventService eventService) {
	        this.eventService = eventService;
//	        this.locationService=locationService;
//	        this.organizerService=organizerService;
	    }

	@GetMapping("/home")
	public String home() {
		return "Welcome to Event management application";
	}
	
	@GetMapping("/events")
	public List<Event> FindAll(){
		return this.eventService.FindAll();
	}
	
	@GetMapping("/events/{event_id}")
	public Event getEvent(@PathVariable int event_id) {
		
		Event theEvent = eventService.findById(event_id);
		
		if (theEvent == null) {

			throw new RuntimeException("Event id not found - " + event_id);
			
		}
		
		return theEvent;
	}
	
	@GetMapping("/events/location/{location_id}")
	public List<Event> getEventByLocation(@PathVariable int location_id) {
		
		List<Event> theEvent = eventService.findByLocationId(location_id);
		
		if (theEvent == null) {

			throw new RuntimeException("Event  not found on- " + location_id);
			
		}
		
		return theEvent;
	}
	
	
	
	@PostMapping("/events")
	public Event addEvent(@RequestBody Event the_event) {
		the_event.setEvent_id(0);
		
		int location_id=the_event.getLocation_id();
		
		Location l1 = locationService.findById(location_id);
		the_event.setLocation(l1);
		
int organizer_id=the_event.getOrganizer_id();		
		Organizer o1 = organizerService.findById(organizer_id);
	the_event.setOrganizer(o1);
		
		
		eventService.save(the_event);
		
		return the_event;
	}
	
	@PutMapping("/events")
	public Event updateEvent(@RequestBody Event theEvent) {
int location_id=theEvent.getLocation_id();
		
		Location l1 = locationService.findById(location_id);
		theEvent.setLocation(l1);
		
int organizer_id=theEvent.getOrganizer_id();		
		Organizer o1 = organizerService.findById(organizer_id);
	theEvent.setOrganizer(o1);
		
		
		eventService.save(theEvent);
		
		return theEvent;
			
	}
	
	@DeleteMapping("/events/{event_id}")
	public String deleteEmployee(@PathVariable int event_id) {
		Event event1=eventService.findById(event_id);
		if(event1==null) {
			throw new RuntimeException("Event id not found - " + event_id);
		}
		
		eventService.deleteById(event_id);
		
		return "Deleted event id - " + event_id;
		
	}
	
	
}
