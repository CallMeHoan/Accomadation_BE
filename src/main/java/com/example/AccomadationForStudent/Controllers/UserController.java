package com.example.AccomadationForStudent.Controllers;

import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
    //Get all Users
    ResponseEntity<ResponseObject> findAllUser(){
            List<User> allUser = userRepository.findAll();
        if(allUser.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get all user successfully", allUser)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found any user", "")
            );
        }
    }
    // Get user by ID
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findUserById(@PathVariable Long id){
        Optional<User> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get User detail successfully", foundUser)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this user by Id: " + id, "")
            );
        }
    }

    // Add new user
    @PostMapping("/new-user")
    ResponseEntity<ResponseObject> addNewUser(@RequestBody User newUser){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Add User successfully", userRepository.save(newUser))
        );
    }

    // Update user
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id){
        Optional<User> updateUser = userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setBirthday(newUser.getBirthday());
                    user.setGender(newUser.getGender());
                    user.setPhone(newUser.getPhone());
                    user.setMail(newUser.getMail());
                    return userRepository.save(user);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Update user successfully", updateUser)
        );
    }
    // Delete user
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id){
        boolean isExists = userRepository.existsById(id);
        if(isExists){
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Delete user successfully", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot find this user to delete", "")
            );
        }
    }


}
