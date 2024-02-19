package com.Classroom.Lighthouse.Classroom.Service;

import com.Classroom.Lighthouse.Classroom.Entity.Teacher;
import com.Classroom.Lighthouse.Classroom.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    /**
        Get a teacher by their ID.
        id - The ID of the teacher to retrieve
        return The found teacher, or null if not found
     */
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }


    /**
        Save a new teacher.
        teacher- The teacher to save
        return The saved teacher
     */
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    /**
        Update an existing teacher.
        id- The ID of the teacher to update
        teacherDetails- The updated teacher information
        return The updated teacher, or null if the teacher with the given ID is not found
     */
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setName(teacherDetails.getName()); // Update other fields as needed
            teacher.setSalary(teacherDetails.getSalary());
            return teacherRepository.save(teacher);
        }
        return null;
    }


    /**
        Delete a teacher by their ID.
        id- The ID of the teacher to delete
     */
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
