package com.forum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forum.dao.CountryDao;
import com.forum.dao.RoleDao;
import com.forum.dao.TimeZoneDao;
import com.forum.dao.UserDao;
import com.forum.entity.Country;
import com.forum.entity.Role;
import com.forum.entity.TimeZone;
import com.forum.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleDao roleDao, UserDao userDao, CountryDao countryDao, TimeZoneDao timeZoneDao) {
        return runner -> {
            seedingRoles(roleDao);
            seedingUsers(userDao);
            seedingCountries(countryDao);
            seedingTimeZones(timeZoneDao);
        };
    }

    private void seedingRoles(RoleDao roleDao) {

        Role rolePoster = new Role();
        Role roleAdmin = new Role();

        rolePoster.setName("Poster");
        roleAdmin.setName("Admin");

        roleDao.save(rolePoster);
        roleDao.save(roleAdmin);
    }

    private void seedingUsers(UserDao userDao) {
        User user = new User();

        user.setEmail("admin@gmail.com");
        user.setPassword("admin");
        user.setDisplayName("Admin");

        userDao.save(user);
    }

    private void seedingCountries(CountryDao countryDao) {

        List<Country> listCountry;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            listCountry = objectMapper.readValue(new File("src/main/resources/static/files/countries.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        countryDao.saveAll(listCountry);
    }

    private void seedingTimeZones(TimeZoneDao timeZoneDao) {

        Set<TimeZone> listTimeZone;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            listTimeZone = objectMapper.readValue(new File("src/main/resources/static/files/timezones.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<TimeZone> sortedListTimeZone = listTimeZone.stream()
                .map(timeZone -> timeZone.getName())
                .sorted().map(s -> new TimeZone(s))
                .collect(Collectors.toList());

        timeZoneDao.saveAll(sortedListTimeZone);
    }




}