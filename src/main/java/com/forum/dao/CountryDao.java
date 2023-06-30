package com.forum.dao;

import com.forum.entity.Country;
import com.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}
