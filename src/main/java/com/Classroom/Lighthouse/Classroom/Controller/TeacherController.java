package com.Classroom.Lighthouse.Classroom.Controller;

import com.Classroom.Lighthouse.Classroom.Entity.Teacher;
import com.Classroom.Lighthouse.Classroom.repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;


    /**
        Endpoint to retrieve a specific teacher by their ID.
        id- ID of the teacher to retrieve
        return ResponseEntity containing the requested Teacher or a 404 Not Found status
    */
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return ResponseEntity.ok(teacherOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
        Endpoint to create a new teacher.
       teacher- Teacher object to be created
        return ResponseEntity containing the created Teacher and a 201 Created status
    */
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher);
    }


    /**
        Endpoint to update an existing teacher by their ID.
        id- ID of the teacher to update
         teacherDetails- Updated Teacher object
        return ResponseEntity containing the updated Teacher or a 404 Not Found status
    */
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher teacherDetails) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            teacher.setName(teacherDetails.getName()); // Update other fields as needed
            teacher.setSalary(teacherDetails.getSalary());
            Teacher updatedTeacher = teacherRepository.save(teacher);
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
        Endpoint to delete a specific teacher by their ID.
        id- ID of the teacher to delete
        return ResponseEntity with a 200 OK status if deleted, or a 404 Not Found status
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            teacherRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

