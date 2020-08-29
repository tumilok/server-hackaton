package com.hackaton.project.controllers;

import com.hackaton.project.models.Project;
import com.hackaton.project.models.User;
import com.hackaton.project.payload.response.UserResponse;
import com.hackaton.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/front")
public class FrontController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<UserResponse> getUsers() {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User u: userRepository.findAll()) {
            List<Long> ids = new ArrayList<>();
            for (Project p: u.getProjects()) {
                ids.add(p.getId());
            }

            userResponses.add(new UserResponse(
                    u.getId(),
                    u.getFirstName(),
                    u.getLastName(),
                    u.getUsername(),
                    u.getEmail(),
                    ids
            ));
        }
        return userResponses;
    }
}
