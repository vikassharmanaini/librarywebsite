package com.gplucknow.backend.librarywebsite.service.ImlimentsService;


import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Student;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.StudentRepo;
import com.gplucknow.backend.librarywebsite.Entity.loginStudent;
import com.gplucknow.backend.librarywebsite.Entity.visibalStudent;
import com.gplucknow.backend.librarywebsite.service.studentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginServices implements studentServiceInterface {
    @Autowired
    private StudentRepo studentRepo;

@Override
    public ResponseEntity<?> logingenerate(loginStudent lg){
        List<Student> student= this.studentRepo.findByEnrollnumber(lg.getEnrollnumber());
        if (student.size()>0 && student.get(0).getDob().equals(lg.getDob())){
            return new ResponseEntity<>(student.get(0).getUserToken(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
        }
    }

@Override
    public ResponseEntity<?> getStudentdata(String UserToken){
        List<Student> studentList= this.studentRepo.findByUserToken(UserToken);
        if (studentList.size()>0){
            Student s=studentList.get(0);
            visibalStudent vs=new visibalStudent(s.getEnrollnumber(),s.getName(),s.getDob(),s.getProfile_img(),s.getAddress(),s.getBranch());
            return new ResponseEntity<visibalStudent>(vs,HttpStatus.OK );
        }
        else{
            return new ResponseEntity<>("Invalid Token",HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
