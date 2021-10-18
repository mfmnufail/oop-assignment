package org.example;

import org.example.Student.Student;
import org.example.Student.StudentInMemoryStore;
import org.example.Student.StudentStore;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StudentStoreTest {

     @Test
    public void should_ThrowNull_when_StudentNotExistInTheInMemoryStore(){
         StudentStore store = new StudentInMemoryStore();
         String id = "1234";
         assertThat(store.getStudent(id), is(null));
     }

     @Test
    public void should_StoreStudent_when_NewStudentIsParsed(){
         StudentStore store = new StudentInMemoryStore();
         store.addStudent("1234","John","1997.01.01","2021.10.15");
         assertThat(store.getAllStudents(), hasSize(1));
     }

     @Test
    public void should_StoredStudentAvailableInTheList_when_GetAllTheStudents(){
         StudentStore store = new StudentInMemoryStore();
         Student student = new Student("1234","John","1997.01.01","2021.10.15");
         store.addStudent("1234","John","1997.01.01","2021.10.15");
         assertThat(store.getAllStudents(), contains(student));
     }

     @Test
    public void should_StoreStudentsInOrder_when_GetAllStudent(){
         StudentStore store = new StudentInMemoryStore();
         Student student1 = new Student("1234","John","1997.01.01","2021.10.15");
         Student student2 = new Student("4321","Michael","1997.01.01","2021.10.15");
         store.addStudent("1234","John","1997.01.01","2021.10.15");
         store.addStudent("4321","Michael","1997.01.01","2021.10.15");
         assertThat(store.getAllStudents(), containsInRelativeOrder(student1,student2));
     }

     @Test
    public void should_GetStudentReturn_when_StudentIdIsParsed(){
         StudentStore store = new StudentInMemoryStore();
         Student student1 = new Student("1234","John","1997.01.01","2021.10.15");
         Student student2 = new Student("4321","Michael","1997.01.01","2021.10.15");
         store.addStudent("1234","John","1997.01.01","2021.10.15");
         store.addStudent("4321","Michael","1997.01.01","2021.10.15");
         assertThat(store.getStudent("1234"), equalTo(student1));
         assertThat(store.getStudent("4321"), equalTo(student2));
     }




}
