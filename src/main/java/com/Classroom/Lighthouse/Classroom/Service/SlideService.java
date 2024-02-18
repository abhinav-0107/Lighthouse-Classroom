package com.Classroom.Lighthouse.Classroom.Service;

import com.Classroom.Lighthouse.Classroom.Entity.Slide;
import com.Classroom.Lighthouse.Classroom.repository.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideService {
    @Autowired
    private SlideRepository slideRepository;

    public Slide getSlideById(Long id) {
        return slideRepository.findById(id).orElse(null);
    }

    public Slide saveSlide(Slide slide) {
        return slideRepository.save(slide);
    }

    public Slide updateSlide(Long id, Slide slideDetails) {
        Slide slide = slideRepository.findById(id).orElse(null);
        if (slide != null) {
            slide.setContent(slideDetails.getContent()); // Update other fields as needed
            return slideRepository.save(slide);
        }
        return null;
    }

    public void deleteSlide(Long id) {
        slideRepository.deleteById(id);
    }
}
