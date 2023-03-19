package com.springboot.restfulwebservice.service;

import com.springboot.restfulwebservice.entity.Post;

public interface PostService {

    Post addPostForUser(Integer userId, Post post);
}
