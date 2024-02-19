package com.Classroom.Lighthouse.Classroom;

import com.Classroom.Lighthouse.Classroom.Entity.Slide;
import com.Classroom.Lighthouse.Classroom.Service.SlideService;
import com.Classroom.Lighthouse.Classroom.repository.SlideRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlideServiceTest {

    @Mock
    private SlideRepository slideRepository;

    @InjectMocks
    private SlideService slideService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSlideById() {
        // Arrange
        Long slideId = 1L;
        Slide expectedSlide = new Slide();
        when(slideRepository.findById(slideId)).thenReturn(Optional.of(expectedSlide));

        // Act
        Slide result = slideService.getSlideById(slideId);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(expectedSlide, result);
    }

    @Test
    void getSlideById_NotFound() {
        // Arrange
        Long nonExistingSlideId = 99L;
        when(slideRepository.findById(nonExistingSlideId)).thenReturn(Optional.empty());

        // Act
        Slide result = slideService.getSlideById(nonExistingSlideId);

        // Assert, if expected result matches true result then test case passes
        assertNull(result);
    }

    @Test
    void saveSlide() {
        // Arrange
        Slide slideToSave = new Slide();
        when(slideRepository.save(slideToSave)).thenReturn(slideToSave);

        // Act
        Slide result = slideService.saveSlide(slideToSave);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(slideToSave, result);
    }

    @Test
    void updateSlide() {
        // Arrange
        Long slideId = 1L;
        Slide existingSlide = new Slide();
        Slide updatedSlideDetails = new Slide();
        when(slideRepository.findById(slideId)).thenReturn(Optional.of(existingSlide));
        when(slideRepository.save(existingSlide)).thenReturn(existingSlide);

        // Act
        Slide result = slideService.updateSlide(slideId, updatedSlideDetails);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(existingSlide, result);
    }

    @Test
    void updateSlide_NotFound() {
        // Arrange
        Long nonExistingSlideId = 99L;
        when(slideRepository.findById(nonExistingSlideId)).thenReturn(Optional.empty());

        // Act
        Slide result = slideService.updateSlide(nonExistingSlideId, new Slide());

        // Assert, if expected result matches true result then test case passes
        assertNull(result);
    }

    @Test
    void deleteSlide() {
        // Arrange
        Long slideId = 1L;

        // Act
        slideService.deleteSlide(slideId);

        // Assert, if expected result matches true result then test case passes
        verify(slideRepository, times(1)).deleteById(slideId);
    }
}
