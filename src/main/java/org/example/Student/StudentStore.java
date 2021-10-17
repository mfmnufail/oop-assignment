package org.example.Student;

public interface StudentStore {

    Student getStudent(String id);

    void addStudent(String id, String name, String dateOfBirth, String joinDate);
}
