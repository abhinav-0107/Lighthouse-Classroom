package com.Classroom.Lighthouse.Classroom.Service;

import com.Classroom.Lighthouse.Classroom.Entity.Slide;
import com.Classroom.Lighthouse.Classroom.repository.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SlideService {

    @Autowired
    private SlideRepository slideRepository;

    /**
        Get a slide by its ID.
        id- The ID of the slide to retrieve
        return The found slide, or null if not found
     */
    public Slide getSlideById(Long id) {
        return slideRepository.findById(id).orElse(null);
    }


    /**
        Save a new slide.
        slide- The slide to save
        return The saved slide
     */
    public Slide saveSlide(Slide slide) {
        return slideRepository.save(slide);
    }


    /**
        Update an existing slide.
        id- The ID of the slide to update
        slideDetails- The updated slide information
        return The updated slide, or null if the slide with the given ID is not found
     */
    public Slide updateSlide(Long id, Slide slideDetails) {
        Slide slide = slideRepository.findById(id).orElse(null);
        if (slide != null) {
            slide.setContent(slideDetails.getContent()); // Update other fields as needed
            return slideRepository.save(slide);
        }
        return null;
    }


    /**
        Delete a slide by its ID.
        id -The ID of the slide to delete
     */
    public void deleteSlide(Long id) {
        slideRepository.deleteById(id);
    }
}

