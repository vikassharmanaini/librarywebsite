package com.gplucknow.backend.librarywebsite.service;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import com.gplucknow.backend.librarywebsite.Databaselayer.Model.UserBook;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.BookRepo;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.mybooksrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class mypersonalbook {
    @Autowired
    private mybooksrepo bookRepo;
    @Autowired
    private BookRepo book;

    public ResponseEntity<?> findbytoken(String UserT){
        List<UserBook> ub=this.bookRepo.findByUsertoken(UserT);
        if (ub.size()>0){
          return new ResponseEntity<>(ub.get(1), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Bad Token Request",HttpStatus.BAD_REQUEST);
        }
    }
}
