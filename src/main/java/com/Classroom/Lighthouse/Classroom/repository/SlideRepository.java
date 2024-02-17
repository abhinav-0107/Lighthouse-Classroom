package com.Classroom.Lighthouse.Classroom.repository;

import com.Classroom.Lighthouse.Classroom.Entity.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideRepository extends JpaRepository<Slide, Long> {

}