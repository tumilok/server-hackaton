package com.hackaton.project;

import com.hackaton.project.models.ERole;
import com.hackaton.project.models.Project;
import com.hackaton.project.models.Role;
import com.hackaton.project.models.Task;
import com.hackaton.project.models.TaskState;
import com.hackaton.project.models.User;
import com.hackaton.project.repository.ProjectRepository;
import com.hackaton.project.repository.RoleRepository;
import com.hackaton.project.repository.TaskRepository;
import com.hackaton.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import java.time.LocalDateTime;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private TaskRepository  taskRepository;

    public DbInit(UserRepository userRepository, ProjectRepository projectRepository, RoleRepository roleRepository) {
    public DbInit(UserRepository userRepository, ProjectRepository projectRepository, TaskRepository taskRepository ) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("nickname1", "eorgj@gmail.com", "234234");
        userRepository.save(user);

        Project project = new Project("Some title");
        projectRepository.save(project);

        Task task = new Task("task1", "our first task", TaskState.IN_PROCESS, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
        task.setProject(project);
        taskRepository.save(task);

        user.getProjects().add(project);
        project.getUsers().add(user);
        project.getTasks().add(task);

        userRepository.save(user);
        projectRepository.save(project);

        Role roleUser = new Role(ERole.ROLE_USER);
        Role roleMod = new Role(ERole.ROLE_MODERATOR);
        roleRepository.saveAll(Arrays.asList(roleMod, roleUser));
        taskRepository.save(task);
    }
}
