package com.Classroom.Lighthouse.Classroom.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
@Entity
@Table
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Slide> slides;

    @ManyToMany
    private List<Teacher> teachers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
