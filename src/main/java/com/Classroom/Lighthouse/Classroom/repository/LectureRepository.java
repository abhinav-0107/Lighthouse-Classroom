package com.Classroom.Lighthouse.Classroom.repository;

import com.Classroom.Lighthouse.Classroom.Entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
