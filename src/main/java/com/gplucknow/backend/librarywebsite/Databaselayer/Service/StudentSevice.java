package com.gplucknow.backend.librarywebsite.Databaselayer.Service;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentSevice {
    public Student getstudentbyId(int id);
    public ResponseEntity<?> getallstudent();
    public ResponseEntity<?> createStudent(Student s);
    public ResponseEntity<?> updateStudentbyId(Student s);
    public void deletebyID(int id);
    public void deleteAll();
//    public List<Student> findviaid(String enrollnumber);
}
