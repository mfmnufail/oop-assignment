package org.example.ClassDetails;

import java.util.List;
import java.util.Set;

public interface ClassDetailsStore {

    ClassDetails getClassDetails(int grade, String className);

    void  addClassDetails(int grade, int year, String className, String teacherName);

    void addStudents(int grade, String className,String id);

    void reserveSession(int grade, String className, Session session);

    void markAttendance(int grade, String className, String session, List<String> attendedStudent);

    public Set<String> getSessionName(int grade, String className);

}
