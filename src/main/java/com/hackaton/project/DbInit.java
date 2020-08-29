package com.hackaton.project;

import com.hackaton.project.models.Project;
import com.hackaton.project.models.User;
import com.hackaton.project.repository.ProjectRepository;
import com.hackaton.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;

    public DbInit(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("alrkg", "sdgj", "eorgj@gmail.com", "234234");
        userRepository.save(user);

        Project project = new Project("Some title");
        projectRepository.save(project);

        user.getProjects().add(project);
        project.getUsers().add(user);

        userRepository.save(user);
        projectRepository.save(project);
    }
}
