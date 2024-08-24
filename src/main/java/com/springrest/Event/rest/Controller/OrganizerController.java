package com.springrest.Event.rest.Controller;

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

import com.springrest.Event.rest.Services.OrganizerService;
import com.springrest.Event.rest.entities.Organizer;


@RestController
@RequestMapping("/api")
public class OrganizerController {
	
	 private  OrganizerService organizerService;
	

	 
	   @Autowired
	    public OrganizerController(OrganizerService organizerService) {
	        this.organizerService = organizerService;
	    }

	
	
	@GetMapping("/organizer")
	public List<Organizer> FindAll(){
		return this.organizerService.FindAll();
	}
	
	@GetMapping("/organizer/{organizer_id}")
	public Organizer getUser(@PathVariable int organizer_id) {

		Organizer theOrganizer = organizerService.findById(organizer_id);
		
		if (theOrganizer == null) {

			throw new RuntimeException("Organizer id not found - " + organizer_id);
		}
		
		return theOrganizer;
	}
	
	@PostMapping("/organizer")
	public Organizer addEvent(@RequestBody Organizer the_organizer) {
		
		
		organizerService.save(the_organizer);
		
		return the_organizer;
	}
	
	@PutMapping("/organizer")
	public Organizer updateUser(@RequestBody Organizer theOrganizer) {
		
		organizerService.save(theOrganizer);
		
		return theOrganizer;
	}
	
	@DeleteMapping("/organizer/{organizer_id}")
	public String deleteUser(@PathVariable int organizer_id) {
		Organizer organizer1=organizerService.findById(organizer_id);
		if(organizer1==null) {
			throw new RuntimeException("Organizer id not found - " + organizer_id);
		}
		
		organizerService.deleteById(organizer_id);
		
		return "Deleted organizer id - " + organizer_id;
		
	}
	
	
}

