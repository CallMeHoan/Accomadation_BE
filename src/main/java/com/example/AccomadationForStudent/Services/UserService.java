package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<ResponseObject> findAllUser() {
        List<User> allUser = userRepository.findAll();
        if (allUser.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get all user successfully", allUser)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found any user", "")
            );
        }
    }

    public ResponseEntity<ResponseObject> findUserById(Long id){
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

    public ResponseEntity<ResponseObject> addNewUser(User newUser){
        Optional<User> UserByMail = userRepository.findByMail(newUser.getMail());
        if (UserByMail.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("409", "Email already exists", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Add User successfully", userRepository.save(newUser))
            );
        }
    }

    public ResponseEntity<ResponseObject> updateUser(User newUser, Long id){
        Optional<User> UserByMail = userRepository.findByMail(newUser.getMail());
        if (UserByMail.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("409", "Email already exists", "")
            );
        } else {
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
    }

    public ResponseEntity<ResponseObject> deleteUser(Long id){
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
