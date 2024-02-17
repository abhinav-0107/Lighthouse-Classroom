package com.Classroom.Lighthouse.Classroom.Service;

import com.Classroom.Lighthouse.Classroom.Entity.Lecture;
import com.Classroom.Lighthouse.Classroom.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Optional<Lecture> getLectureById(Long id) {
        return lectureRepository.findById(id);
    }

    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public Lecture updateLecture(Long id, Lecture updatedLecture) {
        Lecture existingLecture = lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found with id: " + id));

        // Update existingLecture fields with values from updatedLecture

        return lectureRepository.save(existingLecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
