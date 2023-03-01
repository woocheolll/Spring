package com.example.post.entity;

import com.example.post.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String title;
    private String contents;


    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();

    }
    public void setId(Long id) {
        this.id = id;
    }

    public void update(PostRequestDto postRequestDto) {
        this.username = postRequestDto.getUsername();
        this.password = postRequestDto.getPassword();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();

    }
    public void setPost(Post post) {
        this.title = post.getTitle();
        this.password = post.getPassword();
        this.title = post.getTitle();
        this.contents = post.getContents()
    }
}