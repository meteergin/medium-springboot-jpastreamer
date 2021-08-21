/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteergin.springbootjpastreamer.exception;

/**
 *
 * @author mergin
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Could not find user.");
    }

    public UserNotFoundException(Long id) {
        super("Could not find user " + id + ".");
    }
}
