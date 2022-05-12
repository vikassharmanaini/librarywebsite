package com.gplucknow.backend.librarywebsite.Databaselayer.Service;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import java.util.Map;

public interface BookService {
    public ResponseEntity<?> getall();
    public ResponseEntity<?> getbyid(Integer id) throws ResourceAccessException;
    public Book createbook(Book book);
    public ResponseEntity<Book> update(Integer id,Book book);
    public Map<String, Boolean> deletebookbyId(Integer id)throws ResourceAccessException;
    public Map<String,Boolean> deleteallbook();
}
