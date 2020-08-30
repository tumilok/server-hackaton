package com.hackaton.project.controllers;

import com.hackaton.project.models.Project;
import com.hackaton.project.models.Task;
import com.hackaton.project.models.User;
import com.hackaton.project.repository.ProjectRepository;
import com.hackaton.project.repository.TaskRepository;
import com.hackaton.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/panel")
public class PanelController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/tasks/{projectId}")
    public List<Task> projectTasks(@PathVariable String projectId) {
        Optional<Project> project = projectRepository.findById(Long.parseLong(projectId));
        return project.map(value -> taskRepository.findByProject(value)).orElse(null);
    }

    @GetMapping("/projects/{userId}")
    public List<Project> getUserProjects(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Project> projects = projectRepository.findAll();
            List<Project> returnList = new ArrayList<>();
            for (Project p: projects) {
                if (p.getUsers().contains(user.get())) {
                    returnList.add(p);
                }
            }
            if (returnList.size() > 0) {
                return returnList;
            }
        }
        return null;
    }
}
