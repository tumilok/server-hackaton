package com.hackaton.project.payload.request;

import com.hackaton.project.payload.response.TasksResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class AddProjectRequest {
    @NotBlank
    @Size(max = 120)
    private String title;

    @Size(max = 1000)
    private String description;

    private String deadline;
    private Set<String> users;
    private Set<TaskRequest> tasksRequests;

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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public Set<TaskRequest> getTasksRequests() {
        return tasksRequests;
    }

    public void setTasksRequests(Set<TaskRequest> tasksRequests) {
        this.tasksRequests = tasksRequests;
    }

    /*

    public List<String> getTasksNames() {
        return tasksNames;
    }

    public void setTasksNames(List<String> tasksNames) {
        this.tasksNames = tasksNames;
    }

    public List<String> getTasksDescriptions() {
        return tasksDescriptions;
    }

    public void setTasksDescriptions(List<String> tasksDescriptions) {
        this.tasksDescriptions = tasksDescriptions;
    }

    public List<String> getTasksDeadlines() {
        return tasksDeadlines;
    }

    public void setTasksDeadlines(List<String> tasksDeadlines) {
        this.tasksDeadlines = tasksDeadlines;
    }

    public List<String> getTasksTimeLimits() {
        return tasksTimeLimits;
    }

    public void setTasksTimeLimits(List<String> tasksTimeLimits) {
        this.tasksTimeLimits = tasksTimeLimits;
    }

     */
}
