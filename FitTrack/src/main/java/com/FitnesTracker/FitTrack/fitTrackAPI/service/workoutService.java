package com.FitnesTracker.FitTrack.fitTrackAPI.service;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;
import com.FitnesTracker.FitTrack.fitTrackAPI.domain.user;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FitnesTracker.FitTrack.fitTrackAPI.repo.workoutRepo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor

public class workoutService {
    private final workoutRepo workoutrepos;


    public Page<workout> getAllWorkouts(int page, int size){
        return workoutrepos.findAll(PageRequest.of(page,size, Sort.by("name")));

    }
    public workout getWorkout(String id){
        return workoutrepos.findById(id).orElseThrow(() -> new RuntimeException("Workout Not Found"));
    }
    public workout createWorkout (workout workout){
        return workoutrepos.save(workout);
    }
    public void deleteWorkout(workout workout){
        log.info("Deleting Workout: " + workout.getWorkoutid());
        workoutrepos.delete(workout);
    }
   

    public workout updateWorkout(workout workout){
        return workoutrepos.save(workout);
    }
    


}
