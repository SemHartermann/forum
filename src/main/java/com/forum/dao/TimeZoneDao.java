package com.forum.dao;

import com.forum.entity.TimeZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeZoneDao extends JpaRepository<TimeZone, Long> {
}
