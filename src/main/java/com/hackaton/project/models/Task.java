package com.hackaton.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table( name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_projects")
    private Project project;

    @NotBlank
    @Size(max = 50)
    private String taskName;

    @Size(max = 500)
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime deadline;
    private Integer timeLimit;

    private TaskState state;

    public Task(){}

    public Task(String taskName, String description, TaskState state, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime deadline, Integer timeLimit){
        this.taskName=taskName;
        this.description = description;
        this.state=state;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public Task(String taskName, String description, TaskState state, LocalDateTime startTime, LocalDateTime deadline, Integer timeLimit){
        this.taskName=taskName;
        this.description = description;
        this.state=state;
        this.startTime = startTime;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public Task(String taskName, String description, TaskState state, LocalDateTime deadline, Integer timeLimit){
        this.taskName=taskName;
        this.description = description;
        this.state=state;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public TaskState getState() {
        return state;
    }
}
