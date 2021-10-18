package org.example.ClassDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session {

    // Session class contain feilds of session name, date, start time, end time
    // student attendance details 

    private String sessionName;
    private String date;
    private String startTime;
    private String endTime;
    private Map<String,String> studentAttendance = new HashMap<>();
    private static int N=1;



    public Session(String date, String startTime, String endTime) {
        this.sessionName = "Session " + N++;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setStudentAttendance(Map<String, String> studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public void markAttendance(List<String> attendedStudents) {
        for (String id: attendedStudents){
            studentAttendance.put(id,"Attended");
        }

    }



    public Map<String, String> getStudentAttendance() {
        return studentAttendance;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public int hashCode() {
        return this.date.hashCode() + 37 + this.startTime.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        return this.getClass().equals(obj.getClass());
    }

    @Override
    public String toString() {
        return  date + " :-" + startTime + " - " + endTime + "\n";
    }
    

}
