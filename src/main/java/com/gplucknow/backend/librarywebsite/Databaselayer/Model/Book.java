package com.gplucknow.backend.librarywebsite.Databaselayer.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.Year;

/**
 *  book
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Books")
public class Book {
    @Id
    private int id;
    @Field(name = "bookcode")
    private String Bookcode;
    @Field(name = "name")
    private String name;
    @Field(name="cat1")
    private String cat1;
    @Field(name = "cat2")
    private String cat2;
    @Field(name = "cat3")
    private String cat3;
    private String Author1;
    private String Author2;
    private String Author3;
    private String Author4;
    private String Author5;
    private String publication;
    private Year publishingdate;
    private int pages;
    private String Firstpageurl;
}
