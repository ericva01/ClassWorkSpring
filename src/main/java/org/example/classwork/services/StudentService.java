package org.example.classwork.services;

import lombok.AllArgsConstructor;
import org.example.classwork.InMemoryDatabase;
import org.example.classwork.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private final List<Students> students;

    public List<Students> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Students> getStudentById(int id) {
        return students.stream().filter(students -> students.getId() == id).findFirst();
    }

    public void addStudent(Students newStudent) {
        if (getStudentById(newStudent.getId()).isPresent()) {
            throw new IllegalArgumentException("Student with ID " + newStudent.getId() + " already exists.");
        }
        students.add(newStudent);
    }

    public boolean updateStudent(int id, Students updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, updatedStudent);
                System.out.println("✅ Student updated: " + updatedStudent);
                return true;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
        return false;
    }
    public Boolean deleteStudent(Integer id) {
        return students.removeIf(student -> student.getId()== id);
    }
}
