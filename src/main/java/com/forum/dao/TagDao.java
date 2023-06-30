package com.forum.dao;

import com.forum.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag, Long> {
}
