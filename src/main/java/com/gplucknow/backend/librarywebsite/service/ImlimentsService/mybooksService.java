package com.gplucknow.backend.librarywebsite.service.ImlimentsService;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import com.gplucknow.backend.librarywebsite.Databaselayer.Model.UserBook;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.BookRepo;
import com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory.mybooksrepo;
import com.gplucknow.backend.librarywebsite.Entity.bookforuser;
import com.gplucknow.backend.librarywebsite.service.studentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class mybooksService implements studentBookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private mybooksrepo mybooksrepo;


    @Override
    public ResponseEntity<?> getmybookservice(String token){
        List<UserBook> userBooks=this.mybooksrepo.findByUsertoken(token);
        if (userBooks.size()>0){
            return new ResponseEntity<>(userBooks.get(0).getBook(), HttpStatus.OK);
        }
        else{
            return ResponseEntity.badRequest().body("Not Found");
        }
    }

    @Override
    public ResponseEntity<?> addbooktomylibrary(String bookcode,String userToken){
        List<UserBook> userBooks=this.mybooksrepo.findByUsertoken(userToken);
        List<Book> booo=this.bookRepo.findByBookcode(bookcode);
        if(userBooks.size()>0 && userBooks.get(0).getNumberofBook()<20 && booo.size()>0) {
            bookforuser bookforuser=new bookforuser(booo.get(0).getName(),booo.get(0).getBookcode());
            userBooks.get(0).getBook().add(bookforuser);
            UserBook userBook=new UserBook(userBooks.get(0).getId(), userToken,userBooks.get(0).getNumberofBook()+1,userBooks.get(0).getBook());
            return ResponseEntity.ok(userBook);
        }
        else
            return ResponseEntity.badRequest().body("Delete you books");
    }


    public ResponseEntity<?> deletemybook(String Usertoken,String Bookcode){
        List<UserBook> userBookList= this.mybooksrepo.findByUsertoken(Usertoken);
        if (userBookList.size()>0){
            UserBook userBook=userBookList.get(0);
            List<bookforuser> bookforuserList = new java.util.ArrayList<>(Collections.emptyList());
            for (int i = 0; i < userBook.getNumberofBook(); i++) {
                if (!userBook.getBook().get(i).getBookCode().equals(Bookcode)) {
                    bookforuser bf=new bookforuser(userBook.getBook().get(i).getBookname(),userBook.getBook().get(i).getBookCode());
                    bookforuserList.add(bf);
                }
            }
            userBook.setBook(bookforuserList);
            return ResponseEntity.ok(this.mybooksrepo.save(userBook));
        }else
            return ResponseEntity.badRequest().body("Not Found");
    }
}
