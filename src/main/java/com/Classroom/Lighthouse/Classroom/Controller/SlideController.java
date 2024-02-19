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


    /**
        Endpoint to retrieve a specific slide by its ID.
        return ResponseEntity containing the requested Slide or a 404 Not Found status
    */
    @GetMapping("/{id}")
    public ResponseEntity<Slide> getSlide(@PathVariable Long id) {
        Optional<Slide> slideOptional = slideRepository.findById(id);
        if (slideOptional.isPresent()) {
            return ResponseEntity.ok(slideOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
        Endpoint to create a new slide.
        return ResponseEntity containing the created Slide and a 201 Created status
    */
    @PostMapping
    public ResponseEntity<Slide> createSlide(@Valid @RequestBody Slide slide) {
        Slide savedSlide = slideRepository.save(slide);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSlide);
    }


    /**
        Endpoint to update an existing slide by its ID.
        id- ID of the slide to update
        slideDetails- Updated Slide object
        return ResponseEntity containing the updated Slide or a 404 Not Found status
    */
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


    /**
        Endpoint to delete a specific slide by its ID.
        return ResponseEntity with a 200 OK status if deleted, or a 404 Not Found status
    */
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
