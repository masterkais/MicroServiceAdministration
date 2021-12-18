package com.iit.imprimerie.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiBaseException{


    public NotFoundException(String message) {
        super(message);
    }
    public HttpStatus getStatusCode() {
    	return HttpStatus.NOT_FOUND;
    }
}