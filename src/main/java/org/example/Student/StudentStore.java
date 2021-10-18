package org.example.Student;

import java.util.List;

public interface StudentStore {

    Student getStudent(String id);

    void addStudent(String id, String name, String dateOfBirth, String joinDate);

    public List<Student> getAllStudents();
}
