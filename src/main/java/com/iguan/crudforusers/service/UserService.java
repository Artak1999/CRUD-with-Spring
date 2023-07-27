package com.iguan.crudforusers.service;

import com.iguan.crudforusers.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUserById(int id, User user);
    User updateUserEmailById(int id, User user);
    User updateUsersPhoneNumberById(int id, User user);
    void deleteUserById(int id) ;
}
