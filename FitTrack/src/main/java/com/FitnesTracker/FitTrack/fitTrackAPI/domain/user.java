package com.FitnesTracker.FitTrack.fitTrackAPI.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import lombok.NonNull;

import java.util.Date;

@Entity//defines that this class is an entity
@Getter//sets getters for fields
@Setter
@Builder//sets builder pattern

@NoArgsConstructor//sets no args constructor
@AllArgsConstructor//sets all args constructor

@Table(name = "users")

public class user {
    
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    
    //A non null values will not be acceped for these fields
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private Date dateOfBirth;
    @NonNull
    private Date dateOfCreation;

    //optional fields
    private String height;
    private String starting_weight;
    private String current_weight;
    private String goal_weight;

    /*
    Todo:
    - add validation for email format
    - add password field with encryption
    - add age calculation based on dateOfBirth
    - implement relationships with other entities (e.g., workouts)
    - add methods for updating user information

    */
    
}
