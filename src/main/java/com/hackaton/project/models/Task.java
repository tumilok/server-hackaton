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

    @NotBlank
    @Size(max = 50)
    private String taskName;

    @Size(max = 500)
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime deadline;
    private Integer timeLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_projects")
    private Project project;

    private ETask state = ETask.TO_DO;

    public Task(){
    }

    public Task(String taskName, String description, LocalDateTime deadline, Integer timeLimit){
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ETask getState() {
        return state;
    }

    public void setState(ETask state) {
        this.state = state;
    }
}
