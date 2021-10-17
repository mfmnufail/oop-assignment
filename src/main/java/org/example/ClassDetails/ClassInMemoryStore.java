package org.example.ClassDetails;

import org.example.Student.StudentStore;

import java.util.*;

public class ClassInMemoryStore implements ClassDetailsStore{


    @Override
    public ClassDetails getClassDetails(int grade, String className) {

        return null;
    }

    @Override
    public void addClassDetails(int grade, int year, String className, String teacherName) {
        
    }

    @Override
    public void addStudents(int grade, String className,String id) {


    }

    @Override
    public void reserveSession(int grade, String className, Session session) {

    }

    public Set<String> getSessionName(int grade, String className){
       

        return null;
    }

    @Override
    public void markAttendance(int grade, String className, String session,List<String> attendedStudents) {
        
    }

   
}
