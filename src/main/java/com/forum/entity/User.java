package com.forum.entity;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "time_zone_id")
    private TimeZone timeZone;

    @Column(name = "about")
    private String about;

    @Column(name = "social_links")
    private String socialLinks;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(String socialLinks) {
        this.socialLinks = socialLinks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email) && password.equals(user.password) && Objects.equals(userRoles, user.userRoles) && Objects.equals(displayName, user.displayName) && Objects.equals(birthDate, user.birthDate) && Objects.equals(photo, user.photo) && Objects.equals(country, user.country) && Objects.equals(timeZone, user.timeZone) && Objects.equals(about, user.about) && Objects.equals(socialLinks, user.socialLinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, userRoles, displayName, birthDate, photo, country, timeZone, about, socialLinks);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles +
                ", displayName='" + displayName + '\'' +
                ", birthDate=" + birthDate +
                ", photo='" + photo + '\'' +
                ", country=" + country +
                ", timeZone=" + timeZone +
                ", about='" + about + '\'' +
                ", socialLinks='" + socialLinks + '\'' +
                '}';
    }
}
