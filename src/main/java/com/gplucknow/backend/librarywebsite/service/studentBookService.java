package com.gplucknow.backend.librarywebsite.service;

import org.springframework.http.ResponseEntity;

public interface studentBookService {
    public ResponseEntity<?> getmybookservice(String token);
    public ResponseEntity<?> addbooktomylibrary(String bookcode,String userToken);
}
