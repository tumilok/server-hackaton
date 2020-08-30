package com.hackaton.project.payload.response;

import com.hackaton.project.models.Project;
import com.hackaton.project.models.Task;
import com.hackaton.project.models.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AddProjectResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private Set<Long> users;
    private Set<Long> tasks;

    public AddProjectResponse(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.deadline = project.getDeadline();
        this.createDateTime = project.getCreateDateTime();
        this.updateDateTime = project.getUpdateDateTime();
        this.users = getUsersId(project.getUsers());
        this.tasks = getTasksId(project.getTasks());
    }

    Set<Long> getTasksId(Set<Task> tasks) {
        Set<Long> tasksId = new HashSet<>();
        tasks.forEach(t -> tasksId.add(t.getId()));
        return tasksId;
    }

    Set<Long> getUsersId(Set<User> users) {
        Set<Long> usersId = new HashSet<>();
        users.forEach(u -> usersId.add(u.getId()));
        return usersId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Set<Long> getUsers() {
        return users;
    }

    public void setUsers(Set<Long> users) {
        this.users = users;
    }

    public Set<Long> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Long> tasks) {
        this.tasks = tasks;
    }
}
