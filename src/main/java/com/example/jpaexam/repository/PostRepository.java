package com.example.jpaexam.repository;

import com.example.jpaexam.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 메서드 이름으로 쿼리 자동 생성
    List<Post> findByAuthor(String author);

    //select * from post where title like '%keyword%'
    List<Post> findByTitleContaining(String keyword);
}