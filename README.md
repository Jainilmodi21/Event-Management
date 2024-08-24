# Event Management API

## Overview

The Event Management API is a RESTful web service built with Spring Boot that allows users to manage events, locations, organizers, and attendees. The API provides endpoints for creating, reading, updating, and deleting entities related to events. The application is designed to prevent double booking of locations at the same time for different events.

## Features

- **Event Management**: Create, update, retrieve, and delete events. The API ensures that no two events can book the same location at the same time.
- **Attendee Management**: Manage attendees for events, including adding and updating attendee information.
- **Location Management**: Manage event locations, including creating, updating, and finding locations based on capacity.
- **Organizer Management**: Manage event organizers, including creating, updating, and retrieving organizer information.

## Endpoints

### Event Endpoints

- **GET /api/events**: Retrieve a list of all events.
- **GET /api/events/{event_id}**: Retrieve details of a specific event by its ID.
- **GET /api/events/location/{location_id}**: Retrieve events by location ID.
- **POST /api/events**: Create a new event. This endpoint prevents double booking by checking if the location is available at the specified date and time.
- **PUT /api/events**: Update an existing event.
- **DELETE /api/events/{event_id}**: Delete an event by its ID.

### Attendee Endpoints

- **GET /api/attendee**: Retrieve a list of all attendees.
- **GET /api/attendee/{attendee_id}**: Retrieve details of a specific attendee by their ID.
- **POST /api/attendee**: Add a new attendee to an event.
- **PUT /api/attendee**: Update an existing attendee's information.
- **DELETE /api/attendee/{attendee_id}**: Delete an attendee by their ID.

### Location Endpoints

- **GET /api/location**: Retrieve a list of all locations.
- **GET /api/location/{location_id}**: Retrieve details of a specific location by its ID.
- **GET /api/location/capacity/{capacity}**: Retrieve locations based on their capacity.
- **POST /api/location**: Create a new location.
- **PUT /api/location**: Update an existing location.
- **DELETE /api/location/{location_id}**: Delete a location by its ID.

### Organizer Endpoints

- **GET /api/organizer**: Retrieve a list of all organizers.
- **GET /api/organizer/{organizer_id}**: Retrieve details of a specific organizer by their ID.
- **POST /api/organizer**: Create a new organizer.
- **PUT /api/organizer**: Update an existing organizer.
- **DELETE /api/organizer/{organizer_id}**: Delete an organizer by their ID.



### Prerequisites

- Java 17 or later
- Maven
- MySQL (or any other preferred relational database)




