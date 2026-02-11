package com.FitnesTracker.FitTrack.fitTrackAPI.service;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.Exercise;
import com.FitnesTracker.FitTrack.fitTrackAPI.repo.exerciseRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ExerciseService {
    
    private final exerciseRepo ExerciseRepo;

    public Page<Exercise> getAllExercises(int page, int size) {
        return ExerciseRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Exercise getExercise(String id) {
        return ExerciseRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));
    }

    public Exercise createExercise(Exercise exercise) {
        exercise.setCreatedAt(new Date());
        return ExerciseRepo.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        // Make sure exercise exists before updating
        getExercise(exercise.getId());
        exercise.setUpdatedAt(new Date());
        return ExerciseRepo.save(exercise);
    }

    public void deleteExercise(String id) {
        log.info("Deleting exercise: " + id);
        ExerciseRepo.deleteById(id);
    }
}