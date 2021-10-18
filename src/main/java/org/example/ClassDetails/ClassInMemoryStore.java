package org.example.ClassDetails;

import org.example.Student.StudentStore;

import java.util.*;

public class ClassInMemoryStore implements ClassDetailsStore{

    Map<Integer, List<ClassDetails>> classDetails = new HashMap<>();
    private final StudentStore studentStore;

    public ClassInMemoryStore(StudentStore studentStore) {
        this.studentStore = studentStore;
    }

    @Override
    public ClassDetails getClassDetails(int grade, String className) {

        if (classDetails.containsKey(grade)){
            for (List<ClassDetails> s : classDetails.values()){
                if (s.stream().noneMatch(c -> c.getClassName().equals(className))){
                    return s.stream().filter(d -> d.getClassName().equals(className)).findFirst().get();
                }
            }

        }
        return null;
    }

    @Override
    public void addClassDetails(int grade, int year, String className, String teacherName) {
        if (!classDetails.containsKey(grade)){
            List<ClassDetails> list = new ArrayList<>();
            list.add(new ClassDetails(year,className,teacherName,studentStore));
            classDetails.put(grade,list);
        }else {
            List<ClassDetails> list = classDetails.get(grade);
            list.add(new ClassDetails(year,className,teacherName,studentStore));
            classDetails.put(grade, list);
        }
    }

    @Override
    public void addStudents(int grade, String className,String id) {

        if (!classDetails.containsKey(grade)){
            throw new RuntimeException("Grade not exist");
        }

        if (classDetails.containsKey(grade)){
            for (List<ClassDetails> s : classDetails.values()){
                if (s.stream().noneMatch(c -> c.getClassName().equals(className))){
                    throw new RuntimeException("Class name not exist");
                }

                ClassDetails foundClass = s.stream().filter(k -> k.getClassName().equals(className)).findFirst().get();
                foundClass.addStudent(id);

            }
        }

    }

    @Override
    public void reserveSession(int grade, String className, Session session) {
        if (!classDetails.containsKey(grade)){
            throw new RuntimeException("Grade not exist");
        }

        if (classDetails.containsKey(grade)){
            for (List<ClassDetails> s : classDetails.values()){
                if (s.stream().noneMatch(c -> c.getClassName().equals(className))){
                    throw new RuntimeException("Class name not exist");
                }

                ClassDetails foundClass = s.stream().filter(k -> k.getClassName().equals(className)).findFirst().get();
                foundClass.reserveSession(session);

            }
        }

    }

    public Set<String> getSessionName(int grade, String className){
        if (!classDetails.containsKey(grade)){
            throw new RuntimeException("Grade not exist");
        }

        if (classDetails.containsKey(grade)){
            for (List<ClassDetails> s : classDetails.values()){
                if (s.stream().noneMatch(c -> c.getClassName().equals(className))){
                    throw new RuntimeException("Class name not exist");
                }

                ClassDetails foundClass = s.stream().filter(k -> k.getClassName().equals(className)).findFirst().get();
               return foundClass.getSessions().keySet();

            }
        }

        return null;
    }

    @Override
    public void markAttendance(int grade, String className, String session,List<String> attendedStudents) {
        if (!classDetails.containsKey(grade)){
            throw new RuntimeException("Grade not exist");
        }

        if (classDetails.containsKey(grade)){
            for (List<ClassDetails> s : classDetails.values()){
                if (s.stream().noneMatch(c -> c.getClassName().equals(className))){
                    throw new RuntimeException("Class name not exist");
                }

                ClassDetails foundClass = s.stream().filter(k -> k.getClassName().equals(className)).findFirst().get();
                foundClass.markAttendance(session,attendedStudents);

            }
        }
    }

    @Override
    public String toString() {
        String s=  "\n CLASS DETAILS \n" ;

        for (Map.Entry<Integer,List<ClassDetails>> det : classDetails.entrySet()){
            int grade = det.getKey();
            List<ClassDetails> details = det.getValue();

            s = s + "Grade: " + grade;
            for (ClassDetails detail : details){
                s = s + detail;
            }
        }

        return s;

    }
}
