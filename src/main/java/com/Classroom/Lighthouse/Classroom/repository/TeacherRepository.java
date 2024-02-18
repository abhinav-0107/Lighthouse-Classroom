package com.Classroom.Lighthouse.Classroom.repository;

import com.Classroom.Lighthouse.Classroom.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
