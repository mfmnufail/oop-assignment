package org.example.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryStore implements StudentStore {

 List<Student> students = new ArrayList<>();

    @Override
    public Student getStudent(String id) {
        if (students.stream().anyMatch(s -> s.getId().equals(id))){
            return  students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        }

        return null;
    }

    @Override
    public void addStudent(String id, String name, String dateOfBirth, String joinDate) {
        students.add(new Student(id,name,dateOfBirth,joinDate));
    }



}
