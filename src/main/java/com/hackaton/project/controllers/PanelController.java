package com.hackaton.project.controllers;

import java.util.List;
import com.hackaton.project.models.Project;
import com.hackaton.project.models.Task;
import com.hackaton.project.repository.ProjectRepository;
import com.hackaton.project.repository.TaskRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/panel")
public class PanelController {
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    PanelController(TaskRepository taskRepository, ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("tasks/{projectId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List projectTasks(@PathVariable Long projectId){
        Optional<Project> project=projectRepository.findById(projectId);
        if(project.isPresent()) {
            return taskRepository.findByProject(project.get());
        }
        else {
            return null;
        }
    }


}
