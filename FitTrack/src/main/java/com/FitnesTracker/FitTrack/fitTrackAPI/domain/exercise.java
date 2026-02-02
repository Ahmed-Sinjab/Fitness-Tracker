package com.FitnesTracker.FitTrack.fitTrackAPI.domain;


import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import lombok.NonNull;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;

import java.util.Date;
import java.util.List;

@Entity//defines that this class is an entity
@Getter//sets getters for fields
@Setter
@Builder//sets builder pattern

@NoArgsConstructor//sets no args constructor
@AllArgsConstructor//sets all args constructor

@Table(name = "exercises")

public class exercise {
    
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    
   

}
