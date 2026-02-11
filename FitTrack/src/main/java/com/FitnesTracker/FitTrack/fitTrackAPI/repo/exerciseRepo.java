package com.FitnesTracker.FitTrack.fitTrackAPI.repo;


import com.FitnesTracker.FitTrack.fitTrackAPI.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;

import java.util.Optional;

@Repository
public interface exerciseRepo extends JpaRepository<Exercise,String> {
    Optional<Exercise> findById(String id);



}
