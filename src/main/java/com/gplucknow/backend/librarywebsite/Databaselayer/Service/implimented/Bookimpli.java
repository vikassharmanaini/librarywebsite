package com.gplucknow.backend.librarywebsite.Databaselayer.Service.implimented;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.BookRepo;
import com.gplucknow.backend.librarywebsite.Databaselayer.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bookimpli implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public ResponseEntity<?> getall() {
        List<Book> b = this.bookRepo.findAll();
        if (b.size() > 0)
            return new ResponseEntity<List<Book>>(b, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Student yet", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getbyid(Integer id) throws ResourceAccessException {
        Book b = this.bookRepo.findById(id).orElseThrow(() -> new ResourceAccessException("Book not found"));
        return ResponseEntity.ok().body(b);
    }

    @Override
    public Book createbook(Book book) {
        return this.bookRepo.insert(book);
    }
    @Override
    public ResponseEntity<Book> update(Integer id, Book book) {
        Book bo = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Entity of this id not found : " + id));
        bo.setName(book.getName());
        bo.setBookcode(book.getBookcode());
        bo.setAuthor1(book.getAuthor1());
        bo.setAuthor2(book.getAuthor2());
        bo.setAuthor3(book.getAuthor3());
        bo.setAuthor4(book.getAuthor4());
        bo.setAuthor5(book.getAuthor5());
        bo.setCat1(book.getCat1());
        bo.setCat2(book.getCat2());
        bo.setCat3(book.getCat3());
        bo.setPublication(book.getPublication());
        bo.setPublishingdate(book.getPublishingdate());
        bo.setPages(book.getPages());
        bo.setFirstpageurl(book.getFirstpageurl());
        final Book updatebook = this.bookRepo.save(bo);
        return ResponseEntity.ok(updatebook);
    }

    @Override
    public Map<String, Boolean> deletebookbyId(Integer id) throws ResourceAccessException {
        Book bo = this.bookRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Book Not Found ID :- " + id));
        this.bookRepo.delete(bo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Map<String, Boolean> deleteallbook() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("All Records are Deleted ", Boolean.TRUE);
        return response;
    }

    // public ResponseEntity<?> findbookbyname(String Name){
    // List<Book> boo= this.bookRepo.findByName(Name);
    // if (boo.size()>0)
    // return ResponseEntity.ok(boo);
    // else
    // return new ResponseEntity<>("Book named "+boo+" not
    // Found",HttpStatus.NOT_FOUND);
    // }
    //
    // public ResponseEntity<?> findbookbycat1(String cat1){
    // List<Book> boo= this.bookRepo.findByCat1(cat1);
    // if (boo.size()>0)
    // return ResponseEntity.ok(boo);
    // else
    // return new ResponseEntity<>("Book named "+boo+" not
    // Found",HttpStatus.NOT_FOUND);
    // }
    //
    // public ResponseEntity<?> findbookbycat2(String cat2){
    // List<Book> boo= this.bookRepo.findByCat2(cat2);
    // if (boo.size()>0)
    // return ResponseEntity.ok(boo);
    // else
    // return new ResponseEntity<>("Book named "+boo+" not
    // Found",HttpStatus.NOT_FOUND);
    // }
    //
    // public ResponseEntity<?> findbookbycat3(String cat3){
    // List<Book> boo= this.bookRepo.findByCat3(cat3);
    // if (boo.size()>0)
    // return ResponseEntity.ok(boo);
    // else
    // return new ResponseEntity<>("Book named "+boo+" not
    // Found",HttpStatus.NOT_FOUND);
    // }
}
