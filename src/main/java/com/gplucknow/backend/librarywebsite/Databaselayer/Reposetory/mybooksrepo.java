package com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.UserBook;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface mybooksrepo extends MongoRepository<UserBook,Integer> {
    List<UserBook> findByUsertoken(String usertoken);
}
