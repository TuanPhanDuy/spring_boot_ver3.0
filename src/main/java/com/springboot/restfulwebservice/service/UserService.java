package com.springboot.restfulwebservice.service;

import com.springboot.restfulwebservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> getListUser();

    User addUser(User user);

    User findById(Integer id);
}
