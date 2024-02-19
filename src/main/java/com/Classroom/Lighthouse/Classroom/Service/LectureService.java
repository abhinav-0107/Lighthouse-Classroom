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

    /**
        return The list of all lectures
    */
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }


    /**
        Get a lecture by its ID
         id- The ID of the lecture to retrieve
        return An optional containing the found lecture, or an empty optional if not found.
     */
    public Optional<Lecture> getLectureById(Long id) {
        return lectureRepository.findById(id);
    }


    /**
        Create a new lecture.
        lecture -The lecture to create
        @return The created lecture
     */
    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }


    /**
        Update an existing lecture.
        id- The ID of the lecture to update
        updatedLecture- The updated lecture information
        return The updated lecture
        throws EntityNotFoundException If the lecture with the given ID is not found
     */
    public Lecture updateLecture(Long id, Lecture updatedLecture) {
        Lecture existingLecture = lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found with id: " + id));

        // Update existingLecture fields with values from updatedLecture

        return lectureRepository.save(existingLecture);
    }


    /**
        Delete a lecture by its ID.
        id- The ID of the lecture to delete
     */
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
