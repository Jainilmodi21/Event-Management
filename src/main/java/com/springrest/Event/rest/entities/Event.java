package com.springrest.Event.rest.entities;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private int event_id;
	
	
	@Column(name="EventName")
	private String EventName;
	
	@Temporal(TemporalType.TIME)
	@Column(name="StartTime")
	private LocalTime StartTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name="EndTime")
	private LocalTime EndTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private LocalDate Date;
	
	@ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.REFRESH})
	@JoinColumn(name="organizer_id")
	private Organizer organizer;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="location_id")
	private Location location;
	
	@Transient
	private int location_id;
	
	@Transient
	private int organizer_id;
	
	public int getOrganizer_id() {
		return organizer_id;
	}
	public void setOrganizer_id(int organizer_id) {
		this.organizer_id = organizer_id;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public Event( String eventName, LocalTime startTime, LocalTime endTime,LocalDate date,
			Location location) {
		super();
		EventName = eventName;
		StartTime = startTime;
		EndTime = endTime;
		Date=date;
//		EventOrganizer = eventOrganizer;
		this.location = location;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public LocalTime getStartTime() {
		return StartTime;
	}
	public void setStartTime(LocalTime startTime) {
		StartTime = startTime;
	}
	public LocalTime getEndTime() {
		return EndTime;
	}
	public void setEndTime(LocalTime endTime) {
		EndTime = endTime;
	}
//	public Users getEventOrganizer() {
//		return EventOrganizer;
//	}
//	public void setEventOrganizer(Users eventOrganizer) {
//		EventOrganizer = eventOrganizer;
//	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", EventName=" + EventName + ", StartTime=" + StartTime + ", EndTime="
				+ EndTime + ", Date=" + Date + ", Location=" + location + "]";
	}
	
	
}
