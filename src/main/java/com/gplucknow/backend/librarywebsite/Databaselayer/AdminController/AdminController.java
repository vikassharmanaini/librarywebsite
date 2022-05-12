package com.gplucknow.backend.librarywebsite.Databaselayer.AdminController;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Student;
import com.gplucknow.backend.librarywebsite.Databaselayer.Service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admincode/api/student")
public class AdminController {
    @Autowired
    private StudentSevice st;


    /** Service Initialization **/
    @GetMapping("/ShreeGaneshyaNamh")
    public String intialization(){
        return "Jai Shree Ram";
    }


    /** Get all Students**/
    @GetMapping("/")
    public ResponseEntity<?> allStudent(){
        return this.st.getallstudent();
    }


    /** Get Student by ID **/
    @GetMapping("/{id}")
    public Student FindStudent(@PathVariable int id){
        return this.st.getstudentbyId(id);
    }




    /** Add Student **/
    @PostMapping("/add")
    public ResponseEntity<?> CreateStudent(@RequestBody Student student){
        return this.st.createStudent(student);
    }




    /** Update Student **/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Student student){
        System.out.println("\n hello\n");
       return this.st.updateStudentbyId(student);
    }




    /** Delete Student **/
    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable int id){
        this.st.deletebyID(id);
    }




    /** Delete All Studente **/
    @DeleteMapping("/delete")
    public void DeleteAll(){
        this.st.deleteAll();
    }


    /** Find by field*/
//    @GetMapping("/st/{enrollnumber}")
//    public List<Student> findviaid( @PathVariable String enrollnumber){
//        return this.st.findviaid(enrollnumber);
//    }
}
