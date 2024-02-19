package com.Classroom.Lighthouse.Classroom;

import com.Classroom.Lighthouse.Classroom.Entity.Lecture;
import com.Classroom.Lighthouse.Classroom.Service.LectureService;
import com.Classroom.Lighthouse.Classroom.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LectureServiceTest {

    @Mock
    private LectureRepository lectureRepository;

    @InjectMocks
    private LectureService lectureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllLectures() {
        // Arrange
        when(lectureRepository.findAll()).thenReturn(List.of(new Lecture(), new Lecture()));

        // Act
        List<Lecture> result = lectureService.getAllLectures();

        // Assert, if expected result matches true result then test case passes
        assertEquals(2, result.size());
    }

    @Test
    void getLectureById() {
        // Arrange
        Long lectureId = 1L;
        when(lectureRepository.findById(lectureId)).thenReturn(Optional.of(new Lecture()));

        // Act
        Optional<Lecture> result = lectureService.getLectureById(lectureId);

        // Assert, if expected result matches true result then test case passes
        assertTrue(result.isPresent());
    }

    @Test
    void createLecture() {
        // Arrange
        Lecture lectureToCreate = new Lecture();
        when(lectureRepository.save(lectureToCreate)).thenReturn(lectureToCreate);

        // Act
        Lecture result = lectureService.createLecture(lectureToCreate);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
    }

    @Test
    void updateLecture() {
        // Arrange
        Long lectureId = 1L;
        Lecture existingLecture = new Lecture();
        when(lectureRepository.findById(lectureId)).thenReturn(Optional.of(existingLecture));
        when(lectureRepository.save(existingLecture)).thenReturn(existingLecture);

        // Act
        Lecture result = lectureService.updateLecture(lectureId, existingLecture);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
    }

    @Test
    void updateLecture_EntityNotFoundException() {
        // Arrange
        Long nonExistingLectureId = 99L;
        when(lectureRepository.findById(nonExistingLectureId)).thenReturn(Optional.empty());

        // Act and Assert, if expected result matches true result then test case passes
        assertThrows(EntityNotFoundException.class, () -> {
            lectureService.updateLecture(nonExistingLectureId, new Lecture());
        });
    }

    @Test
    void deleteLecture() {
        // Arrange
        Long lectureId = 1L;

        // Act
        lectureService.deleteLecture(lectureId);

        // Assert, if expected result matches true result then test case passes
        verify(lectureRepository, times(1)).deleteById(lectureId);
    }
}
