package com.example.jpaexam.service;

import com.example.jpaexam.dto.PostDto;
import com.example.jpaexam.entity.Post;
import com.example.jpaexam.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class PostService {

    private final PostRepository postRepository;

    // ✅ CREATE
    public PostDto.Response createPost(PostDto.CreateRequest request){
        Post post = Post.create(request.getTitle(), request.getContent(),
                request.getAuthor());
        Post savedPost = postRepository.save(post);
        return PostDto.Response.from(savedPost);
    }

    // ✅ READ - 단건 조회
    public List<PostDto.Response> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostDto.Response::from)
                .collect(Collectors.toList());
    }

}
