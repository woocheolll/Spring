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
    private final PostList postList;

    @Autowired
    public PostController(PostService postService, PostList postList) {
        this.postService = postService;
        this.postList = postList;
    }

    // 강의 생성 요청
    @PostMapping("/create")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    // 특정 강의 정보 요청
    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 강의 목록 조회 요청
    @GetMapping("/list")
    public List<PostResponseDto> getPostList() {
        return postService. getPostList();
    }

    // 특정 강의 정보 수정 요청
    @PutMapping("/update")
    public PostResponseDto updatePost(@RequestParam Long id, @RequestBody PostRequestDto courseRequestDto) {
        return pstService.updatePost(id, postRequestDto);
    }

    // 특정 강의 삭제 요청
    @DeleteMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        return postService.deletePost(id);
    }


    @PostMapping("/db-test")
    public void databaseConnectionExample(@RequestBody Post post) {
        postList.databaseConnectionExample(post);
    }
}