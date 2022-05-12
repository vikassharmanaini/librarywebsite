package com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepo extends MongoRepository<Book,Integer> {
    List<Book> findByName(String name);
    List<Book> findByCat1(String cat1);
    List<Book> findByCat2(String cat2);
    List<Book> findByCat3(String cat3);
    List<Book> findByBookcode(String bookcode);
}
