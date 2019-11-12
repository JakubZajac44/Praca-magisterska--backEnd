package com.ar.backend.backeend.controller;

import com.ar.backend.backeend.model.security.JwtUser;
import com.ar.backend.backeend.model.user.User;
import com.ar.backend.backeend.model.user.UserRepository;
import com.ar.backend.backeend.security.JwtManager;
import com.ar.backend.backeend.security.JwtManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private JwtManager jwtManagerImpl;

    public AuthController(JwtManagerImpl jwtManagerImpl) {
        this.jwtManagerImpl = jwtManagerImpl;
    }

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody final User user) {
        boolean canAdd = true;
        List<User> userList = userRepository.findAll();
        for (User singleUser : userList) {
            if (singleUser.getName().equals(user.getName())) {
                canAdd = false;
            }
        }
        if (canAdd) {
            userRepository.insert(user);
            String token = jwtManagerImpl.generate(new JwtUser(user.getName(), user.getPassword()));
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody final User user) {

        List<User> userList = userRepository.findAll();
        for (User singleUser : userList) {
            if (singleUser.getName().equals(user.getName()) && singleUser.getPassword().equals(user.getPassword())) {
                String token = jwtManagerImpl.generate(new JwtUser(user.getName(), user.getPassword()));
                return ResponseEntity.ok(token);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not exist");
    }



}
