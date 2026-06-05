package com.example.jpaexam.controller;

import com.example.jpaexam.dto.PostDto;
import com.example.jpaexam.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // POST /api/posts - 게시글 생성
    @PostMapping
    public ResponseEntity<PostDto.Response> createPost(@Valid @RequestBody PostDto.CreateRequest request) {
        PostDto.Response response = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}