package br.com.itau.backend.challenge.service.impl;

import br.com.itau.backend.challenge.service.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Override
    public ResponseEntity<Object> isValid(String password) {
        ResponseEntity responseEntity = null;
        try {
            String passwordFinal = decode(password);
            boolean b = validPassword(passwordFinal);
            if (b) {
                LOG.info("Senha valida");
            } else {
                LOG.info("Senha invalida");
            }
            responseEntity = ResponseEntity.ok(b);
        } catch (Exception e) {
            responseEntity = ResponseEntity.internalServerError().body("Erro na validação");
        }
        return responseEntity;
    }

    protected String decode(String password) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(password);
        return new String(decode);
    }

    public boolean validPassword(String password) {
        /**
         * 9 ou mais Caracteres = [a-zA-Z0-9!@#$%^&*()-+]{9,}
         * Ao menos 1 dígito = ?=.\\d
         * Ao menos 1 letra minúscula = ?=.\\d[a-z]
         * Ao menos 1 letra maiúscula = ?=.\\d[A-Z]
         * Ao menos 1 caractere especial = ?=[\.\*\!@#\$%\^&\\(\)\-\+]
         * Não possuir caracteres repetidos dentro do conjunto = ?!\w*.*\1
         *  \w = qualquer caracter
         *  \1 = primeiro grupo de captura
         * Inicio e fim de linha = ^$
         * \ = anula metacaracteres
         *
         * ^(?=.*[\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[\.\*\!@#\$%\^&\\\(\)\-\+])(?:([0-9a-zA-Z\.\*\!@#\$%\^&\\\(\)\-\+])(?!\w*.*\1)){9,}$
         */
        Pattern pattern = Pattern.compile(
                "^(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\.\\*\\!@#\\$%\\^&\\(\\)\\-\\+])" +
                        "(?:([0-9a-zA-Z\\.\\*\\!@#\\$%\\^&\\(\\)\\-\\+])(?!\\w*.*\\1)){9,}$");
        return pattern.matcher(password).find();
    }
}
