package com.gplucknow.backend.librarywebsite.Databaselayer.AdminController;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import com.gplucknow.backend.librarywebsite.Databaselayer.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admincode/book")
public class BookController {
    @Autowired
    private BookService book;
    @GetMapping("/")
    public String intial(){
        return "Jai Shree Ram";
    }
    @GetMapping("/get")
    public ResponseEntity<?> getall(){
        return this.book.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getbyid(@PathVariable Integer id) throws ResourceAccessException{
        return this.book.getbyid(id);
    }
    @PostMapping("/add")
    public Book createbook(@RequestBody Book book){
        book.setId((book.getName()+book.getFirstpageurl()).hashCode());
        return this.book.createbook(book);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id,@RequestBody Book book){
        return this.book.update(id,book);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deletebookbyId(Integer id)throws ResourceAccessException{
        return this.book.deletebookbyId(id);
    }
    @DeleteMapping("/delete")
    public Map<String,Boolean> deleteallbook(){
        return this.book.deleteallbook();
    }
}
