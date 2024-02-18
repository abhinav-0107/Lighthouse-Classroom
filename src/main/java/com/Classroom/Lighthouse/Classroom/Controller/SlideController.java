package com.Classroom.Lighthouse.Classroom.Controller;

import com.Classroom.Lighthouse.Classroom.Entity.Slide;
import com.Classroom.Lighthouse.Classroom.repository.SlideRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/slides")
public class SlideController {
    @Autowired
    private SlideRepository slideRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Slide> getSlide(@PathVariable Long id) {
        Optional<Slide> slideOptional = slideRepository.findById(id);
        if (slideOptional.isPresent()) {
            return ResponseEntity.ok(slideOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Slide> createSlide(@Valid @RequestBody Slide slide) {
        Slide savedSlide = slideRepository.save(slide);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSlide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slide> updateSlide(@PathVariable Long id, @Valid @RequestBody Slide slideDetails) {
        Optional<Slide> slideOptional = slideRepository.findById(id);
        if (slideOptional.isPresent()) {
            Slide slide = slideOptional.get();
            slide.setContent(slideDetails.getContent()); // Update other fields as needed
            Slide updatedSlide = slideRepository.save(slide);
            return ResponseEntity.ok(updatedSlide);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSlide(@PathVariable Long id) {
        Optional<Slide> slideOptional = slideRepository.findById(id);
        if (slideOptional.isPresent()) {
            slideRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

