package com.gplucknow.backend.librarywebsite.Databaselayer.Service.implimented;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Student;
import com.gplucknow.backend.librarywebsite.Databaselayer.Model.UserBook;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.StudentRepo;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.mybooksrepo;
import com.gplucknow.backend.librarywebsite.Databaselayer.Service.StudentSevice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import javax.management.Query;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class Studentimpli implements StudentSevice {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private mybooksrepo mybooksrepo;
    @Override
    public Student getstudentbyId(int id) {
        return this.studentRepo.findById(id).orElseThrow(()->new ResourceAccessException("Invalid ID : "+id));
    }

    @Override
    public ResponseEntity<?> getallstudent() {
        List <Student> t=this.studentRepo.findAll();
        if(t.size()>0)
            return new ResponseEntity<List<Student>>(t, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Student yet",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> createStudent(Student s){
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date=new Date();
        s.setUserToken(s.getEnrollnumber()+formatter.format(date));
        this.studentRepo.insert(s);
        UserBook us=new UserBook(s.getUserToken().hashCode(),s.getUserToken(),0, Collections.emptyList());
        this.mybooksrepo.insert(us);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateStudentbyId( Student s) {
        return ResponseEntity.ok(this.studentRepo.save(s));
    }

    @Override
    public void deletebyID(int id) {
        this.studentRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.studentRepo.deleteAll();
    }


}
