/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.config;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.meteergin.springbootjpastreamer.entity.User;
import com.meteergin.springbootjpastreamer.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserService userService) {
        return args -> {
            List<User> userList = generateRandomUsers(100);
            userService.jpaRepositorySaveAll(userList);
        };
    }

    private List<User> generateRandomUsers(int numberOfUsers) {
        List<User> userList = new ArrayList();
        Faker faker = null;
        Name name = null;

        for (int i = 0; i < numberOfUsers; i++) {
            faker = Faker.instance();
            name = faker.name();

            User user = User.builder().
                    firstName(name.firstName()).
                    lastName(name.lastName()).
                    age(RandomUtils.nextInt(0, 100)).
                    build();

            userList.add(user);
        }

        return userList;
    }
}
