package com.gplucknow.backend.librarywebsite.Controller;

import com.gplucknow.backend.librarywebsite.service.studentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mybook")
public class MyAllBookController {
    @Autowired
    private studentBookService bookService;
    @GetMapping("/{token}")
    public ResponseEntity<?> getmybook(String token){
        return this.bookService.getmybookservice(token);
    }

    @GetMapping("/add/{bookcode}/{userToken}")
    public ResponseEntity<?> addbooktomylibrary(String bookcode,String userToken){
        return this.bookService.addbooktomylibrary(bookcode,userToken);
    }
}
