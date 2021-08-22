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
@RequestMapping(path = "/user/jpa-streamer")
public class JpaStreamerUserController implements IUserController {

    private UserService userService;

    private static final String JPA_STREAMER = "/jpa-streamer";

    @Autowired
    public JpaStreamerUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity(userService.jpaStreamerFindAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.jpaStreamerFindById(id);
        if (null != user) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @GetMapping("/findByFirstCharacterOfFirstName/{character}")
    @Override
    public ResponseEntity<List<User>> findByFirstCharacterOfFirstName(@PathVariable String character) {
        List<User> userList = userService.jpaStreamerFindByFirstCharacterOfFirstName(character);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/findByAge/{age}")
    @Override
    public ResponseEntity<List<User>> findByAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/findByLessThanAge/{age}")
    @Override
    public ResponseEntity<List<User>> findByLessThanAge(@PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByLessThanAge(age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/findByFirstCharacterOfFirstNameAndAge/{character}/{age}")
    @Override
    public ResponseEntity<List<User>> findByFirstCharacterOfFirstNameAndAge(@PathVariable String character, @PathVariable Integer age) {
        List<User> userList = userService.jpaStreamerFindByFirstCharacterOfFirstNameAndAge(character, age);
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }
}
