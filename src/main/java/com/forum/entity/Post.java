package com.forum.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "body",nullable = false)
    private String body;

    @Column(name = "deactivated_at")
    private Date deactivatedAt;

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTags;

    public Post() {
    }

    public Post(User author, String title, String body, Date deactivatedAt, List<PostTag> postTags) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.deactivatedAt = deactivatedAt;
        this.postTags = postTags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDeactivatedAt() {
        return deactivatedAt;
    }

    public void setDeactivatedAt(Date deactivatedAt) {
        this.deactivatedAt = deactivatedAt;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id) && author.equals(post.author) && title.equals(post.title) && body.equals(post.body) && Objects.equals(deactivatedAt, post.deactivatedAt) && Objects.equals(postTags, post.postTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, body, deactivatedAt, postTags);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", deactivatedAt=" + deactivatedAt +
                ", postTags=" + postTags +
                '}';
    }
}