package org.example;

import org.example.ClassDetails.ClassDetailsStore;
import org.example.ClassDetails.ClassInMemoryStore;
import org.example.ClassDetails.Session;
import org.example.Student.StudentInMemoryStore;
import org.example.Student.StudentStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{

    private  static final Scanner scan = new Scanner(System.in);
    private static final StudentStore studentStore = new StudentInMemoryStore();
//    private static final ClassDetails classDetails = new ClassDetails(studentStore);
    private static final ClassDetailsStore classDetailsStore = new ClassInMemoryStore(studentStore);


    public static void main(String[] args) {

        boolean noQuit = true;
        System.out.println("Welcome to online Class Management System");
        System.out.println("Select one option from the list:");
        while (noQuit){
            System.out.println("1. Quit the system");
            System.out.println("2. Add student details");
            System.out.println("3. Schedule a session");
            System.out.println("4. Mark attendance");
            int option = scan.nextInt();
            scan.nextLine();
            switch (option){
                case 1:
                    noQuit = false;
                    break;
                case 2:
                    addStudentDetails();
                    break;
                case 3:
                    scheduleAEvent();
                    break;
                case 4:
                    markAttendance();
                    break;
            }

        }

    }

    private static void addStudentDetails() {

        System.out.println("1. Number of students:");
        int studentCount = scan.nextInt();
        scan.nextLine();

        while (studentCount>0){
            System.out.println("Enter student Id, Name, Date of Birth, Joined Date:");
            System.out.println("Student Id:");
            String id = scan.nextLine();
            System.out.println("Student Name:");
            String name = scan.nextLine();
            System.out.println("Date of Birth:");
            String dateOfBirth = scan.nextLine();
            System.out.println("Joined Date:");
            String joinedDate = scan.nextLine();
            studentCount--;

            studentStore.addStudent(id,name,dateOfBirth,joinedDate);

        }

    }

    public static void scheduleAEvent(){
//        int grade, int year, String className, String teacherName

            System.out.println("1. Enter grade:");
            int grade = scan.nextInt();
            scan.nextLine();
            System.out.println("2. Enter class name, year and teacher name:");
            System.out.println("Class Name:");
            String className = scan.nextLine();
            System.out.println("Class Year:");
            int year = scan.nextInt();
            scan.nextLine();
            System.out.println("Name of the teacher:");
            String teacherName = scan.nextLine();
            classDetailsStore.addClassDetails(grade,year,className,teacherName);

//            int grade, String className, Session session
            System.out.println("3. Reserve a session by providing below details:");
            System.out.println("Session Date:");
            String date = scan.nextLine();
            System.out.println("Session start time:");
            String startTime = scan.nextLine();
            System.out.println("Session end time:");
            String endTime = scan.nextLine();
            classDetailsStore.reserveSession(grade,className,new Session(date,startTime,endTime));

            System.out.println("1. Number of students:");
            int studentCount = scan.nextInt();
            scan.nextLine();

            while (studentCount>0){
                System.out.println("Enter student Id");
                System.out.println("Student Id:");
                String id = scan.nextLine();
                studentCount--;

                classDetailsStore.addStudents(grade,className,id);

            }

            System.out.println(classDetailsStore);

    }

    public static void markAttendance(){
        System.out.println("1. Enter grade:");
        int grade = scan.nextInt();
        scan.nextLine();
        System.out.println("2. Enter class name:");
        String className = scan.nextLine();
//        System.out.println("Session Date:");
//        String date = scan.nextLine();
//        System.out.println("Session start time:");
//        String startTime = scan.nextLine();
//        System.out.println("Session end time:");
//        String endTime = scan.nextLine();


        for (String sessionName : classDetailsStore.getSessionName(grade,className)){
            System.out.println(sessionName);
        }
        System.out.println("Type session name:");
            String name = scan.nextLine();

        System.out.println("Number of attendees");
        int numberOfAttendees = scan.nextInt();
        scan.nextLine();

        List<String> attendeesID = new ArrayList<>();
        while (numberOfAttendees>0){
            System.out.println("Enter student Id");
            System.out.println("Student Id:");
            String id = scan.nextLine();
            numberOfAttendees--;
            attendeesID.add(id);
        }
          classDetailsStore.markAttendance(grade,className,name,attendeesID);

        attendeesID.clear();
        System.out.println(classDetailsStore);

    }



}

