package com.FitnesTracker.FitTrack.fitTrackAPI.controller;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.workout;
import com.FitnesTracker.FitTrack.fitTrackAPI.service.workoutService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    
    private final workoutService workoutservice;

    @GetMapping
    public ResponseEntity<Page<workout>> getAllWorkouts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(workoutservice.getAllWorkouts(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<workout> getWorkout(@PathVariable String id) {
        return ResponseEntity.ok(workoutservice.getWorkout(id));
    }

    @PostMapping
    public ResponseEntity<workout> createWorkout(@RequestBody workout workout) {
        return ResponseEntity.ok(workoutservice.createWorkout(workout));
    }

    @PutMapping("/{id}")
    public ResponseEntity<workout> updateWorkout(
        @PathVariable String id,
        @RequestBody workout workout
    ) {
        workout.setWorkoutid(id);
        return ResponseEntity.ok(workoutservice.updateWorkout(workout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable String id) {
        workout workout = workoutservice.getWorkout(id);
        workoutservice.deleteWorkout(workout);
        return ResponseEntity.noContent().build();
    }
}