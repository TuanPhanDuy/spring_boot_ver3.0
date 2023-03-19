package com.springboot.restfulwebservice.controller;

import com.springboot.restfulwebservice.constant.UriConstant;
import com.springboot.restfulwebservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UriConstant.post_uri)
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("posts")
    public ResponseEntity addPostForUser(){
        return null;
    }
}
