package com.example.lms_project.exception;

public class ServerBadRequestException extends RuntimeException{
    public ServerBadRequestException(String message){
        super(message);
    }
}
