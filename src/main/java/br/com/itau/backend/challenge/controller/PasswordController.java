package br.com.itau.backend.challenge.controller;

import br.com.itau.backend.challenge.service.impl.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/passwords")
public class PasswordController {

    @Autowired
    private PasswordServiceImpl service;

    @GetMapping(path = "password/valid/{password}")
    public ResponseEntity<Object> isValid(@PathVariable String password) {
        return service.isValid(password);
    }

}
