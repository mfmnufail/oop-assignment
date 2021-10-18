package org.example.ClassDetails;


import org.example.Student.Student;

import java.util.*;

public class ClassDetails {

    private int year;
    private final String className;
    private String teacherName;
    private final List<Student> students;

    



    public ClassDetails(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTeacherName(String name){
        this.teacherName = name;
    }



    public int getYear() {
        return year;
    }

     public String getClassName() {
        return className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public List<Student> getStudents() {
        return students;
    }




   }
 