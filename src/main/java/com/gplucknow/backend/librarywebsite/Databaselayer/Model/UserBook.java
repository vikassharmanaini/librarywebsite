package com.gplucknow.backend.librarywebsite.Databaselayer.Model;

import com.gplucknow.backend.librarywebsite.Entity.bookforuser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserBook")
public class UserBook {
    @Id
    private Integer id;
    @Field(name = "usertoken")
    private String usertoken;
    private Integer numberofBook;
    private List<bookforuser> book;
}