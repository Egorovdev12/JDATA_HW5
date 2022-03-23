package com.example.jdata_hw5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person is not found")
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException() {
        super();
    }
}