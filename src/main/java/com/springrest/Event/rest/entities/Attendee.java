package com.springrest.Event.rest.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="attendee")
public class Attendee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attendee_id")
	private int attendee_id;

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	 @Transient
	 private int event_id;
	
	 public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	@ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="event_id")
	private Event event;
	@Column(name="status")
	private String status;
	
	

	public Attendee() {
		super();
		
	}
	public Attendee(int attendee_id, String name, String email, int event_id, Event event, String status) {
		super();
		this.attendee_id = attendee_id;
		this.name = name;
		this.email = email;
		this.event_id = event_id;
		this.event = event;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAttendee_id() {
		return attendee_id;
	}
	public void setAttendee_id(int attendee_id) {
		this.attendee_id = attendee_id;
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attendee [attendee_id=" + attendee_id + ", name=" + name + ", email=" + email + ", event=" + event
				+ ", status=" + status + "]";
	}	
	
}

