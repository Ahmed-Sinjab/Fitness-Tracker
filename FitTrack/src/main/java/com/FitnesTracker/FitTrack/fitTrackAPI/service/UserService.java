package com.FitnesTracker.FitTrack.fitTrackAPI.service;

import com.FitnesTracker.FitTrack.fitTrackAPI.domain.User;
import com.FitnesTracker.FitTrack.fitTrackAPI.repo.UserRepo;

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
public class UserService {

    private final UserRepo userRepo;

    public Page<User> getAllUsers(int page, int size) {
        return userRepo.findAll(PageRequest.of(page, size, Sort.by("firstName")));
    }

    public User getUser(String id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        // Check if email already exists
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setDateOfCreation(new Date());
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        // Make sure user exists before updating
        getUser(user.getId());
        return userRepo.save(user);
    }

    public void deleteUser(String id) {
        log.info("Deleting user: " + id);
        userRepo.deleteById(id);
    }
}