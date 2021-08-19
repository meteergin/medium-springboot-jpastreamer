package com.meteergin.springbootjpastreamer;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.meteergin.springbootjpastreamer.entity.User;
import com.meteergin.springbootjpastreamer.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpastreamerApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJpastreamerApplication.class);

    private UserService userService;

    public SpringbootJpastreamerApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpastreamerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = generateRandomUsers();
        userService.saveAll(userList);
    }

    private List<User> generateRandomUsers() {
        List<User> userList = new ArrayList();

        for (int i = 0; i < 100; i++) {
            Faker faker = new Faker();
            Name name = faker.name();

            User user = User.builder().
                    firstName(name.firstName()).
                    lastName(name.lastName()).
                    build();
            userList.add(user);
        }

        return userList;
    }

}
