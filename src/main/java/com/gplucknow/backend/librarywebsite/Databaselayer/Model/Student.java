package com.gplucknow.backend.librarywebsite.Databaselayer.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
public class Student {
    //Basic Student Enrollement Number
    @Id
    private int id;
    //Basic Student Enrollement Number without E
    @Field(name = "enrollnumber")
    private String enrollnumber;
    //Student Name
    @Field(name="name")
    private String name;
    //Student Branch
    @Field(name = "branch")
    private String branch;
    private String dob;
    //Student last fees Transection ID
    private String feestransectionid;
    //Student Last year Roll number or Ragistration Number
    private String LastRollnumber;
    //Student Last year Marks
    private String LastResultMarks;
    //Student Mobile Number
    private Long MobileNumber;
    //Student Profile Image
    private String Profile_img;
    //Student User Token
    @Field(name = "userToken")
    private String userToken;
    //Student Last Device IP Address
    private String IPAddress;
    private String address;
}
