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

import java.lang.reflect.Array;
import java.util.Arrays;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private TaskRepository  taskRepository;

    public DbInit(UserRepository userRepository, ProjectRepository projectRepository,
                  RoleRepository roleRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.taskRepository = taskRepository;
    }

    public void addData(){
        User user1 = new User("vt","Vlad", "Tumi", "vt@mail.pl", "aghagh");
        userRepository.save(user1);
        User user2 = new User("at","Andriy", "Tri", "at@mail.pl", "aghagh");
        userRepository.save(user2);
        User user3 = new User("lo","Lena", "Obe", "lo@mail.pl", "aghagh");
        userRepository.save(user3);
        User user4 = new User("ak","Ania", "Klu", "ak@mail.pl", "aghagh");
        userRepository.save(user4);
        User user5 = new User("kh","Kuba", "Mita", "km@mail.pl", "aghagh");
        userRepository.save(user5);

        Project project1 = new Project("Web App", "Project for hackathon", LocalDateTime.of(2020,10,11,11,0));
        projectRepository.save(project1);
        Project project2 = new Project("Game", "Project na studia", LocalDateTime.of(2020,12,5,5,5));
        projectRepository.save(project2);
        Project project3 = new Project("Hacknarock","ZDOBADZ WIECZNA CHWALE", LocalDateTime.of(2020,6,1,12,0));
        projectRepository.save(project3);
        Project project4 = new Project("eBal", "Najbareziej elegancki wieczor karnawalu WIEiT", LocalDateTime.of(2020,11,1,12,0));
        projectRepository.save(project4);

        // Lena + Vlad + Anriy = web app
        user1.getProjects().add(project1);
        project1.getUsers().add(user1);
        user2.getProjects().add(project1);
        project1.getUsers().add(user2);
        user3.getProjects().add(project1);
        project1.getUsers().add(user3);

        // Vlad + Andriy = game
        user1.getProjects().add(project2);
        project2.getUsers().add(user1);
        user2.getProjects().add(project2);
        project2.getUsers().add(user2);

        // Ania + Kuba = Hacknarok
        user5.getProjects().add(project3);
        project3.getUsers().add(user5);
        user4.getProjects().add(project3);
        project3.getUsers().add(user4);

        // Lena + Ania = eBal
        user3.getProjects().add(project4);
        project4.getUsers().add(user3);
        user4.getProjects().add(project4);
        project4.getUsers().add(user4);
        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));


        Task task11 = new Task("Frontend", "", TaskState.IN_PROCESS,
                LocalDateTime.of(2020,8,10,10,10),
                LocalDateTime.of(2020,10,1,23,59), 50);
        task11.setProject(project1);
        taskRepository.save(task11);
        project1.getTasks().add(task11);
        Task task12 = new Task("Backend", "", TaskState.NEED_HELP,
                LocalDateTime.of(2020,8,10,10,10),
                LocalDateTime.of(2020,10,1,23,59), 50);
        task12.setProject(project1);
        taskRepository.save(task12);
        project1.getTasks().add(task12);
        projectRepository.save(project1);

        Task task21 = new Task("Idea", "", TaskState.IN_PROCESS,
                LocalDateTime.of(2020,8,21,10,10),
                LocalDateTime.of(2020,8,31,23,59), 2);
        task21.setProject(project2);
        taskRepository.save(task21);
        project2.getTasks().add(task21);
        Task task22 = new Task("GoodSide", "", TaskState.TO_DO,
                LocalDateTime.of(2020,10,31,23,59), 10);
        task22.setProject(project2);
        taskRepository.save(task22);
        project2.getTasks().add(task22);
        Task task23 = new Task("BadSide", "", TaskState.TO_DO,
                LocalDateTime.of(2020,10,31,23,59), 10);
        task23.setProject(project2);
        taskRepository.save(task23);
        project2.getTasks().add(task23);
        Task task24 = new Task("Map", "", TaskState.IN_PROCESS,
                LocalDateTime.of(2020,8,29,20,39),
                LocalDateTime.of(2020,10,29,23,59), 10);
        task24.setProject(project2);
        taskRepository.save(task24);
        project2.getTasks().add(task24);
        Task task25 = new Task("DreamTeam", "", TaskState.DONE,
                LocalDateTime.of(2020,8,20,20,39),
                LocalDateTime.of(2020,8,29,10,39),
                LocalDateTime.of(2020,9,29,23,59), 50);
        task25.setProject(project2);
        taskRepository.save(task25);
        project2.getTasks().add(task25);
        projectRepository.save(project2);

        Task task31 = new Task("Idea", "", TaskState.IN_PROCESS,
                LocalDateTime.of(2019,10,21,10,10),
                LocalDateTime.of(2019,11,1,23,59), 2);
        task31.setProject(project3);
        taskRepository.save(task31);
        project3.getTasks().add(task31);
        Task task32 = new Task("Sponsoring", "", TaskState.DONE,
                LocalDateTime.of(2019,1,1,23,59),
                LocalDateTime.of(2019,1,27,23,59),
                LocalDateTime.of(2020,2,1,23,59), 100);
        task32.setProject(project3);
        taskRepository.save(task32);
        project3.getTasks().add(task32);
        Task task33 = new Task("Promocja", "", TaskState.TO_DO,
                LocalDateTime.of(2020,4,30,23,59), 10);
        task33.setProject(project3);
        taskRepository.save(task33);
        project3.getTasks().add(task23);
        Task task34 = new Task("Zapisy", "", TaskState.IN_PROCESS,
                LocalDateTime.of(2020,5,29,20,39), 3);
        task34.setProject(project3);
        taskRepository.save(task34);
        projectRepository.save(project3);

        Task task41 = new Task("Temat balu", "", TaskState.DONE,
                LocalDateTime.of(2020,1,1,10,10),
                LocalDateTime.of(2020,2,1,10,10),
                LocalDateTime.of(2020,2,1,23,59), 300);
        task41.setProject(project4);
        taskRepository.save(task41);
        project4.getTasks().add(task41);
        Task task42 = new Task("Dofinansowanie", "", TaskState.DONE,
                LocalDateTime.of(2020,3,1,23,59),
                LocalDateTime.of(2019,4,27,23,59),
                LocalDateTime.of(2020,4,1,23,59), 100);
        task42.setProject(project4);
        taskRepository.save(task42);
        project4.getTasks().add(task42);
        Task task43 = new Task("Wydarzenie", "", TaskState.TO_DO,
                LocalDateTime.of(2020,9,29,23,59), 10);
        task43.setProject(project4);
        taskRepository.save(task43);
        project4.getTasks().add(task43);
        Task task44 = new Task("Wplaty", "", TaskState.NEED_HELP,
                LocalDateTime.of(2020,10,29,20,39), 3);
        task44.setProject(project4);
        taskRepository.save(task44);
        projectRepository.save(project4);

        Role roleUser = new Role(ERole.ROLE_USER);
        roleUser.setUsers(Set.of(user1, user2,user3,user4));
        roleRepository.save(roleUser);

    /*    user1.setRoles(Set.of(roleUser));
        user2.setRoles(Set.of(roleUser));
        user3.setRoles(Set.of(roleUser));
        user4.setRoles(Set.of(roleUser));
        */

    }

    @Override
    public void run(String... args) throws Exception {
        addData();
    }
}
