/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.controller;

import com.meteergin.springbootjpastreamer.entity.User;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author mergin
 */
public interface IUserController {

    public ResponseEntity<List<User>> findAll();

    public ResponseEntity<User> findById(Long id);

    public ResponseEntity<List<User>> findByFirstCharacterOfFirstName(String character);

    public ResponseEntity<List<User>> findByAge(Integer age);

    public ResponseEntity<List<User>> findByLessThanAge(Integer age);

    public ResponseEntity<List<User>> findByFirstCharacterOfFirstNameAndAge(String character, Integer age);

}
