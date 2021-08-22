/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.controller;

import com.meteergin.springbootjpastreamer.entity.User;
import com.meteergin.springbootjpastreamer.exception.UserNotFoundException;
import com.meteergin.springbootjpastreamer.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mergin
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    private static final String JPA_REPOSITORY = "/jpa-repository";
    private static final String JPA_STREAMER = "/jpa-streamer";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(JPA_REPOSITORY + "/all")
    public ResponseEntity<List<User>> jpaRepositoryFindAll() {
        return new ResponseEntity<>(userService.jpaRepositoryFindAll(), HttpStatus.OK);
    }

    @GetMapping(JPA_STREAMER + "/all")
    public ResponseEntity<List<User>> jpaStreamerFindAll() {
        return new ResponseEntity(userService.jpaStreamerFindAll(), HttpStatus.OK);
    }

    @GetMapping(JPA_REPOSITORY + "/{id}")
    public ResponseEntity<User> jpaRepositoryFindById(@PathVariable Long id) {
        User user = userService.jpaRepositoryFindById(id);
        if (null != user) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @GetMapping(JPA_STREAMER + "/{id}")
    public ResponseEntity<User> jpaStreamerFindById(@PathVariable Long id) {
        User user = userService.jpaStreamerFindById(id);
        if (null != user) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @GetMapping(JPA_REPOSITORY + "/findByFirstCharacterOfFirstName/{character}")
    public ResponseEntity<List<User>> jpaSRepositoryFindByFirstCharacterOfFirstName(@PathVariable String character) {
        List<User> userList = userService.jpaRepositoryFindByFirstCharacterOfFirstName(character);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_STREAMER + "/findByFirstCharacterOfFirstName/{character}")
    public ResponseEntity<List<User>> jpaStreamerFindByFirstCharacterOfFirstName(@PathVariable String character) {
        List<User> userList = userService.jpaStreamerFindByFirstCharacterOfFirstName(character);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_REPOSITORY + "/findByAge/{age}")
    public ResponseEntity<List<User>> jpaRepositoryFindByAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaRepositoryFindByAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_STREAMER + "/findByAge/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_REPOSITORY + "/findByLessThanAge/{age}")
    public ResponseEntity<List<User>> jpaRepositoryFindByLessThanAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaRepositoryFindByLessThanAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_STREAMER + "/findByLessThanAge/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByLessThanAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByLessThanAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_REPOSITORY + "/findByFirstCharacterOfFirstNameAndAge/{character}/{age}")
    public ResponseEntity<List<User>> jpaRepositoryFindByFirstCharacterOfFirstNameAndAge(@PathVariable String character, @PathVariable Integer age) {
        List<User> userList = userService.jpaRepositoryFindByFirstCharacterOfFirstNameAndAge(character, age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(JPA_STREAMER + "/findByFirstCharacterOfFirstNameAndAge/{character}/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByFirstCharacterOfFirstNameAndAge(@PathVariable String character, @PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByFirstCharacterOfFirstNameAndAge(character, age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

}
