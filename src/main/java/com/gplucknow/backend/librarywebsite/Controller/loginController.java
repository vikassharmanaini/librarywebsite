package com.gplucknow.backend.librarywebsite.Controller;

import com.gplucknow.backend.librarywebsite.Entity.loginStudent;
import com.gplucknow.backend.librarywebsite.service.studentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class loginController {
    @Autowired
    private studentServiceInterface st;
    @PostMapping("/login")
    public ResponseEntity<?> loging(@RequestBody loginStudent lg){
        return this.st.logingenerate(lg);
    }
    @GetMapping("/mydata/{UserToken}")
    public ResponseEntity<?> Studentdata(@PathVariable String UserToken){
        return this.st.getStudentdata(UserToken);
    }
}
