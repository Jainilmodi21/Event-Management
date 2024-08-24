package com.springrest.Event.rest.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Event.rest.Services.AttendeeService;
import com.springrest.Event.rest.Services.EventService;
import com.springrest.Event.rest.Services.EventServiceimpl;
import com.springrest.Event.rest.entities.Attendee;
import com.springrest.Event.rest.entities.Event;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class AttendeeController {
	 private AttendeeService attendeeService;
	
	 @Autowired
	   public AttendeeController(AttendeeService attendeeService) {
		   this.attendeeService=attendeeService;
	   }
	 
	 @Autowired
	 private EventService eventService;
	 
	
	 
	 @GetMapping("/attendee")
	 public List<Attendee> getAttendee(){
		 return attendeeService.getAttendee();
	 }
	 
	 @GetMapping("/attendee/{attendee_id}")
	 public Attendee getAttendeeById(@PathVariable int attendee_id) {
		 Attendee a1= attendeeService.getAttendeeById(attendee_id);
		 if (a1 == null) {

				throw new RuntimeException("Attendee id not found - " + attendee_id);
				
			}
		 return a1;
	 }
	 
	 @PostMapping("/attendee")
		public Attendee addAttendee(@RequestBody Attendee the_attendee) {
			the_attendee.setAttendee_id(0);

			int event_id=the_attendee.getEvent_id();
		
			Event e1 = eventService.findById(event_id);
			the_attendee.setEvent(e1);
			attendeeService.save(the_attendee);
			
			return the_attendee;
		}
	 
	 @PutMapping("/attendee")
		public Attendee updateAttendee(@RequestBody Attendee theAttendee) {
		 int event_id=theAttendee.getEvent_id();
			
		 Event e1 = eventService.findById(event_id);
			theAttendee.setEvent(e1);
			attendeeService.save(theAttendee);
			
			return theAttendee;
		}
		
		@DeleteMapping("/attendee/{attendee_id}")
		public String deleteattendee(@PathVariable int attendee_id) {
			Attendee attendee1=attendeeService.getAttendeeById(attendee_id);
			if(attendee1==null) {
				throw new RuntimeException("Attendee id not found - " + attendee_id);
			}
			
			attendeeService.deleteById(attendee_id);
			
			return "Deleted attendee id - " + attendee_id;
			
		}
}
