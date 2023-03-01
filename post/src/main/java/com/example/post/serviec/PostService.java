package com.example.post.serviec;

import com.example.post.dto.PostRequestDto;
import com.example.post.dto.PostResponseDto;
import com.example.post.entity.Post;
import com.example.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        return new PostResponseDto(postRepository.save(post));
    }


    public PostResponseDto getPost(Long id) {
        Post post = checkPost(id);

        return new PostResponseDto(post);
    }


    public List<PostResponseDto> getPostList() {
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        List<Post> postList = postRepository.findAll();
        for (Post post : postList) {
            postResponseDtoList.add(new PostResponseDto(post));
        }

        return postResponseDtoList;
    }


    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = checkPost(id);

        post.update(postRequestDto);

        return new PostResponseDto(post);
    }


    @Transactional
    public String deletePost(Long id) {
        Post post = checkPost(id);

        postRepository.delete(post);

        return post.getTitle() + " 강의 삭제 성공";
    }


    private Post checkPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("일치하는 강의 없음")
        );
    }
}


