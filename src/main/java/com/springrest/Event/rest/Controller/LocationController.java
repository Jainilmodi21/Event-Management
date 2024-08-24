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

import com.springrest.Event.rest.Services.LocationService;
import com.springrest.Event.rest.entities.Event;
import com.springrest.Event.rest.entities.Location;



@RestController
@RequestMapping("/api")
public class LocationController {
		
		 private  LocationService locationService;

		 
		   @Autowired
		    public LocationController(LocationService locationService) {
		        this.locationService = locationService;
		    }

		
		@GetMapping("/location")
		public List<Location> FindAll(){
			return this.locationService.FindAll();
		}
		
		@GetMapping("/location/capacity/{capacity}")
		public List<Location> FindByCapacity(@PathVariable int capacity){
			List<Location> theLocation = locationService.FindByCapacity(capacity);
			
			if (theLocation == null) {

				throw new RuntimeException("Location  not found - " + capacity);
				
			}
			
			return theLocation;

		}
		
		@GetMapping("/location/{location_id}")
		public Location getLocation(@PathVariable int location_id) {
			
			Location theLocation = locationService.findById(location_id);
			
			if (theLocation == null) {

				throw new RuntimeException("Event id not found - " + location_id);
			}
			
			return theLocation;
		}
		
		@PostMapping("/location")
		public Location addLocation(@RequestBody Location the_location) {
			
			the_location.setLocation_id(0);
			
			locationService.save(the_location);
			
			return the_location;
		}
		
		@PutMapping("/location")
		public Location updateLocation(@RequestBody Location theLocation) {
			
			locationService.save(theLocation);
			
			return theLocation;
		}
		
		@DeleteMapping("/location/{location_id}")
		public String deleteLocation(@PathVariable int location_id) {
			Location location1=locationService.findById(location_id);
			if(location1==null) {
				throw new RuntimeException("Location id not found - " + location_id);
			}
			
			locationService.deleteById(location_id);
			
			return "Deleted location id - " + location_id;
			
		}
		
		
	}

