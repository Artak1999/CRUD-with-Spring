package com.iguan.crudforusers.service.impl;

import com.iguan.crudforusers.model.User;
import com.iguan.crudforusers.repository.UserRepository;
import com.iguan.crudforusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUserById(int id, User user) {
        User existingUser = repository.findById(id).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

    @Override
    public User updateUserEmailById(int id, User user) {
        User existingUser = repository.findById(id).get();
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

    @Override
    public User updateUsersPhoneNumberById(int id, User user) {
        User existingUser = repository.findById(id).get();
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return repository.save(existingUser);
    }

    @Override
    public void deleteUserById(int id) {
        repository.deleteById(id);
    }
}
