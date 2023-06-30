package com.forum.dao;

import com.forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}
