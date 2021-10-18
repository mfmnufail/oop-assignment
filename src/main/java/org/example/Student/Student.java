package org.example.Student;

public class Student {

    // Student contains student id, name, date of birth, join date

    private final String id;
    private final String name;
    private final String  dateOfBirth;
    private final String joinDate;

    public Student(String id, String name, String dateOfBirth, String joinDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
