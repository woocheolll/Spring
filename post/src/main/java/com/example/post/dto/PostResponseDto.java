package com.example.post.dto;
import lombok.Getter;
public class PostResponseDto {
    private String username;
    private String password;
    private String title;
    private String contents;

    public PostResponseDto(String username, String password, String title, String contents) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.contents = contents;
    }
}
