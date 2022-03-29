package br.com.itau.backend.challenge.service;

import org.springframework.http.ResponseEntity;

public interface PasswordService {

    ResponseEntity<Object> isValid(String password);

}
