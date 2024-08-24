package com.springrest.Event.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organizer_id")
    private int organizer_id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "email")
    private String email;

    // Constructors, getters, and setters
    public Organizer() {
    }

    public Organizer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getOrganizerId() {
        return organizer_id;
    }

    public void setOrganizerId(int id) {
        this.organizer_id = id;
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

    @Override
    public String toString() {
        return "Organizer [organizer_id=" + organizer_id + ", name=" + name + ", email=" + email + "]";
    }
}

