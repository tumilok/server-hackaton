package com.hackaton.project;

import com.hackaton.project.models.User;
import com.hackaton.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("slgj", "eorgj@gmail.com", "234234");
        userRepository.save(user);
        //User user = new User("Vasia", "Petrov", "petrov@gmail.com", "12345");
        //userRepository.save(user);
        /*
        Project project = new Project("Some project");

        user.getProjects().add(project);
        userRepository.save(user);
        projectRepository.save(project);
         */
    }
}
