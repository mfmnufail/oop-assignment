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

  



   


}
