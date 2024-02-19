package com.Classroom.Lighthouse.Classroom;

import com.Classroom.Lighthouse.Classroom.Entity.Teacher;
import com.Classroom.Lighthouse.Classroom.Service.TeacherService;
import com.Classroom.Lighthouse.Classroom.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTeacherById() {
        // Arrange
        Long teacherId = 1L;
        Teacher expectedTeacher = new Teacher();
        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(expectedTeacher));

        // Act
        Teacher result = teacherService.getTeacherById(teacherId);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(expectedTeacher, result);
    }

    @Test
    void getTeacherById_NotFound() {
        // Arrange
        Long nonExistingTeacherId = 99L;
        when(teacherRepository.findById(nonExistingTeacherId)).thenReturn(Optional.empty());

        // Act
        Teacher result = teacherService.getTeacherById(nonExistingTeacherId);

        // Assert, if expected result matches true result then test case passes
        assertNull(result);
    }

    @Test
    void saveTeacher() {
        // Arrange
        Teacher teacherToSave = new Teacher();
        when(teacherRepository.save(teacherToSave)).thenReturn(teacherToSave);

        // Act
        Teacher result = teacherService.saveTeacher(teacherToSave);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(teacherToSave, result);
    }

    @Test
    void updateTeacher() {
        // Arrange
        Long teacherId = 1L;
        Teacher existingTeacher = new Teacher();
        Teacher updatedTeacherDetails = new Teacher();
        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(existingTeacher));
        when(teacherRepository.save(existingTeacher)).thenReturn(existingTeacher);

        // Act
        Teacher result = teacherService.updateTeacher(teacherId, updatedTeacherDetails);

        // Assert, if expected result matches true result then test case passes
        assertNotNull(result);
        assertEquals(existingTeacher, result);
    }

    @Test
    void updateTeacher_NotFound() {
        // Arrange
        Long nonExistingTeacherId = 99L;
        when(teacherRepository.findById(nonExistingTeacherId)).thenReturn(Optional.empty());

        // Act
        Teacher result = teacherService.updateTeacher(nonExistingTeacherId, new Teacher());

        // Assert, if expected result matches true result then test case passes
        assertNull(result);
    }

    @Test
    void deleteTeacher() {
        // Arrange
        Long teacherId = 1L;

        // Act
        teacherService.deleteTeacher(teacherId);

        // Assert, if expected result matches true result then test case passes
        verify(teacherRepository, times(1)).deleteById(teacherId);
    }
}
