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

    @GetMapping("/abc")
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long id) {
        System.out.println("Fetching lecture with ID: " + id);
        Optional<Lecture> lecture = lectureService.getLectureById(id);
        return lecture.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@Valid @RequestBody Lecture lecture) {
//        System.out.println(lecture);
        Lecture createdLecture = lectureService.createLecture(lecture);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLecture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable Long id, @Valid @RequestBody Lecture updatedLecture) {
        Lecture updated = lectureService.updateLecture(id, updatedLecture);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }
}
