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
import java.util.Map;
import java.util.Optional;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/jpa-repository/all")
    public ResponseEntity<List<User>> jpaRepositoryFindAll() {
        return new ResponseEntity<>(userService.jpaRepositoryFindAll(), HttpStatus.OK);
    }

    @GetMapping("/jpa-repository/{id}")
    public ResponseEntity<User> jpaRepositoryFindById(@PathVariable Long id) {
        Optional<User> user = userService.jpaRepositoryFindById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @GetMapping("/jpa-streamer/all")
    public ResponseEntity<List<User>> jpaStreamerFindAll() {
        return new ResponseEntity(userService.jpaStreamerFindAll(), HttpStatus.OK);
    }

    @GetMapping("/jpa-streamer/findByFirstCharacterOfFirstName/{character}")
    public ResponseEntity<List<User>> jpaStreamerFindByFirstCharacterOfFirstName(@PathVariable String character) {
        return new ResponseEntity(userService.jpaStreamerFindByFirstCharacterOfFirstName(character), HttpStatus.OK);
    }

    @GetMapping("/jpa-streamer/findByAge/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByAge(@PathVariable Integer age) {
        return new ResponseEntity(userService.jpaStreamerFindByAge(age), HttpStatus.OK);
    }

    @GetMapping("/jpa-streamer/findByLessThanAge/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByLessThanAge(@PathVariable Integer age) {
        return new ResponseEntity(userService.jpaStreamerFindByLessThanAge(age), HttpStatus.OK);
    }

    @GetMapping("/jpa-streamer/jpaStreamerFindByFirstCharacterOfFirstNameAndAge/{character}/{age}")
    public ResponseEntity<List<User>> jpaStreamerFindByFirstCharacterOfFirstNameAndAge(@PathVariable String character, @PathVariable Integer age) {
        return new ResponseEntity(userService.jpaStreamerFindByFirstCharacterOfFirstNameAndAge(character, age), HttpStatus.OK);
    }

    @GetMapping("/jpa-streamer/jpaStreamerGroupByAge")
    public ResponseEntity<Map<Integer, List<User>>> jpaStreamerGroupByAge() {
        return new ResponseEntity(userService.jpaStreamerGroupByAge(), HttpStatus.OK);
    }

}
