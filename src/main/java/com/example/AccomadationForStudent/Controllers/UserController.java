package com.example.AccomadationForStudent.Controllers;

import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import com.example.AccomadationForStudent.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    //Get all Users
    ResponseEntity<ResponseObject> findAllUser(){
        return userService.findAllUser();
    }
    // Get user by ID
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    // Add new user
    @PostMapping("/new-user")
    ResponseEntity<ResponseObject> addNewUser(@RequestBody User newUser){
        return userService.addNewUser(newUser);
    }

    // Update user
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(newUser, id);
    }
    // Delete user
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
