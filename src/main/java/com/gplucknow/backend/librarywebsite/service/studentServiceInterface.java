package com.gplucknow.backend.librarywebsite.service;

import com.gplucknow.backend.librarywebsite.Entity.loginStudent;
import org.springframework.http.ResponseEntity;

public interface studentServiceInterface {
    public ResponseEntity<?> logingenerate(loginStudent lg);
    public ResponseEntity<?> getStudentdata(String UserToken);
}
