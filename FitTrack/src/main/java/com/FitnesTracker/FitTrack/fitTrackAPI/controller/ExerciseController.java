package com.FitnesTracker.FitTrack.fitTrackAPI.controller;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.Exercise;
import com.FitnesTracker.FitTrack.fitTrackAPI.service.ExerciseService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<Page<Exercise>> getAllExercises(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(exerciseService.getAllExercises(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable String id) {
        return ResponseEntity.ok(exerciseService.getExercise(id));
    }

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.createExercise(exercise));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(
        @PathVariable String id,
        @RequestBody Exercise exercise
    ) {
        exercise.setId(id);
        return ResponseEntity.ok(exerciseService.updateExercise(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}