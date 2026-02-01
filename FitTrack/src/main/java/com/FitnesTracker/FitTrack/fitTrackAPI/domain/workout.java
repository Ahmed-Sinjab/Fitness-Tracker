package com.FitnesTracker.FitTrack.fitTrackAPI.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "workout")
public class workout {
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String workoutid;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private user owner;  // MANY workouts belong to ONE user

}
