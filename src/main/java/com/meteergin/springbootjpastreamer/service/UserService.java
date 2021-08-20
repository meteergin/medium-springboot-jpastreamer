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

    public Optional<User> jpaRepositoryFindById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> jpaStreamerFindAll() {
        return jpaStreamer.stream(User.class)
                .sorted(User$.id.reversed())
                .collect(Collectors.toList());
    }

}
