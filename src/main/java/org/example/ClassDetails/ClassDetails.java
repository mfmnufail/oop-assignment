package org.example.ClassDetails;


import org.example.Student.Student;

import java.util.*;

public class ClassDetails {

    private int year;
    private final String className;
    private String teacherName;
    private final List<Student> students;

    private final Map<String, String> studentId =new HashMap<>();
    private final Map<String, Session> sessionsAttendance = new HashMap<>();

    



    public ClassDetails(int year, String className, String teacherName,StudentStore studentStore) {
        this.year = year;
        this.className = className;
        this.teacherName = teacherName;
        this.studentStore = studentStore;

    }

    public void addStudent(String id){
        if (studentStore != null){
           Student foundStudent = studentStore.getStudent(id);
           if (foundStudent != null){
               studentId.put(id,"");
           }
        }
    }

    public void addStudent(String id){
        if (studentStore != null){
           Student foundStudent = studentStore.getStudent(id);
           if (foundStudent != null){
               studentId.put(id,"");
           }
        }
    }

    public Map<String, Session> getSessionsAttendance() {
        return sessionsAttendance;
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

    public Map<String,Session> getSessions() {
        return sessionsAttendance;
    }

    public String getClassName() {
        return className;
    }

    public String getTeacherName() {
        return teacherName;
    }


    public void reserveSession(Session session) {
        sessionsAttendance.put(session.getSessionName(),session);
    }

    public void markAttendance(String sessionName,List<String> attendedStudents) {
        for (String id: attendedStudents){
           studentId.put(id,"Attended");
            sessionsAttendance.get(sessionName).markAttendance(attendedStudents);
        }
        sessionsAttendance.get(sessionName).setStudentAttendance(studentId);

    }


    @Override
    public String toString() {
        String s = "\nClass:\n";

        s = s +  year + "-" + className + "\n" ;

        s = s + "\nStudent Details\n";

        if (studentStore != null){
            for (Map.Entry<String,String> stu : studentId.entrySet()) {
                Student foundStudent = studentStore.getStudent(stu.getKey());
                s = s + foundStudent.getId() + " - " + foundStudent.getName() + " - " + stu.getValue()+ "\n";
            }


        for (Map.Entry<String, Session> ses : sessionsAttendance.entrySet()){
            s = s + ses.getKey()  + " Number of attendance " + ses.getValue().getStudentAttendance().size() + "\n";

//            s = s + "\nStudent Details\n";

            for (Map.Entry<String,String> student : ses.getValue().getStudentAttendance().entrySet()){
                s = s + studentStore.getStudent(student.getKey()) + " - " + student.getValue()  + "\n";
            }
        }

        }

        return s;
    }



   }
 