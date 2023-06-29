package com.forum.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class TimeZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public TimeZone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeZone timeZone = (TimeZone) o;
        return id.equals(timeZone.id) && name.equals(timeZone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
