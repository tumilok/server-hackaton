package com.hackaton.project.payload.response;

import com.hackaton.project.models.ETask;
import com.hackaton.project.models.Task;

import java.time.LocalDateTime;

public class TasksResponse {
    private Long id;
    private String taskName;
    private String description;
    private ETask state;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime deadline;
    private Integer timeLimit;

    public TasksResponse(Long id, String taskName, String description, ETask state) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.state = state;
    }

    public TasksResponse(Long id, String taskName, String description, ETask state, LocalDateTime startTime, LocalDateTime deadline, Integer timeLimit) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.state = state;
        this.startTime = startTime;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public TasksResponse(Long id, String taskName, String description, ETask state, LocalDateTime deadline, Integer timeLimit) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.state = state;
        this.deadline = deadline;
        this.timeLimit = timeLimit;
    }

    public TasksResponse(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.description = task.getDescription();
        this.state = task.getState();
        this.startTime = task.getStartTime();
        this.endTime = task.getEndTime();
        this.deadline = task.getDeadline();
        this.timeLimit = task.getTimeLimit();
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

    public ETask getState() {
        return state;
    }

    public void setState(ETask state) {
        this.state = state;
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
}
