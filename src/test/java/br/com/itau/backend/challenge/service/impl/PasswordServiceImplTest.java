package br.com.itau.backend.challenge.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PasswordServiceImplTest {

    private static PasswordServiceImpl passwordServiceImplTest;

    @BeforeAll
    public static void init() {
        passwordServiceImplTest = new PasswordServiceImpl();
    }

    @Test
    void validaBase64(){
        String teste = "dGVzdGU=";
        Assertions.assertEquals("teste", passwordServiceImplTest.decode(teste));
        //Valida texto com \
        String teste2 = "XHRlc3RlXA==";
        Assertions.assertEquals("\\teste\\", passwordServiceImplTest.decode(teste2));
    }

    @Test
    void validacoesDaSenha() {
        boolean v1 = passwordServiceImplTest.validPassword("");
        Assertions.assertFalse(v1);
        boolean v2 = passwordServiceImplTest.validPassword("YWE=");
        Assertions.assertFalse(v2);
        boolean v3 = passwordServiceImplTest.validPassword("YWI=");
        Assertions.assertFalse(v3);
        boolean v4 = passwordServiceImplTest.validPassword("QUFBYmJiQ2M=");
        Assertions.assertFalse(v4);
        boolean v5 = passwordServiceImplTest.validPassword("QWJUcDkhZm9v");
        Assertions.assertFalse(v5);
        boolean v6 = passwordServiceImplTest.validPassword("QWJUcDkhZm9B");
        Assertions.assertFalse(v6);
        boolean v7 = passwordServiceImplTest.validPassword("QWJUcDkgZm9r");
        Assertions.assertFalse(v7);
        boolean v8 = passwordServiceImplTest.validPassword("AbTp9%21fok");
        Assertions.assertTrue(v8);
    }
}