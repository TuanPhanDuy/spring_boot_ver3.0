package com.springboot.restfulwebservice.service.impl;

import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.exception.UserNotFoundException;
import com.springboot.restfulwebservice.repository.UserRepository;
import com.springboot.restfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
