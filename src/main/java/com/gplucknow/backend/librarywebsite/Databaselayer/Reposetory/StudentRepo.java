package com.gplucknow.backend.librarywebsite.Databaselayer.Reposetory;

import com.gplucknow.backend.librarywebsite.Databaselayer.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepo extends MongoRepository<Student, Integer> {
    List<Student> findByEnrollnumber(String enrollnumber);
    List<Student> findByName(String name);
    List<Student> findByBranch(String branch);
    List<Student> findByUserToken(String userToken);

}
