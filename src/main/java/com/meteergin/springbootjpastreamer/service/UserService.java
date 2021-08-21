/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.service;

import com.meteergin.springbootjpastreamer.entity.User;
import com.meteergin.springbootjpastreamer.entity.User$;
import com.meteergin.springbootjpastreamer.repository.UserRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mergin
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JPAStreamer jpaStreamer;

    @Autowired
    public UserService(UserRepository userRepository, JPAStreamer jpaStreamer) {
        this.userRepository = userRepository;
        this.jpaStreamer = jpaStreamer;
    }

    public List<User> jpaRepositorySaveAll(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    public List<User> jpaRepositoryFindAll() {
        return userRepository.findAll();
    }

    public List<User> jpaStreamerFindAll() {
        return jpaStreamer.stream(User.class).
                sorted(User$.id).
                collect(Collectors.toList());
    }

    public User jpaRepositoryFindById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public User jpaStreamerFindById(Long id) {
        return jpaStreamer.stream(User.class).
                filter(User$.id.equal(id)).
                findFirst().map(u -> u).
                orElse(null);
    }

    public List<User> jpaRepositoryFindByAge(Integer age) {
        return userRepository.findByAge(age);
    }

    public List<User> jpaStreamerFindByAge(Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.age.equal(age)).
                collect(Collectors.toList());
    }

    public List<User> jpaRepositoryFindByFirstCharacterOfFirstName(String character) {
        return userRepository.findByFirstNameStartingWith(character);
    }

    public List<User> jpaStreamerFindByFirstCharacterOfFirstName(String character) {
        return jpaStreamer.stream(User.class).
                filter(User$.firstName.startsWith(character)).
                collect(Collectors.toList());
    }

    public List<User> jpaRepositoryFindByLessThanAge(Integer age) {
        return userRepository.findByAgeLessThan(age);
    }

    public List<User> jpaStreamerFindByLessThanAge(Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.age.lessThan(age)).
                collect(Collectors.toList());
    }

    public List<User> jpaRepositoryFindByFirstCharacterOfFirstNameAndAge(String character, Integer age) {
        return userRepository.findByFirstNameStartingWithAndAge(character, age);
    }

    public List<User> jpaStreamerFindByFirstCharacterOfFirstNameAndAge(String character, Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.firstName.startsWith(character).
                        and(User$.age.equal(age))).
                collect(Collectors.toList());
    }

}
