package com.iguan.crudforusers.controller;

import com.iguan.crudforusers.model.User;
import com.iguan.crudforusers.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUserById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("update/email/{id}")
    public ResponseEntity<User> updateUsersEmailById(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUserEmailById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("update/phone-number/{id}")
    public ResponseEntity<User> updateUsersPhoneNumberById(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUsersPhoneNumberById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted!", HttpStatus.NO_CONTENT);
    }
}
