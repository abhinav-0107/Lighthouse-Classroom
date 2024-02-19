package com.Classroom.Lighthouse.Classroom.Controller;

import com.Classroom.Lighthouse.Classroom.Entity.Lecture;
import com.Classroom.Lighthouse.Classroom.Service.LectureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;


    /**
        Endpoint to retrieve all lectures.
        return List of Lecture objects
    */
    @GetMapping()
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }


    /**
        Endpoint to retrieve a specific lecture by its ID.
        return ResponseEntity containing the requested Lecture or a 404 Not Found status
    */
    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long id) {
        Optional<Lecture> lecture = lectureService.getLectureById(id);
        return lecture.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
        Endpoint to create a new lecture.
        return ResponseEntity containing the created Lecture and a 201 Created status
    */
    @PostMapping
    public ResponseEntity<Lecture> createLecture(@Valid @RequestBody Lecture lecture) {
        Lecture createdLecture = lectureService.createLecture(lecture);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLecture);
    }


    /**
        Endpoint to update an existing lecture by its ID.
        return ResponseEntity containing the updated Lecture or a 404 Not Found status
    */
    @PutMapping("/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable Long id, @Valid @RequestBody Lecture updatedLecture) {
        Lecture updated = lectureService.updateLecture(id, updatedLecture);
        return ResponseEntity.ok(updated);
    }


    /**
        Endpoint to delete a specific lecture by its ID.
        return ResponseEntity with a 204 No Content status
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }
}
