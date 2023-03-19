package com.springboot.restfulwebservice.service.impl;

import com.springboot.restfulwebservice.entity.Post;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.exception.UserNotFoundException;
import com.springboot.restfulwebservice.repository.PostRepository;
import com.springboot.restfulwebservice.repository.UserRepository;
import com.springboot.restfulwebservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    @Override
    public Post addPostForUser(Integer userId, Post post) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        post.setUser(user);
        return postRepository.saveAndFlush(post);
    }
}
