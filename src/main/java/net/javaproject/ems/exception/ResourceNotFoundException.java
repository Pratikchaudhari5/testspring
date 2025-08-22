package net.javaproject.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    // suppose employee with id  is not present then give custom exception
    public ResourceNotFoundException(String message){
        super(message);
    }
}
