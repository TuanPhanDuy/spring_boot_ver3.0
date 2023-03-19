package com.springboot.restfulwebservice.controller;

import com.springboot.restfulwebservice.constant.UriConstant;
import com.springboot.restfulwebservice.entity.Post;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.service.PostService;
import com.springboot.restfulwebservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(UriConstant.user_uri)
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private PostService postService;

    @GetMapping
    public ResponseEntity<List<User>> getListUser(){
        return ResponseEntity.ok(userService.getListUser());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("{id}/posts")
    public ResponseEntity<Post> retrievePostsForUser(@PathVariable Integer id, @Valid @RequestBody Post post){


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postService.addPostForUser(id, post).getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("files")
    public String uploadFile(@RequestParam("files") MultipartFile files){
        return "Hello World";
    }
}
