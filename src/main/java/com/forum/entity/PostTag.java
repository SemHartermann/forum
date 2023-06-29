package com.forum.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class PostTag {

    @EmbeddedId
    PostTagKey id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public PostTag() {
    }

    public PostTagKey getId() {
        return id;
    }

    public void setId(PostTagKey id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag postTag = (PostTag) o;
        return id.equals(postTag.id) && post.equals(postTag.post) && tag.equals(postTag.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post, tag);
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "id=" + id +
                ", post=" + post +
                ", tag=" + tag +
                '}';
    }

    @Embeddable
    private class PostTagKey implements Serializable {

        @Column(name = "post_id")
        Long PostId;

        @Column(name = "tag_id")
        Long TagId;

        public PostTagKey() {
        }

        public Long getPostId() {
            return PostId;
        }

        public void setPostId(Long postId) {
            PostId = postId;
        }

        public Long getTagId() {
            return TagId;
        }

        public void setTagId(Long tagId) {
            TagId = tagId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PostTagKey that = (PostTagKey) o;
            return PostId.equals(that.PostId) && TagId.equals(that.TagId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(PostId, TagId);
        }
    }

}

