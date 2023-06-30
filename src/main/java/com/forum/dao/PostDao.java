package com.forum.dao;

import com.forum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Long> {
}
