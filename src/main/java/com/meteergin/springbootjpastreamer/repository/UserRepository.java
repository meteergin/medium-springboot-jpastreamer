/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.repository;

import com.meteergin.springbootjpastreamer.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mergin
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByOrderByIdAsc();

    public List<User> findByAge(Integer age);

    public List<User> findByFirstNameStartingWith(String character);

    public List<User> findByAgeLessThan(Integer age);

    public List<User> findByFirstNameStartingWithAndAge(String character, Integer age);

    public List<User> findByAgeBetween(Integer age1, Integer age2);

    public User findFirstByOrderByAgeDesc();

}
