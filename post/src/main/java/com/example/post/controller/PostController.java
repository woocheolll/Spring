package com.example.springbasiccrudlivelecture230228.controller;


import com.example.post.dto.PostRequestDto;
import com.example.post.dto.PostResponseDto;
import com.example.post.entity.Post;
import com.example.post.serviec.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 강의 생성 요청
    @PostMapping("/create")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }
}

