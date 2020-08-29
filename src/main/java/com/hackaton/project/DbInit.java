package com.hackaton.project;

import com.hackaton.project.models.ERole;
import com.hackaton.project.models.Project;
import com.hackaton.project.models.Role;
import com.hackaton.project.models.User;
import com.hackaton.project.repository.ProjectRepository;
import com.hackaton.project.repository.RoleRepository;
import com.hackaton.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;

    public DbInit(UserRepository userRepository, ProjectRepository projectRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("nickname1", "eorgj@gmail.com", "234234");
        userRepository.save(user);

        Project project = new Project("Some title");
        projectRepository.save(project);

        user.getProjects().add(project);
        project.getUsers().add(user);

        userRepository.save(user);
        projectRepository.save(project);

        Role roleUser = new Role(ERole.ROLE_USER);
        Role roleMod = new Role(ERole.ROLE_MODERATOR);
        roleRepository.saveAll(Arrays.asList(roleMod, roleUser));
    }
}
