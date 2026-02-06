package com.FitnesTracker.FitTrack.fitTrackAPI.repo;


import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;

import java.util.Optional;

@Repository
public interface workoutRepo extends JpaRepository<workout,String> {
    Optional<workout> findById(String id);



}
