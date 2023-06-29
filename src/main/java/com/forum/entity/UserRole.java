package com.forum.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class UserRole
{

    @EmbeddedId
    UserRoleKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id.equals(userRole.id) && user.equals(userRole.user) && role.equals(userRole.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, role);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }

    @Embeddable
    private class UserRoleKey implements Serializable {

        @Column(name = "user_id")
        Long UserId;

        @Column(name = "role_id")
        Long RoleId;

        public UserRoleKey() {
        }

        public Long getUserId() {
            return UserId;
        }

        public void setUserId(Long userId) {
            UserId = userId;
        }

        public Long getRoleId() {
            return RoleId;
        }

        public void setRoleId(Long roleId) {
            RoleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserRoleKey that = (UserRoleKey) o;
            return UserId.equals(that.UserId) && RoleId.equals(that.RoleId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(UserId, RoleId);
        }
    }

}

