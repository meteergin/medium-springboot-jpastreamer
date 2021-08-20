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
import java.util.Map;
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

    public Optional<User> jpaRepositoryFindById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> jpaStreamerFindAll() {
        return jpaStreamer.stream(User.class).
                sorted(User$.id).
                collect(Collectors.toList());
    }

    public List<User> jpaStreamerFindByFirstCharacterOfFirstName(String character) {
        return jpaStreamer.stream(User.class).
                filter(User$.firstName.startsWith(character)).
                collect(Collectors.toList());
    }

    public List<User> jpaStreamerFindByAge(Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.age.equal(age)).
                collect(Collectors.toList());
    }

    public List<User> jpaStreamerFindByLessThanAge(Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.age.lessThan(age)).
                collect(Collectors.toList());
    }

    public List<User> jpaStreamerFindByFirstCharacterOfFirstNameAndAge(String character, Integer age) {
        return jpaStreamer.stream(User.class).
                filter(User$.firstName.startsWith(character).
                        and(User$.age.equal(age))).
                collect(Collectors.toList());
    }

    public Map<Integer, List<User>> jpaStreamerGroupByAge() {
        return jpaStreamer.stream(User.class).
                collect(Collectors.groupingBy(User$.age.asInt()));
    }

}
