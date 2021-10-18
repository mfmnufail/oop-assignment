package org.example;

import org.example.ClassDetails.ClassDetails;
import org.example.ClassDetails.ClassDetailsStore;
import org.example.ClassDetails.ClassInMemoryStore;
import org.example.Student.Student;
import org.example.Student.StudentInMemoryStore;
import org.example.Student.StudentStore;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClassDetailsStoreTest {

    @Test
    public void should_StoreNewClass_when_NewClassIsParsed(){
        StudentStore studentStore = new StudentInMemoryStore();
        ClassDetailsStore classStore = new ClassInMemoryStore(studentStore);
        ClassDetails newClass = new ClassDetails(2021,"Maths","John",studentStore);
        classStore.addClassDetails(10,2021,"Maths","John");
        assertThat(classStore.getClassDetails().get(10), contains(newClass));
    }

    @Test
    public void should_StoreStudent_when_NewStudentIsParsedToClass(){
        StudentStore studentStore = new StudentInMemoryStore();
        ClassDetailsStore classStore = new ClassInMemoryStore(studentStore);
        Student student = new Student("1234","John","1997.01.01","2021.10.15");
        studentStore.addStudent("1234","John","1997.01.01","2021.10.15");
        ClassDetails newClass = new ClassDetails(2021,"Maths","John",studentStore);
        classStore.addStudents(10,"Maths","1234");
        assertThat(newClass.getStudentId().keySet(), containsInAnyOrder(student.getId()));
    }
	
    @Test
    public void should_StudentAttendanceEmptyUntilAttendToTheSession_when_CheckAttendanceList(){
        StudentStore studentStore = new StudentInMemoryStore();
        ClassDetailsStore classStore = new ClassInMemoryStore(studentStore);
        Student student = new Student("1234","John","1997.01.01","2021.10.15");
        studentStore.addStudent("1234","John","1997.01.01","2021.10.15");
        ClassDetails newClass = new ClassDetails(2021,"Maths","John",studentStore);
        classStore.addStudents(10,"Maths","1234");
        assertThat(newClass.getStudentId().get("1234"),equalTo(""));
    }



   


}
